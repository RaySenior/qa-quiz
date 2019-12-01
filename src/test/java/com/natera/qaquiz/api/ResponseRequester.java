package com.natera.qaquiz.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.builder.RequestSpecBuilder;

import static io.restassured.RestAssured.given;

class ResponseRequester {

    static RequestSpecification baseResponse() {
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .addHeader("X-User", Authentication.getToken())
                .build();
    }

    static Response createTriangle (int firstSide, int secondSide, int thirdSide) {
        RestAssured.baseURI = GetUrl.BASE_URL;
        return given(baseResponse())
                .body(GetTriangleBody.createTriangleBody(firstSide, secondSide, thirdSide))
                .post();
    }

    static Response getTriangles() {
        RestAssured.baseURI = GetUrl.ALL_TRIANGLES;
        return given(baseResponse()).when().get();
    }

    static Response getTriangle(String triangleID) {
        RestAssured.baseURI = GetUrl.triangle(triangleID);
        return given(baseResponse()).when().get();
    }

    static Response getTrianglePerimeter(String triangleID) {
        RestAssured.baseURI = GetUrl.trianglePerimeter(triangleID);
        return given(baseResponse()).when().get();
    }

    static Response getTriangleArea(String triangleID) {
        RestAssured.baseURI = GetUrl.triangleArea(triangleID);
        return given(baseResponse()).when().get();
    }

    static Response deleteTriangle(String triangleID) {
        RestAssured.baseURI = GetUrl.triangle(triangleID);
        return given(baseResponse()).when().delete();
    }

    static void notFoundResponse(Response response) {
        response.then().statusCode(404);
        Assertions.notFoundPage(response);
    }
}