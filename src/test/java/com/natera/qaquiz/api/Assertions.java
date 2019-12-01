package com.natera.qaquiz.api;

import io.restassured.response.Response;
import org.junit.Assert;

class Assertions {

    static void notFoundPage(Response response) {
        Assert.assertEquals(ErrorMessages.getNotFoundError(), response.path("message"));
    }
}