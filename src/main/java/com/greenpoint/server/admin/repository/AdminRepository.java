package com.greenpoint.server.admin.repository;


import com.greenpoint.server.admin.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
