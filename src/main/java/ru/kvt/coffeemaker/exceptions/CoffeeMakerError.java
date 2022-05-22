package ru.kvt.coffeemaker.exceptions;

import lombok.Data;

import java.util.Date;

@Data
public class CoffeeMakerError {

    private Date timestamp;
    private int status;
    private String error;
    private String message;


    public CoffeeMakerError(int status, String error, String message) {

        this.timestamp = new Date();
        this.status = status;
        this.error = error;
        this.message = message;

    }
}
