package com.greenpoint.server.store.repository;


import com.greenpoint.server.store.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Customer, Long> {
}
