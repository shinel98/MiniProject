package com.greenpoint.server.menu.repository;


import com.greenpoint.server.menu.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Long> {

    @Query("select m from Menu m where m.storeId = :sid")
    List<Menu> findByStoreId(Long sid);
}
