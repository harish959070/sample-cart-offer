package com.springboot.validator;

import com.springboot.Utils;
import com.springboot.controller.ApiResponse;
import com.springboot.controller.ApplyOfferResponse;
import io.restassured.response.Response;
import org.testng.Assert;

public class CartOfferValidator {

    public void validateCreateOfferResponse(Response response) {
        ApiResponse apiResponse = Utils.getResponseData(response.asString(), ApiResponse.class);
        Assert.assertEquals(response.getStatusCode(), 200,"Status code Actual: "+response.getStatusCode()+" and Expected: 200 is not matching");
        Assert.assertEquals(apiResponse.getResponse_msg(), "success","Actual: "+apiResponse.getResponse_msg()+" and Expected: success is not matching");
    }

    public void validateApplyOfferResponse(Response response, int expectedCartValue) {
        ApplyOfferResponse apiResponse = Utils.getResponseData(response.asString(), ApplyOfferResponse.class);
        Assert.assertEquals(response.getStatusCode(), 200,"Status code Actual: "+response.getStatusCode()+" and Expected: 200 is not matching");
        Assert.assertEquals(apiResponse.getCart_value(), expectedCartValue,"Actual: "+apiResponse.getCart_value()+" and Expected: "+expectedCartValue+" is not matching");
    }
}
