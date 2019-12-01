package com.natera.qaquiz.api;

class GetTriangleBody {

    static String createTriangleBody(double firstSide, double secondSide, double thirdSide) {
        return "{\"separator\":\";\", \"input\":\"" + firstSide + ";" + secondSide + ";" + thirdSide + "\"}";
    }
}