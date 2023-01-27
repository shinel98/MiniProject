package com.greenpoint.server.customer.service;

import com.greenpoint.server.customer.model.Customer;
import com.greenpoint.server.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerService {


    @Autowired
    private static CustomerRepository customerRepository;

    @Transactional(readOnly = true)
    public Customer findOne(Long customerId) {
        Customer customer = customerRepository.findWithId(customerId);
        return customer;
    }
    @Transactional
    public Customer findById(Long cid){
        Customer ret = this.findOne(cid);
        return ret;
    }

    @Transactional(readOnly = true)
    public Customer findWithId(Long customerId) {
        Customer ret = customerRepository.findWithId(customerId);
        return ret;
    }
}
