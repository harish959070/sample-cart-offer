package com.springboot.controller;

import lombok.Data;

@Data
public class ApplyOfferRequest {
    private int cart_value;
    private int restaurant_id;
    private int user_id;

    public static ApplyOfferRequest getAppyOfferRequestObject(int cart_value, int restaurant_id, int user_id) {
        ApplyOfferRequest applyOfferRequest = new ApplyOfferRequest();
        applyOfferRequest.cart_value = cart_value;
        applyOfferRequest.restaurant_id = restaurant_id;
        applyOfferRequest.user_id = user_id;
        return applyOfferRequest;
    }
}
