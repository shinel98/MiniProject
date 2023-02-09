package com.greenpoint.server.seat.repository;


import com.greenpoint.server.seat.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface SeatRepository extends JpaRepository<Seat, Long> {

    @Query("select s from Seat s where s.store.id = :sid")
    List<Seat> findAllBySid(Long sid);
}
