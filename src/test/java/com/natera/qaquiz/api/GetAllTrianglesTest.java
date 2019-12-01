package com.natera.qaquiz.api;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class GetAllTrianglesTest {
    private static long countTriangles;

    @BeforeClass
    public static void addTriangle() {
        countTriangles = ResponseRequester.getTriangles().jsonPath().getList("id").stream().count();
        for (int i = 0; i < 3; i++) {
            TriangleMethods.addTriangle();
        }
    }

    @Test
    public void verifyTriangleAdded() {
        Assert.assertEquals(ResponseRequester.getTriangles().jsonPath().getList("id").stream().count(), countTriangles + 3);
    }
}