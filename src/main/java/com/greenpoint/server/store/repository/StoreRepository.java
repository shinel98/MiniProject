package com.greenpoint.server.store.repository;

import com.greenpoint.server.store.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StoreRepository extends JpaRepository<Store, Long> {

//    @Query(nativeQuery = true, value ="select s from Store s where s.id = :id order by s. LIMIT 3")
//    List<Store> findThreeById(Long id);
}
