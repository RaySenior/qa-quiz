package com.natera.qaquiz;

public class TriangleMathOperations {

    public static float getTrianglePerimeter(int firstSide, int secondSide, int thirdSide) {
        return (float) firstSide + secondSide + thirdSide;
    }

    public static float getTriangleArea(int firstSide, int secondSide, int thirdSide) {
        float perimeter = getTrianglePerimeter(firstSide, secondSide, thirdSide) / 2;
        return (float) Math.sqrt(perimeter * (perimeter - firstSide) * (perimeter - secondSide) * (perimeter - thirdSide));
    }
}