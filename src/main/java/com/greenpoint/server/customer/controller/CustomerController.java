package com.greenpoint.server.customer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CustomerController {

    @RequestMapping("/test")
    public void print(){
        System.out.println(" 들어옴! " );
    }
}
