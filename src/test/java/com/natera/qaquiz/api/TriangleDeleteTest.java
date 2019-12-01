package com.natera.qaquiz.api;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class TriangleDeleteTest {

    @Test
    public void deleteAllTriangles() {
        List<String> triangles = TriangleMethods.getTrianglesIds();
        triangles.forEach(id -> ResponseRequester.deleteTriangle(id).then().statusCode(200));
    }

    @Test
    public void deleteTriangleNullId() {
        ResponseRequester.deleteTriangle(null);
    }

    @Test
    public void deleteTriangleEmptyId() {
        Response response = ResponseRequester.deleteTriangle("");
        Assert.assertEquals("Request method 'DELETE' not supported", response.path("message"));
    }

    @Test
    public void deleteTriangleNonExistId() {
        ResponseRequester.deleteTriangle("ThisIDDoesn'tExist");
    }
}