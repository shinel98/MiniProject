package com.greenpoint.server.point.controller;

import com.greenpoint.server.point.model.Point;
import com.greenpoint.server.point.model.PointRequest;
import com.greenpoint.server.point.service.PointService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import javax.xml.ws.Response;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/api")
public class PointController {

    @Autowired
    private PointService pointService;

    @GetMapping(value = "/point")
    public ResponseEntity<List<Point>> findAll(){
        return ResponseEntity.ok(pointService.findAll());
    }

    @GetMapping(value = "/point/{sid}")
    public ResponseEntity<List<Point>> findAllByStore(@PathVariable Long sid){
        List<Point> res = pointService.findAllByStore(sid);
        return ResponseEntity.ok(pointService.findAll());
    }

    @PostMapping(value="/point")
    public ResponseEntity<Long> create(@RequestBody PointRequest request){
        Long res = pointService.create(Point.from(request));
        return ResponseEntity.ok(res);
    }

    @PatchMapping(value = "/point/{id}")
    public ResponseEntity<Point> update(@PathVariable Long id, @RequestBody PointRequest request){
        Point res = pointService.update(id, request);
        return ResponseEntity.ok(res);
    }

    @DeleteMapping(value = "/point/{id}")
    public void delete(@PathVariable Long id){
        pointService.delete(id);
    }


}
