package com.i4digital.prueba.exceptions;

public class NotFoundEmployeeException extends RuntimeException {
    public NotFoundEmployeeException(String message) {
        super(message);
    }
}
