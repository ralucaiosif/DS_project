package com.example.easynotes.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.OK)
public class TransactionSuccessfulException extends RuntimeException {

    public TransactionSuccessfulException(String message) {
        super(message);
    }
}
