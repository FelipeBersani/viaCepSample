package com.example.viaCep.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum ErrorException {

    BAD_REQUEST(400, "The attribute %s must have at least %s and maximum %s"),
    RESOURCE_NOT_FOUND(404, "Resource not found by %s");

    private int statusCode;
    private String message;

    public static String getMessageError(int status){
        return Arrays.stream(values())
                .filter(valueStatus -> status == valueStatus.getStatusCode())
                .findFirst()
                .get().getMessage();
    }

}
