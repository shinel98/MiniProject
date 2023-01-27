package com.greenpoint.server.exception;


import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

public class GlobalException extends RuntimeException {

    private final HttpStatus httpStatus;


    public GlobalException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
