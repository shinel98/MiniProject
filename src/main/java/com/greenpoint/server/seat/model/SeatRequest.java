package com.greenpoint.server.seat.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SeatRequest {
    private Long storeId;
    private int seatNum;
}
