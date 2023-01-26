package com.greenpoint.server.point.repository;


import com.greenpoint.server.point.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
