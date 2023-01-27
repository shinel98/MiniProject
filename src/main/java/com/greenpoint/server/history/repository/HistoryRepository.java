package com.greenpoint.server.history.repository;


import com.greenpoint.server.history.model.History;
import com.greenpoint.server.history.model.HistoryResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Arrays;
import java.util.List;

public interface HistoryRepository extends JpaRepository<History, Long> {



    @Query("select h from History h where h.customerId = :cid order by h.created_at desc")
    List<History> findAllById(Long cid);


//    @Query("select h from History h where h.customerId = :cid order by h.created_at desc")
//    List<History> findThreeById(Long cid);



//    @Query("select count(h.id) as cnt from History h where h.id = :customerId group by h.created_at o")
//    SELECT DATE(created_at), COUNT(Id) FROM history GROUP BY DATE(created_at) order by DATE(created_at) desc;
//    List<Integer> findDailyHistory(Long customerId);

}
