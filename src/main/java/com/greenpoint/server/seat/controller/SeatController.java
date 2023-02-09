package com.greenpoint.server.seat.controller;

import com.greenpoint.server.seat.model.Seat;
import com.greenpoint.server.seat.model.SeatRequest;
import com.greenpoint.server.seat.service.SeatService;

import com.greenpoint.server.store.model.Store;
import com.greenpoint.server.store.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/api")
public class SeatController {

    @Autowired
    private SeatService seatService;

    @Autowired
    private StoreService storeService;

    @GetMapping(value = "/seats/{sid}")
    public ResponseEntity<List<Seat>> findAllBySid(@PathVariable Long sid){
        List<Seat> res = seatService.findAllBySid(sid);
        return ResponseEntity.ok(res);
    }


    @PostMapping(value="/seat")
    public ResponseEntity<Seat> create(@RequestBody SeatRequest seat){
        Store store = storeService.findById(seat.getStoreId());
        Seat res = seatService.create(Seat.from(store, seat));
        return ResponseEntity.ok(res);
    }

    @GetMapping(value = "/seat/{id}")
    public ResponseEntity<Seat> findById(@PathVariable Long id){
        Seat res = seatService.findById(id);
        return ResponseEntity.ok(res);
    }
//    @GetMapping(value = "/seats")
//    public ResponseEntity<List<Seat>> findAll(){
//        List<Seat> res = seatService.findAll();
//        return ResponseEntity.ok(res);
//    }




}
