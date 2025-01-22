package com.github.iamniklas.colorspaces;

/**
 * The ColorRGBA class represents a color with red, green, blue, and alpha (transparency) components.
 * It provides methods for color manipulation and conversion to other color spaces.
 */
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

    /**
     * Constructs a ColorRGBA object with the specified red, green, blue, and alpha values.
     *
     * @param _r the red component (0-255)
     * @param _g the green component (0-255)
     * @param _b the blue component (0-255)
     * @param _a the alpha component (0-255)
     * @throws IllegalArgumentException if any component is out of range (0-255)
     */
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

    /**
     * Dims the color by the specified percentage.
     *
     * @param _percentage the percentage to dim (0.0-1.0)
     * @return a new ColorRGBA object with the dimmed color
     * @throws IllegalArgumentException if the percentage is out of range (0.0-1.0)
     */
    public ColorRGBA dim(float _percentage) {
        if(!RangeCheck.inRange(_percentage, 0, 1.0f)) { throw new IllegalArgumentException("ColorRGBA: dim percentage out of range: " + _percentage); }
        return new ColorRGBA(
                (int)(r * _percentage),
                (int)(g * _percentage),
                (int)(b * _percentage),
                (int)(a * _percentage)
        );
    }

    /**
     * Dims the color by another ColorRGBA object.
     *
     * @param _c the ColorRGBA object to dim by
     * @return a new ColorRGBA object with the dimmed color
     */
    public ColorRGBA dim(ColorRGBA _c) {
        return new ColorRGBA(
                (r * _c.r) / 255,
                (g * _c.g) / 255,
                (b * _c.b) / 255,
                (a * _c.a) / 255
        );
    }

    // Getter methods for color components
    public int getR() { return r; }
    public int getG() { return g; }
    public int getB() { return b; }
    public int getA() { return a; }

    // Setter methods for color components with range checks
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

    /**
     * Converts this color to a ColorRGB object.
     *
     * @return the ColorRGB representation of this color
     */
    @Override
    public ColorRGB toRGB() {
        return new ColorRGB(
                (255-a) * ColorRGB.BLACK.getR() + (a/255) * r,
                (255-a) * ColorRGB.BLACK.getB() + (a/255) * g,
                (255-a) * ColorRGB.BLACK.getG() + (a/255) * b
        );
    }

    /**
     * Converts this color to a ColorRGB object with a specified background color.
     *
     * @param _back the background color
     * @return the ColorRGB representation of this color with the background
     */
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

    /**
     * Converts this color to a ColorRGBA object.
     *
     * @return this ColorRGBA object
     */
    @Override
    public ColorRGBA toRGBA() { return this; }

    /**
     * Converts this color to a ColorHSV object.
     *
     * @return the ColorHSV representation of this color
     */
    @Override
    public ColorHSV toHSV() {
        return toRGB().toHSV();
    }

    /**
     * Returns a string representation of this color.
     *
     * @return a string representation of this color
     */
    @Override
    public String toString() {
        return "ColorRGBA{" + "r=" + r + ", g=" + g + ", b=" + b + ", a=" + a + '}';
    }
}
