package com.natera.qaquiz.api;

import com.natera.qaquiz.TriangleMathOperations;
import io.restassured.response.Response;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;

public class AreaAndPerimeterTest {
    private static Response response;
    private static int firstSide = 5, secondSide = 10, thirdSide = 7;
    private static String id;

    @BeforeClass
    public static void addTriangle() {
        id = TriangleMethods.addTriangle();
    }

    @Test
    public void getArea() {
        response = ResponseRequester.getTriangleArea(id);
        Assert.assertThat(response.path("result"), equalTo(TriangleMathOperations.getTriangleArea(firstSide, secondSide, thirdSide)));
    }

    @Test
    public void getAreaNullId() {
        response = ResponseRequester.getTriangleArea(null);
        ResponseRequester.notFoundResponse(response);
    }

    @Test
    public void getAreaEmptyId() {
        ResponseRequester.getTriangleArea("").then().statusCode(400);
    }

    @Test
    public void getAreaNonExistId() {
        response = ResponseRequester.getTriangleArea("ThisIDDoesn'tExist");
        ResponseRequester.notFoundResponse(response);
    }

    @Test
    public void getPerimeter() {
        response = ResponseRequester.getTrianglePerimeter(id);
        Assert.assertThat(response.path("result"), equalTo(TriangleMathOperations.getTrianglePerimeter(firstSide, secondSide, thirdSide)));
    }

    @Test
    public void getPerimeterNullId() {
        response = ResponseRequester.getTrianglePerimeter(null);
        ResponseRequester.notFoundResponse(response);
    }

    @Test
    public void getPerimeterEmptyId() {
        ResponseRequester.getTrianglePerimeter("").then().statusCode(400);
    }

    @Test
    public void getPerimeterNonExistId() {
        response = ResponseRequester.getTrianglePerimeter("ThisIDDoesn'tExist");
        ResponseRequester.notFoundResponse(response);
    }

    @AfterClass
    public static void deleteTriangle(){
        ResponseRequester.deleteTriangle(id);
    }
}