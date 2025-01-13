package com.github.iamniklas.colorspaces;

public class RangeCheck {
    public static boolean inRange(int value, int min, int max) {
        return value >= min && value <= max;
    }
    public static boolean inRange(float value, float min, float max) {
        return value >= min && value <= max;
    }
}
