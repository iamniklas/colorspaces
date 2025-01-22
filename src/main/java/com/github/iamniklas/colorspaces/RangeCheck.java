package com.github.iamniklas.colorspaces;

class RangeCheck {
    static boolean inRange(int value, int min, int max) {
        return value >= min && value <= max;
    }
    static boolean inRange(float value, float min, float max) {
        return value >= min && value <= max;
    }
}
