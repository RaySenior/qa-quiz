package com.natera.qaquiz.api;

final class GetUrl {

    static final String BASE_URL = "https://qa-quiz.natera.com/triangle/";
    static final String ALL_TRIANGLES = BASE_URL + "all";

    static String triangle(String triangleId) {
        return BASE_URL + triangleId;
    }

    static String trianglePerimeter(String triangleId) {
        return BASE_URL + triangleId + "/perimeter";
    }

    static String triangleArea(String triangleId) {
        return BASE_URL + triangleId + "/area";
    }
}