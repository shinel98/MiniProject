package com.greenpoint.server.customer.repository;


import com.greenpoint.server.customer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("select c from Customer c where c.id = :customerId")
    Customer findWithId(Long customerId);
}
