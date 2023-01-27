package com.greenpoint.server.history.repository;


import com.greenpoint.server.history.model.History;
import com.greenpoint.server.history.model.HistoryResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Arrays;
import java.util.List;

public interface HistoryRepository extends JpaRepository<History, Long> {

    @Query("select h from History h where h.customerId = :cid")
    List<History> findAllById(Long cid);
}
