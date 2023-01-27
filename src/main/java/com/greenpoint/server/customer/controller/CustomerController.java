package com.greenpoint.server.customer.controller;

import com.greenpoint.server.customer.model.Customer;
import com.greenpoint.server.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    private CustomerService cs;

    @GetMapping("/test")
    public void print() {
        System.out.println(" 들어옴! ");

        Customer customer;
        customer = cs.findById(1L);
        System.out.println("customer = " + customer.getNickname());
    }
}
