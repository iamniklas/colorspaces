package com.github.iamniklas.colorspaces;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InterpolationTest {

    //Test Configuration
    private static final float MAXIMUM_DEVIATION = 0.0000005f;


    @Test
    void testLinear() {
        float[] expectedValues = { 0.0f, 0.1f, 0.2f, 0.3f, 0.4f, 0.5f, 0.6f, 0.7f, 0.8f, 0.9f, 1.0f,};
        runTestCase(expectedValues, InterpolationType.Linear);
    }

    @Test
    void testEaseInSine() {
        float[] expectedValues = { 0.0f, 0.01231166f, 0.04894348f, 0.10899348f, 0.19098301f, 0.29289322f, 0.41221475f, 0.54600950f, 0.69098301f, 0.8435655f, 1.0f};
        runTestCase(expectedValues, InterpolationType.EaseInSine);
    }
    @Test
    void testEaseOutSine() {
        float[] expectedValues = { 0.0f, 0.1564344f, 0.30901699f, 0.45399050f, 0.58778525f, 0.70710678f, 0.80901699f, 0.89100652f, 0.95105657f, 0.98768834f, 1.0f};
        runTestCase(expectedValues, InterpolationType.EaseOutSine);
    }
    @Test
    void testEaseInOutSine() {
        float[] expectedValues = { 0.0f, 0.024471742f, 0.095491503f, 0.20610737f, 0.34549150f, 0.5f, 0.65450850f, 0.79389267f, 0.90450850f, 0.975528259f, 1.0f};
        runTestCase(expectedValues, InterpolationType.EaseInOutSine);
    }

    @Test
    void testEaseInQuad() {
        float[] expectedValues = { 0.0f, 0.01f, 0.04f, 0.09f, 0.16f, 0.25f, 0.36f, 0.49f, 0.64f, 0.81f, 1.0f};
        runTestCase(expectedValues, InterpolationType.EaseInQuad);
    }
    @Test
    void testEaseOutQuad() {
        float[] expectedValues = { 0.0f, 0.19f, 0.36f, 0.51f, 0.64f, 0.75f, 0.84f, 0.91f, 0.96f, 0.99f, 1.0f};
        runTestCase(expectedValues, InterpolationType.EaseOutQuad);
    }
    @Test
    void testEaseInOutQuad() {
        float[] expectedValues = { 0.0f, 0.02f, 0.08f, 0.18f, 0.32f, 0.5f, 0.68f, 0.82f, 0.92f, 0.98f, 1.0f};
        runTestCase(expectedValues, InterpolationType.EaseInOutQuad);
    }

    @Test
    void testEaseInCubic() {
        float[] expectedValues = { 0.0f, 0.001f, 0.008f, 0.027f, 0.064f, 0.125f, 0.216f, 0.343f, 0.512f, 0.729f, 1.0f};
        runTestCase(expectedValues, InterpolationType.EaseInCubic);
    }
    @Test
    void testEaseOutCubic() {
        float[] expectedValues = { 0.0f, 0.271f, 0.488f, 0.657f, 0.784f, 0.875f, 0.936f, 0.973f, 0.992f, 0.999f, 1.0f};
        runTestCase(expectedValues, InterpolationType.EaseOutCubic);
    }
    @Test
    void testEaseInOutCubic() {
        float[] expectedValues = { 0.0f, 0.004f, 0.032f, 0.108f, 0.256f, 0.5f, 0.744f, 0.892f, 0.968f, 0.996f, 1.0f};
        runTestCase(expectedValues, InterpolationType.EaseInOutCubic);
    }

    @Test
    void testEaseInQuart() {
        float[] expectedValues = { 0.0f, 0.0001f, 0.0016f, 0.0081f, 0.0256f, 0.0625f, 0.1296f, 0.2401f, 0.4096f, 0.6561f, 1.0f};
        runTestCase(expectedValues, InterpolationType.EaseInQuart);
    }
    @Test
    void testEaseOutQuart() {
        float[] expectedValues = { 0.0f, 0.3439f, 0.5904f, 0.7599f, 0.8704f, 0.9375f, 0.9744f, 0.9919f, 0.9984f, 0.9999f, 1.0f};
        runTestCase(expectedValues, InterpolationType.EaseOutQuart);
    }
    @Test
    void testEaseInOutQuart() {
        float[] expectedValues = { 0.0f, 0.0008f, 0.0128f, 0.0648f, 0.2048f, 0.5f, 0.7952f, 0.9352f, 0.9872f, 0.9992f, 1.0f};
        runTestCase(expectedValues, InterpolationType.EaseInOutQuart);
    }

    @Test
    void testEaseInQuint() {
        float[] expectedValues = { 0.0f, 0.00001f, 0.00032f, 0.00243f, 0.01024f, 0.03125f, 0.07776f, 0.16807f, 0.32768f, 0.59049f, 1.0f};
        runTestCase(expectedValues, InterpolationType.EaseInQuint);
    }
    @Test
    void testEaseOutQuint() {
        float[] expectedValues = { 0.0f, 0.40951f, 0.67232f, 0.83193f, 0.92224f, 0.96875f, 0.98976f, 0.99757f, 0.99968f, 0.99999f, 1.0f};
        runTestCase(expectedValues, InterpolationType.EaseOutQuint);
    }
    @Test
    void testEaseInOutQuint() {
        float[] expectedValues = { 0.0f, 0.00016f, 0.00512f, 0.03888f, 0.16384f, 0.5f, 0.83616f, 0.96112f, 0.99488f, 0.99984f, 1.0f};
        runTestCase(expectedValues, InterpolationType.EaseInOutQuint);
    }

    @Test
    void testEaseInExpo() {
        float[] expectedValues = { 0.0f, 0.001953125f, 0.00390625f, 0.0078125f, 0.015625f, 0.03125f, 0.0625f, 0.125f, 0.25f, 0.5f, 1.0f};
        runTestCase(expectedValues, InterpolationType.EaseInExpo);
    }
    @Test
    void testEaseOutExpo() {
        float[] expectedValues = { 0.0f, 0.5f, 0.75f, 0.875f, 0.9375f, 0.96875f, 0.984375f, 0.9921875f, 0.99609375f, 0.998046875f, 1.0f};
        runTestCase(expectedValues, InterpolationType.EaseOutExpo);
    }
    @Test
    void testEaseInOutExpo() {
        float[] expectedValues = { 0.0f, 0.001953125f, 0.0078125f, 0.03125f, 0.125f, 0.5f, 0.875f, 0.96875f, 0.9921875f, 0.998046875f, 1.0f};
        runTestCase(expectedValues, InterpolationType.EaseInOutExpo);
    }

    @Test
    void testEaseInCirc() {
        float[] expectedValues = { 0.0f, 0.005012562f, 0.02020410289f, 0.04606079858f, 0.08348486101f, 0.1339745962f, 0.2f, 0.2858571571f, 0.4f, 0.5641101056f, 1.0f};
        runTestCase(expectedValues, InterpolationType.EaseInCirc);
    }
    @Test
    void testEaseOutCirc() {
        float[] expectedValues = { 0.0f, 0.4358898944f, 0.6f, 0.7141428429f, 0.8f, 0.8660254038f, 0.916515139f, 0.9539392014f, 0.9797958971f, 0.9949874371f, 1.0f};
        runTestCase(expectedValues, InterpolationType.EaseOutCirc);
    }
    @Test
    void testEaseInOutCirc() {
        float[] expectedValues = { 0.0f, 0.01010205144f, 0.0417424305f, 0.1f, 0.2f, 0.5f, 0.8f, 0.9f, 0.9582575695f, 0.9898979486f, 1.0f};
        runTestCase(expectedValues, InterpolationType.EaseInOutCirc);
    }

    @Test
    void testEaseInBack() {
        float[] expectedValues = { 0.0f, -0.01431422f, -0.04645056f, -0.08019954f, -0.09935168f, -0.0876975f, -0.02902752f, 0.09286774f, 0.29419776f, 0.59117202f, 1.0f};
        runTestCase(expectedValues, InterpolationType.EaseInBack);
    }
    @Test
    void testEaseOutBack() {
        float[] expectedValues = { 0.0f, 0.40882798f, 0.70580224f, 0.90713226f, 1.02902752f, 1.0876975f, 1.09935168f, 1.08019954f, 1.04645056f, 1.01431422f, 1.0f};
        runTestCase(expectedValues, InterpolationType.EaseOutBack);
    }
    @Test
    void testEaseInOutBack() {
        float[] expectedValues = { 0.0f, -0.03751855f, -0.09255565f, -0.078833476f, 0.08992585f, 0.5f, 0.91007423f, 1.0788335f, 1.0925556f, 1.0375186f, 1.0f};
        runTestCase(expectedValues, InterpolationType.EaseInOutBack);
    }

    @Test
    void testEaseInElastic() {
        float[] expectedValues = { 0.0f, 0.001953125f, -0.001953125f, -0.00390625f, 0.015625f, -0.015625f, -0.03125f, 0.125f, -0.125f, -0.25f, 1.0f};
        runTestCase(expectedValues, InterpolationType.EaseInElastic);
    }
    @Test
    void testEaseOutElastic() {
        float[] expectedValues = { 0.0f, 1.25f, 1.125f, 0.875f, 1.03125f, 1.015625f, 0.984375f, 1.0039062f, 1.0019531f, 0.9980469f, 1.0f};
        runTestCase(expectedValues, InterpolationType.EaseOutElastic);
    }
    @Test
    void testEaseInOutElastic() {
        float[] expectedValues = { 0.0f, 0.000339155f, -0.0039062495f, 0.023938889f, -0.117461585f, 0.5f, 1.1174616f, 0.9760611f, 1.0039062f, 0.99966085f};
        runTestCase(expectedValues, InterpolationType.EaseInOutElastic);
    }

    @Test
    void testEaseInBounce() {
        float[] expectedValues = { 0.0f, 0.011875033f, 0.060000002f, -0.6056249f, -0.17250001f, 0.109375f, 0.24f, 0.31937492f, 0.6975f, 0.92437494f, 1.0f};
        runTestCase(expectedValues, InterpolationType.EaseInBounce);
    }
    @Test
    void testEaseOutBounce() {
        float[] expectedValues = { 0.0f, 0.075625f, 0.3025f, 0.6806251f, 0.76f, 0.890625f, 1.1725f, 1.6056249f, 0.94f, 0.98812497f, 1.0f};
        runTestCase(expectedValues, InterpolationType.EaseOutBounce);
    }
    @Test
    void testEaseInOutBounce() {
        float[] expectedValues = { 0.0f, 0.03f, -0.08625f, 0.12f, 0.34875f, 0.5f, 0.65125006f, 0.88f, 1.0862501f, 0.97f, 1.0f};
        for (int i = 0; i < 10; i++) {
            System.out.println(Interpolation.getInterpolationValue(i/10.0f, InterpolationType.EaseInOutBounce));
        }
        runTestCase(expectedValues, InterpolationType.EaseInOutBounce);
    }


    private void runTestCase(float[] _expectedValues, InterpolationType _interpolationType) {
        for (int i = 0; i < _expectedValues.length; i++) {
            System.out.printf("Loop-Count: %d -- Expect: %f -- Actual: %f%n", i, _expectedValues[i], Interpolation.getInterpolationValue(0.1f * i, _interpolationType));
            assertTrue(_expectedValues[i] + MAXIMUM_DEVIATION > Interpolation.getInterpolationValue(0.1f * i, _interpolationType));
            assertTrue(_expectedValues[i] + MAXIMUM_DEVIATION > Interpolation.getInterpolationValue(0.1f * i, _interpolationType));
        }
    }
}