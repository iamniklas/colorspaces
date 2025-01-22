package com.github.iamniklas.colorspaces;

/**
 * Interface for color conversion methods.
 * Provides methods to convert a color to different color spaces.
 */
interface ColorConverters {
    /**
     * Converts this color to a ColorRGB object.
     *
     * @return the ColorRGB representation of this color
     */
    ColorRGB toRGB();

    /**
     * Converts this color to a ColorRGBA object.
     *
     * @return the ColorRGBA representation of this color
     */
    ColorRGBA toRGBA();

    /**
     * Converts this color to a ColorHSV object.
     *
     * @return the ColorHSV representation of this color
     */
    ColorHSV toHSV();
}