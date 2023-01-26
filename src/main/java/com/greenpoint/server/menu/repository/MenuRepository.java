package com.greenpoint.server.menu.repository;


import com.greenpoint.server.menu.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Long> {
}
