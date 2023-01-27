package com.greenpoint.server.customer.repository;


import com.greenpoint.server.customer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    public Customer findByKakao_Token(String kakaoToken);

}
