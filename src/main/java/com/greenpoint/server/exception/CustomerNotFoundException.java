package com.greenpoint.server.exception;

import org.springframework.http.HttpStatus;

public class CustomerNotFoundException extends GlobalException {
    public CustomerNotFoundException() {
        super("존재하지 않는 유저입니다.", HttpStatus.BAD_REQUEST);
    }
}

