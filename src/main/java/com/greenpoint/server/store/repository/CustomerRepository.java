package com.greenpoint.server.store.repository;


import com.greenpoint.server.store.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
