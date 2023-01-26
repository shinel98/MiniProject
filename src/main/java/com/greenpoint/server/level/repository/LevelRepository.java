package com.greenpoint.server.level.repository;


import com.greenpoint.server.level.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LevelRepository extends JpaRepository<Customer, Long> {
}
