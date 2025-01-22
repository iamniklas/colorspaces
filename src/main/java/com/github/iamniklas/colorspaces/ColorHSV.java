package com.github.iamniklas.colorspaces;

/**
 * The ColorHSV class represents a color in the HSV (Hue, Saturation, Value) color space.
 * It provides methods for color manipulation and conversion to other color spaces.
 */
public class ColorHSV implements ColorConverters {
    public static final ColorHSV BLACK =        new ColorHSV(0,0.0f,0.0f);
    public static final ColorHSV WHITE =        new ColorHSV(0,0.0f,1.0f);
    public static final ColorHSV WHITE50 =      new ColorHSV(0,0.0f,0.5f);
    public static final ColorHSV RED =          new ColorHSV(0,1.0f,1.0f);
    public static final ColorHSV ORANGE =       new ColorHSV(30,1.0f,1.0f);
    public static final ColorHSV YELLOW =       new ColorHSV(60,1.0f,1.0f);
    public static final ColorHSV LIGHT_GREEN =  new ColorHSV(90,1.0f,1.0f);
    public static final ColorHSV GREEN =        new ColorHSV(120,1.0f,1.0f);
    public static final ColorHSV LIME_GREEN =   new ColorHSV(150,1.0f,1.0f);
    public static final ColorHSV CYAN =         new ColorHSV(180,1.0f,1.0f);
    public static final ColorHSV LIGHT_BLUE =   new ColorHSV(210,1.0f,1.0f);
    public static final ColorHSV BLUE =         new ColorHSV(240,1.0f,1.0f);
    public static final ColorHSV PURPLE =       new ColorHSV(270,1.0f,1.0f);
    public static final ColorHSV PINK =         new ColorHSV(300,1.0f,1.0f);
    public static final ColorHSV MAGENTA =      new ColorHSV(330,1.0f,1.0f);

    private int h;
    private float s;
    private float v;

    /**
     * Constructs a ColorHSV object with the specified hue, saturation, and value.
     *
     * @param _h the hue component (0-360)
     * @param _s the saturation component (0.0-1.0)
     * @param _v the value component (0.0-1.0)
     * @throws IllegalArgumentException if any component is out of range
     */
    public ColorHSV(int _h, float _s, float _v) {
        if(!RangeCheck.inRange(_h, 0, 360)) { throw new IllegalArgumentException("Hue must be in the range of 0-360"); }
        if(!RangeCheck.inRange(_s, 0.0f, 1.0f)) { throw new IllegalArgumentException("Saturation must be in the range of 0.0-1.0"); }
        if(!RangeCheck.inRange(_v, 0.0f, 1.0f)) { throw new IllegalArgumentException("Value must be in the range of 0.0-1.0"); }
        h = _h;
        s = _s;
        v = _v;
    }

    // Getter methods for color components
    public int getH() { return h; }
    public float getS() { return s; }
    public float getV() { return v; }

    // Setter methods for color components with range checks
    public void setH(int h) {
        if(!RangeCheck.inRange(h, 0, 360)) { throw new IllegalArgumentException("Hue must be in the range of 0-360"); }
        this.h = h;
    }
    public void setS(float s) {
        if(!RangeCheck.inRange(s, 0.0f, 1.0f)) { throw new IllegalArgumentException("Saturation must be in the range of 0.0-1.0"); }
        this.s = s;
    }
    public void setV(float v) {
        if(!RangeCheck.inRange(v, 0.0f, 1.0f)) { throw new IllegalArgumentException("Value must be in the range of 0.0-1.0"); }
        this.v = v;
    }

    /**
     * Converts this color to a ColorRGB object.
     *
     * @return the ColorRGB representation of this color
     */
    @Override
    public ColorRGB toRGB() {
        int v255 = (int)(v * 255.0f);
        if(s == 0.0f) {
            return new ColorRGB(v255, v255, v255);
        }

        int hueInterval = (int)Math.floor(h / 60.0);
        float f = h / 60.0f - hueInterval;
        int p = (int)(v * (1 - s) * 255.0f);
        int q = (int)(v * (1 - s * f) * 255.0f);
        int t = (int)(v * (1 - s * (1 - f)) * 255.0f);

        switch (hueInterval) {
            case 0:
            case 6: return new ColorRGB(v255, t, p);
            case 1: return new ColorRGB(q, v255, p);
            case 2: return new ColorRGB(p, v255, t);
            case 3: return new ColorRGB(p, q, v255);
            case 4: return new ColorRGB(t, p, v255);
            case 5: return new ColorRGB(v255, p, q);
            default: return ColorRGB.BLACK;
        }
    }

    /**
     * Converts this color to a ColorRGBA object.
     *
     * @return the ColorRGBA representation of this color
     */
    @Override
    public ColorRGBA toRGBA() { return toRGB().toRGBA(); }

    /**
     * Converts this color to a ColorHSV object.
     *
     * @return this ColorHSV object
     */
    @Override
    public ColorHSV toHSV() { return this; }

    /**
     * Returns a string representation of this color.
     *
     * @return a string representation of this color
     */
    @Override
    public String toString() {
        return "ColorHSV{" + "h=" + h + ", s=" + s + ", v=" + v + '}';
    }
}