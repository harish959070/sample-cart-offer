package com.springboot;

import com.springboot.controller.ApplyOfferRequest;
import com.springboot.controller.OfferRequest;
import com.springboot.dataprovider.CartAPIDataProvider;
import com.springboot.validator.CartOfferValidator;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

public class CartAPITest {

    @Test(description = "Create Offer",
            dataProvider = "getCreateOfferData",
            dataProviderClass = CartAPIDataProvider.class)
    public void createOfferTest(int restaurant_id, String offer_type, int offer_value, List<String> customer_segment) {

      //Prepare Create Offer Data
      OfferRequest offerRequest =  OfferRequest.getOfferRequestObject(restaurant_id, offer_type, offer_value, customer_segment);

        //Hit the Create Offer POST Request
        CartRestClient cartRestClient = new CartRestClient();
        Response response = cartRestClient.createOffer(offerRequest);

        //Validate the status code and the response
        CartOfferValidator cartOfferValidator = new CartOfferValidator();
        cartOfferValidator.validateCreateOfferResponse(response);
    }


    @Test(description = "Apply Offer",
            dataProvider = "getApplyOfferData",
            dependsOnMethods = "createOfferTest",
            dataProviderClass = CartAPIDataProvider.class)
    public void applyOfferTest(int cart_value, int restaurant_id, int user_id, int expectedCartValue) {

        //Prepare Apply Offer Data
        ApplyOfferRequest applyOfferRequest = ApplyOfferRequest.getAppyOfferRequestObject(cart_value,restaurant_id,user_id);

        //Hit the Create Offer POST Request
        CartRestClient cartRestClient = new CartRestClient();
        Response response = cartRestClient.applyOffer(applyOfferRequest);

        //Validate the status code and the response
        CartOfferValidator cartOfferValidator = new CartOfferValidator();
        cartOfferValidator.validateApplyOfferResponse(response, expectedCartValue);
    }

}
