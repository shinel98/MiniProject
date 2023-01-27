package com.greenpoint.server.point.service;

import com.greenpoint.server.point.model.Point;
import com.greenpoint.server.point.model.PointRequest;
import com.greenpoint.server.point.repository.PointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PointService {

    @Autowired
    private PointRepository pointRepository;

    private Point findOne(Long id){
        return pointRepository.findById(id).get();
    }

    @Transactional
    public Point update(Long id, PointRequest request) {
        Point res = pointRepository.findById(id).get();
        res.update(request);
        return res;
    }
    @Transactional
    public Long create(Point point){
        pointRepository.save(point);
        return point.getId();
    }
    @Transactional(readOnly = true)
    public List<Point> findAll() {
        return pointRepository.findAll();
    }

    @Transactional
    public void delete(Long id) {
        pointRepository.delete(this.findOne(id));
    }

    @Transactional(readOnly = true)
    public List<Point> findAllByStore(Long storeid) {
        List<Point> res = pointRepository.findAllByStore(storeid);
        return res;
    }
}
