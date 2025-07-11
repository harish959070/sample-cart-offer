package com.springboot.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OfferRequest {
    private int restaurant_id;
    private String offer_type;
    private int offer_value;

    private List<String> customer_segment;

    public static OfferRequest getOfferRequestObject(int restaurant_id, String offer_type, int offer_value, List<String> customer_segment) {
        OfferRequest offerRequest = new OfferRequest();
        offerRequest.restaurant_id = restaurant_id;
        offerRequest.offer_type = offer_type;
        offerRequest.offer_value = offer_value;
        offerRequest.customer_segment = customer_segment;
        return offerRequest;
    }
}
