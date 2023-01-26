package com.greenpoint.server.level.repository;


import com.greenpoint.server.level.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
