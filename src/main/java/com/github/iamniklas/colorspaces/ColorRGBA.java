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

    public int r;
    public int g;
    public int b;
    public int a;

    public ColorRGBA(int _r, int _g, int _b, int _a) {
        r = _r;
        g = _g;
        b = _b;
        a = _a;
    }

    public ColorRGBA dim(float _percentage) {
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

    @Override
    public ColorRGB toRGB() {
        return new ColorRGB(
                (255-a) * ColorRGB.BLACK.r + (a/255) * r,
                (255-a) * ColorRGB.BLACK.g + (a/255) * g,
                (255-a) * ColorRGB.BLACK.b + (a/255) * b
        );
    }

    public ColorRGB toRGB(ColorRGB _back) {
        ColorRGB result = new ColorRGB(
                (int)((1 - a / 255.0f) * _back.r + (a/255.0f) * r),
                (int)((1 - a / 255.0f) * _back.g + (a/255.0f) * g),
                (int)((1 - a / 255.0f) * _back.b + (a/255.0f) * b)
        );

        result.r = Math.max(0, Math.min(result.r, 255));
        result.g = Math.max(0, Math.min(result.g, 255));
        result.b = Math.max(0, Math.min(result.b, 255));

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
