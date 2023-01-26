package com.greenpoint.server.menu.repository;


import com.greenpoint.server.menu.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Customer, Long> {
}
