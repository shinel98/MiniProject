package com.greenpoint.server.point.repository;


import com.greenpoint.server.point.model.Point;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PointRepository extends JpaRepository<Point, Long> {
}
