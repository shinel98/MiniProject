package com.greenpoint.server.store.repository;

import com.greenpoint.server.store.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {

}
