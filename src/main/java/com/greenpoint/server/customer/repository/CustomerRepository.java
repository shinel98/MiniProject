package com.greenpoint.server.customer.repository;


import com.greenpoint.server.customer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    public Customer findByKakaoToken(String kakaoToken);

//    @Query("delete from Customer as c where c.kakaoId= :kakao_id")
    public int deleteByKakaoId(Long kakaoId);

//    @Query("select m from Customer as m where m.kakaoToken = :kakaoToken")
//    public Customer findByToken(String kakaoToken);

//    @Query("select m from Customer as m where m.contact = :contact")
    public Customer findByContact(String contact);

    public Customer findByKakaoId(Long id);
}
