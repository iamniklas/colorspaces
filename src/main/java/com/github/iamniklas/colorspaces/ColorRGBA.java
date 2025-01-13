package com.github.iamniklas.colorspaces;


public class ColorRGBA implements ColorConverters {
    public static final ColorRGBA BLACK =        new ColorRGBA(0,0,0,255);
    public static final ColorRGBA WHITE =        new ColorRGBA(255,255,255,255);
    public static final ColorRGBA WHITE50 =      new ColorRGBA(128,128,128,255);
    public static final ColorRGBA RED =          new ColorRGBA(255,0,0,255);
    public static final ColorRGBA ORANGE =       new ColorRGBA(255,128,0,255);
    public static final ColorRGBA YELLOW =       new ColorRGBA(255,255,255,255);
    public static final ColorRGBA LIGHT_GREEN =  new ColorRGBA(128,255,0,255);
    public static final ColorRGBA GREEN =        new ColorRGBA(0,255,0,255);
    public static final ColorRGBA LIME_GREEN =   new ColorRGBA(0,255,128,255);
    public static final ColorRGBA CYAN =         new ColorRGBA(0,255,255,255);
    public static final ColorRGBA LIGHT_BLUE =   new ColorRGBA(0,128,255,255);
    public static final ColorRGBA BLUE =         new ColorRGBA(0,0,255,255);
    public static final ColorRGBA PURPLE =       new ColorRGBA(128,0,255,255);
    public static final ColorRGBA PINK =         new ColorRGBA(255,0,255,255);
    public static final ColorRGBA MAGENTA =      new ColorRGBA(255,0,128,255);

    private int r;
    private int g;
    private int b;
    private int a;

    public ColorRGBA(int _r, int _g, int _b, int _a) {
        if(!RangeCheck.inRange(_r, 0, 255)) { throw new IllegalArgumentException("ColorRGBA: r value out of range: " + _r); }
        if(!RangeCheck.inRange(_g, 0, 255)) { throw new IllegalArgumentException("ColorRGBA: g value out of range: " + _g); }
        if(!RangeCheck.inRange(_b, 0, 255)) { throw new IllegalArgumentException("ColorRGBA: b value out of range: " + _b); }
        if(!RangeCheck.inRange(_a, 0, 255)) { throw new IllegalArgumentException("ColorRGBA: a value out of range: " + _a); }
        r = _r;
        g = _g;
        b = _b;
        a = _a;
    }

    public ColorRGBA dim(float _percentage) {
        if(!RangeCheck.inRange(_percentage, 0, 1.0f)) { throw new IllegalArgumentException("ColorRGBA: dim percentage out of range: " + _percentage); }
        return new ColorRGBA(
                (int)(r * _percentage),
                (int)(g * _percentage),
                (int)(b * _percentage),
                (int)(a * _percentage)
        );
    }

    public ColorRGBA dim(ColorRGBA _c) {
        return new ColorRGBA(
                (r * _c.r) / 255,
                (g * _c.g) / 255,
                (b * _c.b) / 255,
                (a * _c.a) / 255
        );
    }

    public int getR() { return r; }
    public int getG() { return g; }
    public int getB() { return b; }
    public int getA() { return a; }

    public void setR(int r) {
        if(!RangeCheck.inRange(r, 0, 255)) { throw new IllegalArgumentException("ColorRGBA: r value out of range: " + r); }
        this.r = r;
    }

    public void setG(int g) {
        if(!RangeCheck.inRange(g, 0, 255)) { throw new IllegalArgumentException("ColorRGBA: g value out of range: " + g); }
        this.g = g;
    }

    public void setB(int b) {
        if(!RangeCheck.inRange(b, 0, 255)) { throw new IllegalArgumentException("ColorRGBA: b value out of range: " + b); }
        this.b = b;
    }

    public void setA(int a) {
        if(!RangeCheck.inRange(a, 0, 255)) { throw new IllegalArgumentException("ColorRGBA: a value out of range: " + a); }
        this.a = a;
    }

    @Override
    public ColorRGB toRGB() {
        return new ColorRGB(
                (255-a) * ColorRGB.BLACK.getR() + (a/255) * r,
                (255-a) * ColorRGB.BLACK.getB() + (a/255) * g,
                (255-a) * ColorRGB.BLACK.getG() + (a/255) * b
        );
    }

    public ColorRGB toRGB(ColorRGB _back) {
        ColorRGB result = new ColorRGB(
                (int)((1 - a / 255.0f) * _back.getR() + (a/255.0f) * r),
                (int)((1 - a / 255.0f) * _back.getG() + (a/255.0f) * g),
                (int)((1 - a / 255.0f) * _back.getB() + (a/255.0f) * b)
        );

        result.setR(Math.max(0, Math.min(result.getR(), 255)));
        result.setG(Math.max(0, Math.min(result.getG(), 255)));
        result.setB(Math.max(0, Math.min(result.getB(), 255)));

        return result;
    }

    @Override
    public ColorRGBA toRGBA() { return this; }

    @Override
    public ColorHSV toHSV() {
        return toRGB().toHSV();
    }

    @Override
    public String toString() {
        return "ColorRGBA{" + "r=" + r + ", g=" + g + ", b=" + b + ", a=" + a + '}';
    }
}
