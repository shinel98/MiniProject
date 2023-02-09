package com.greenpoint.server.seat.service;

import com.greenpoint.server.seat.model.Seat;
import com.greenpoint.server.seat.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SeatService {

    @Autowired
    private SeatRepository seatRepository;

    @Transactional
    public Seat create(Seat seat){
        seatRepository.save(seat);
        return seat;
    }

    @Transactional(readOnly = true)
    public Seat findById(Long seatId){
        Seat ret = seatRepository.findById(seatId).get();
        return ret;
    }


    @Transactional(readOnly = true)
    public List<Seat> findAllBySid(Long storeId) {
        List<Seat> ret = seatRepository.findAllBySid(storeId);
        return ret;
    }

    @Transactional(readOnly = true)
    public List<Seat> findAll() {
        List<Seat> ret = seatRepository.findAll();
        return ret;
    }

}
