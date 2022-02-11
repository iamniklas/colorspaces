package com.github.iamniklas.colorspaces;

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

    public int h;
    public float s;
    public float v;

    public ColorHSV(int _h, float _s, float _v) {
        h = _h;
        s = _s;
        v = _v;
    }

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

    @Override
    public ColorRGBA toRGBA() { return toRGB().toRGBA(); }

    @Override
    public ColorHSV toHSV() { return this; }

    @Override
    public String toString() {
        return "ColorHSV{" + "h=" + h + ", s=" + s + ", v=" + v + '}';
    }
}