package com.springboot;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static com.springboot.Constants.*;
import static io.restassured.RestAssured.given;

public class CartRestClient {

    public void setBaseURI() {
        RestAssured.baseURI = BASE_URI;
    }

    public RequestSpecification getRequestSpecification() {
        RequestSpecification requestSpec = given()
                .header("Content-Type", "application/json");
        return requestSpec;
    }

    public Response createOffer(Object request) {
        setBaseURI();
        Response response =  getRequestSpecification().
                body(request).
                post(CREATE_OFFER_ENDPOINT).then().log().all().extract().response();
        return response;
    }

    public Response applyOffer(Object request) {
        setBaseURI();
        Response response =  getRequestSpecification().
                body(request).
                post(APPLY_OFFER_ENDPOINT).then().log().all().extract().response();
        return response;
    }
}
