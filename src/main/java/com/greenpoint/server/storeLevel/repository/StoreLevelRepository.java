package com.greenpoint.server.storeLevel.repository;

import com.greenpoint.server.storeLevel.model.StoreLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StoreLevelRepository extends JpaRepository<StoreLevel, Long> {

    @Query("select s from StoreLevel s where s.grade = :after")
    StoreLevel findByGrade(int after);
}
