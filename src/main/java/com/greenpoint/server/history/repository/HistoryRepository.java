package com.greenpoint.server.history.repository;


import com.greenpoint.server.history.model.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<History, Long> {
}
