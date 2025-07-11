package com.springboot;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Utils {

    // Deserialize: JSON String to Java Object
    public static <T> T getResponseData(String response, Class<T> className) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(response, className);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
