package com.greenpoint.server.point.repository;


import com.greenpoint.server.point.model.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PointRepository extends JpaRepository<Point, Long> {
    @Query("select p from Point p where p.storeId = :sid")
    List<Point> findAllByStore(Long sid);

}
