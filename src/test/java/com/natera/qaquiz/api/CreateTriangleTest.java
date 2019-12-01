package com.natera.qaquiz.api;

import org.junit.Test;

public class CreateTriangleTest {

    @Test
    public void createTriangle() {
        ResponseRequester.createTriangle(7, 10, 12).then().statusCode(200);
    }
}