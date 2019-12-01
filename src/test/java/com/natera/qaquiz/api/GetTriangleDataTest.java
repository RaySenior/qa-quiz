package com.natera.qaquiz.api;

import io.restassured.response.Response;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;

public class GetTriangleDataTest {
    private static Response response;
    private static int firstSide = 5, secondSide = 10, thirdSide = 7;
    private static String id;

    @BeforeClass
    public static void addTriangle() {
        id = TriangleMethods.addTriangle();
    }

    @Test
    public void getTriangleInformation() {
        response = ResponseRequester.getTriangle(id);
        Assert.assertThat(response.path("firstSide"), equalTo((float)firstSide));
        Assert.assertThat(response.path("secondSide"), equalTo((float)secondSide));
        Assert.assertThat(response.path("thirdSide"), equalTo((float)thirdSide));
    }

    @Test
    public void getTriangleNullId() {
        response = ResponseRequester.getTriangle(null);
        ResponseRequester.notFoundResponse(response);
    }

    @Test
    public void getTriangleEmptyId() {
        Response response = ResponseRequester.getTriangle("");
        Assert.assertEquals("Request method 'GET' not supported", response.path("message"));
    }

    @Test
    public void getTriangleNonExistId() {
        response = ResponseRequester.getTrianglePerimeter("ThisIDDoesn'tExist");
        ResponseRequester.notFoundResponse(response);
    }

    @AfterClass
    public static void deleteTriangle() {
        ResponseRequester.deleteTriangle(id);
    }
}