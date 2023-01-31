package com.greenpoint.server.point.repository;


import com.greenpoint.server.point.model.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PointRepository extends JpaRepository<Point, Long> {
    @Query("select p from Point p where p.storeId = :sid")
    List<Point> findAllByStore(Long sid);

    @Query("select sum(p.weight) from Point p where p.storeId = :sid group by p.storeId")
    int findMaxPointByStore(Long sid);
}
