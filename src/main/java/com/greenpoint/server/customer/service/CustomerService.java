package com.greenpoint.server.customer.service;

import com.greenpoint.server.customer.model.Customer;
import com.greenpoint.server.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    public Customer findById(Long customerId) {
        Customer customer = customerRepository.findById(customerId).get();
        return customer;
    }
}
