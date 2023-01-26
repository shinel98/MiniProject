package com.greenpoint.server.menu.repository;


import com.greenpoint.server.menu.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
