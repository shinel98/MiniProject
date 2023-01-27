package com.greenpoint.server.customer.service;

import com.greenpoint.server.customer.model.Customer;
import com.greenpoint.server.customer.repository.CustomerRepository;
import com.greenpoint.server.exception.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerService {


    @Autowired
    private CustomerRepository customerRepository;




    @Transactional
    public Customer findById(Long id) {
//        Customer ret = customerRepository.findById(id).orElseThrow(CustomerNotFoundException::new);
        Customer ret = customerRepository.findById(id).get();
        return ret;
    }



}
