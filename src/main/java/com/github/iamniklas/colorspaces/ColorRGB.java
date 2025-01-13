package com.github.iamniklas.colorspaces;

public class ColorRGB implements ColorConverters {
    public static final ColorRGB BLACK =        new ColorRGB(0,0,0);
    public static final ColorRGB WHITE =        new ColorRGB(255,255,255);
    public static final ColorRGB WHITE50 =      new ColorRGB(128,128,128);
    public static final ColorRGB RED =          new ColorRGB(255,0,0);
    public static final ColorRGB ORANGE =       new ColorRGB(255,128,0);
    public static final ColorRGB YELLOW =       new ColorRGB(255,255,0);
    public static final ColorRGB LIGHT_GREEN =  new ColorRGB(128,255,0);
    public static final ColorRGB GREEN =        new ColorRGB(0,255,0);
    public static final ColorRGB LIME_GREEN =   new ColorRGB(0,255,128);
    public static final ColorRGB CYAN =         new ColorRGB(0,255,255);
    public static final ColorRGB LIGHT_BLUE =   new ColorRGB(0,128,255);
    public static final ColorRGB BLUE =         new ColorRGB(0,0,255);
    public static final ColorRGB PURPLE =       new ColorRGB(128,0,255);
    public static final ColorRGB PINK =         new ColorRGB(255,0,255);
    public static final ColorRGB MAGENTA =      new ColorRGB(255,0,128);

    private int r;
    private int g;
    private int b;

    public ColorRGB(int _r, int _g, int _b) {
        if(!RangeCheck.inRange(_r, 0, 255)) { throw new IllegalArgumentException("ColorRGB: r value out of range: " + _r); }
        if(!RangeCheck.inRange(_g, 0, 255)) { throw new IllegalArgumentException("ColorRGB: g value out of range: " + _g); }
        if(!RangeCheck.inRange(_b, 0, 255)) { throw new IllegalArgumentException("ColorRGB: b value out of range: " + _b); }
        r = _r;
        g = _g;
        b = _b;
    }

    public ColorRGB(ColorRGB _color) {
        if(!RangeCheck.inRange(_color.getR(), 0, 255)) { throw new IllegalArgumentException("ColorRGB: r value out of range: " + _color.getR()); }
        if(!RangeCheck.inRange(_color.getG(), 0, 255)) { throw new IllegalArgumentException("ColorRGB: g value out of range: " + _color.getG()); }
        if(!RangeCheck.inRange(_color.getB(), 0, 255)) { throw new IllegalArgumentException("ColorRGB: b value out of range: " + _color.getB()); }
        r = _color.r;
        g = _color.g;
        b = _color.b;
    }

    public int getR() { return r; }
    public int getG() { return g; }
    public int getB() { return b; }

    public void setR(int r) {
        if(!RangeCheck.inRange(r, 0, 255)) { throw new IllegalArgumentException("ColorRGB: r value out of range: " + r); }
        this.r = r;
    }

    public void setG(int g) {
        if(!RangeCheck.inRange(g, 0, 255)) { throw new IllegalArgumentException("ColorRGB: g value out of range: " + g); }
        this.g = g;
    }

    public void setB(int b) {
        if(!RangeCheck.inRange(b, 0, 255)) { throw new IllegalArgumentException("ColorRGB: b value out of range: " + b); }
        this.b = b;
    }

    public ColorRGB filter(ColorChannel _channel) {
        switch (_channel) {
            case Red: return new ColorRGB(0, g, b);
            case Green: return new ColorRGB(r, 0, b);
            case Blue: return new ColorRGB(r, g, 0);
            case Alpha: return new ColorRGB(0, 0, 0);
            default: return this;
        }
    }

    public ColorRGB overrideChannel(ColorChannel _channel, int _value) {
        if(!RangeCheck.inRange(_value, 0, 255)) { throw new IllegalArgumentException("Value must be between 0 and 255"); }
        switch (_channel) {
            case Red: return new ColorRGB(_value, g, b);
            case Green: return new ColorRGB(r, _value, b);
            case Blue: return new ColorRGB(r, g, _value);
            default: return this;
        }
    }

    public ColorRGB cutHigh(ColorChannel _channel, int _value) {
        if(!RangeCheck.inRange(_value, 0, 255)) { throw new IllegalArgumentException("Value must be between 0 and 255"); }
        switch (_channel) {
            case Red: return new ColorRGB(cutHigh(r, _value), g, b);
            case Green: return new ColorRGB(r, cutHigh(g, _value), b);
            case Blue: return new ColorRGB(r, g, cutHigh(b, _value));
            default: return this;
        }
    }

    public ColorRGB cutLow(ColorChannel _channel, int _value) {
        if(!RangeCheck.inRange(_value, 0, 255)) { throw new IllegalArgumentException("Value must be between 0 and 255"); }
        switch (_channel) {
            case Red: return new ColorRGB(cutLow(r, _value), g, b);
            case Green: return new ColorRGB(r, cutLow(g, _value), b);
            case Blue: return new ColorRGB(r, g, cutLow(b, _value));
            default: return this;
        }
    }

    private int cutHigh(int _value, int _cutter) { return Math.min(_value, _cutter); }

    private int cutLow(int _value, int _cutter) {
        return Math.max(_value, _cutter);
    }

    public ColorRGB dim(float _percentage) {
        if (!RangeCheck.inRange(_percentage, 0.0f, 100.0f)) { throw new IllegalArgumentException("Percentage must be between 0.0 and 100.0"); }
        return new ColorRGB((int)(r * _percentage), (int)(g * _percentage), (int)(b * _percentage));
    }
    public ColorRGB dim(float _r, float _g, float _b) {
        if(!RangeCheck.inRange(_r, 0.0f, 100.0f) || !RangeCheck.inRange(_g, 0.0f, 100.0f) || !RangeCheck.inRange(_b, 0.0f, 100.0f)) { throw new IllegalArgumentException("Percentage must be between 0.0 and 100.0"); }
        return new ColorRGB((int)(r * _r), (int)(g * _g), (int)(b * _b));
    }

    @Override
    public ColorRGB toRGB() { return this; }

    @Override
    public ColorRGBA toRGBA() { return new ColorRGBA(r, g, b, 255); }

    @Override
    public ColorHSV toHSV() {
        float relativeR = r / 255.0f;
        float relativeG = g / 255.0f;
        float relativeB = b / 255.0f;

        float v = Math.max(relativeR, Math.max(relativeG, relativeB));
        float cMin = Math.min(relativeR, Math.min(relativeG, relativeB));

        float cDelta = v - cMin;

        //HSV: H
        float h = 0.0f;
        if(v == relativeR) {
            h = 60 * (((relativeG - relativeB) / cDelta) % 6);
        } else if(v == relativeG) {
            h = 60 * (((relativeB - relativeR) / cDelta) + 2);
        } else if(v == relativeB) {
            h = 60 * (((relativeR - relativeG) / cDelta) + 4);
        }

        if(h < 0.0f) {
            h = 360.0f - Math.abs(h);
        }


        //HSV: S
        float s = 0.0f;
        if(v != 0.0f) {
            s = cDelta / v;
        }

        return new ColorHSV((int)h, s, v);
    }

    @Override
    public String toString() {
        return "ColorRGB{" + "r=" + r + ", g=" + g + ", b=" + b + '}';
    }
}
