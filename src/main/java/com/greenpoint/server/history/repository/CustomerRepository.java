package com.greenpoint.server.history.repository;


import com.greenpoint.server.history.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
