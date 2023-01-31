package com.greenpoint.server.history.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class HistoryRequest {
    private Long customerId;
    private Long storeId;
    private int cost;
    private int savedPoint;
    private int usedPoint;
}
