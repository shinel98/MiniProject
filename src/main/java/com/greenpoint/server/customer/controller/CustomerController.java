package com.greenpoint.server.customer.controller;

import com.greenpoint.server.customer.model.Customer;

import com.greenpoint.server.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @GetMapping("/readCustomer")
    public ResponseEntity<Customer> readCustomer(@RequestParam("id") Long id) {

        Customer customer;
        customer = customerService.findByKakaoId(id);
        return ResponseEntity.ok(customer);

    }
    @GetMapping("/readCustomerByNum")
    public ResponseEntity<Customer> readCustomerByNum(@RequestParam("contact") String contact) {
        Customer customer;
        customer = customerService.findByContact(contact);
        return ResponseEntity.ok(customer);
    }
}
