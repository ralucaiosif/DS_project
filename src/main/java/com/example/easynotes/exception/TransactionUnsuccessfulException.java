package com.example.easynotes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class TransactionUnsuccessfulException extends RuntimeException {

    public TransactionUnsuccessfulException(String message) {
        super(message);
    }
}
