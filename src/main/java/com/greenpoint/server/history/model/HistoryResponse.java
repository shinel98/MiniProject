package com.greenpoint.server.history.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HistoryResponse {

    private String storeName;
    private int savedPoint;
    private int usedPoint;
    private int currentPoint;



    public static HistoryResponse from(History history){
        return HistoryResponse.builder()
                .storeName(history.getStore().getName())
                .savedPoint(history.getSavedPoint())
                .usedPoint(history.getUsedPoint())
                .build();
    }

}
