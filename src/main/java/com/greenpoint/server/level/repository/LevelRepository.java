package com.greenpoint.server.level.repository;


import com.greenpoint.server.level.model.Level;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LevelRepository extends JpaRepository<Level, Long> {
    @Query("select l from Level l where l.grade = :newgrade")
    Level findByGrade(int newgrade);
}
