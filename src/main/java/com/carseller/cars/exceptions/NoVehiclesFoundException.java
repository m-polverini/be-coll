package com.carseller.cars.exceptions;

import lombok.Getter;

@Getter
public class NoVehiclesFoundException extends RuntimeException{
    private static final long serialVersionUID = -7077742374485554395L;
    private final String message;
    public NoVehiclesFoundException(String message) {
        this.message = message;
    }
}
