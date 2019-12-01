package com.natera.qaquiz.api;

import io.restassured.response.Response;

import java.util.List;

class TriangleMethods {
    private static int firstSide = 5, secondSide = 10, thirdSide = 7;

    static String addTriangle() {
        Response response = ResponseRequester.createTriangle(firstSide, secondSide, thirdSide);
        response.then().statusCode(200);
        return response.path("id");
    }

    static List<String> getTrianglesIds() {
        return ResponseRequester.getTriangles().jsonPath().getList("id");
    }
}