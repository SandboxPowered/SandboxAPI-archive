package org.sandboxpowered.api.util.math;

public class Maths {
    public static double invsqrt(double r) {
        return 1.0 / java.lang.Math.sqrt(r);
    }

    public static float fma(float a, float b, float c) {
        return a * b + c;
    }

    public static double fma(double a, double b, double c) {
        return a * b + c;
    }
}