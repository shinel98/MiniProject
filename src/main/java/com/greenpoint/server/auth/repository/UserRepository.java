package com.greenpoint.server.auth.repository;

import com.greenpoint.server.customer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Customer, Long> {
    public Customer findByKakao_Token(String kakaoToken);
//    public Customer findByUserCode(String userCode);
}

