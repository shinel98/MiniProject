package com.greenpoint.server.history.model;

import com.greenpoint.server.store.model.Store;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HistoryResponse {

    private String storeName;
    private int savedPoint;
    private int usedPoint;
    private int currentPoint;

//    public HistoryResponse from(History history){
//        return HistoryResponse.builder()
//                .storeName(history.getStore().getName())
//                .savedPoint(history.getSavedPoint())
//                .usedPoint(history.getUsedPoint())
//                .currentPoint(history.)
//                .build();
//    }

}
