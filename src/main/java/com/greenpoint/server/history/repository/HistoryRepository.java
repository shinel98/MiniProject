package com.greenpoint.server.history.repository;


import com.greenpoint.server.history.model.History;
import com.greenpoint.server.history.model.HistoryResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public interface HistoryRepository extends JpaRepository<History, Long> {

    @Query("select h from History h where h.customerId = :cid")
    List<History> findAllById(Long cid);


    @Query(nativeQuery = true, value="SELECT DATE(created_at) FROM history GROUP BY DATE(created_at) order by DATE(created_at) desc limit 1")
    String findMaxDate(Long customerId);

    @Query(nativeQuery= true, value ="SELECT DATE(created_at) FROM history where not created_at is Null GROUP BY DATE(created_at) order by DATE(created_at)  limit 1")
    String findMinDate(Long customerId);

    @Query(nativeQuery = true, value="SELECT DATE(created_at) ,COUNT(Id) FROM history where Date(created_at) is not null GROUP BY DATE(created_at) order by DATE(created_at)")
//    List<Object> findExistDate(Long customerId);
    List<String> findExistDate(Long customerId);
}
