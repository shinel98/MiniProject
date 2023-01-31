package com.greenpoint.server.history.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HistoryResponse {

    private String storeName;
    private int savedPoint;
    private int usedPoint;
    private int currentPoint;
    private String image;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime created_at;



    public static HistoryResponse from(History history){
        return HistoryResponse.builder()
                .storeName(history.getStore().getName())
                .savedPoint(history.getSavedPoint())
                .usedPoint(history.getUsedPoint())
                .currentPoint(history.getCurrentPoint())
                .image(history.getStore().getImage())
                .created_at(history.getCreated_at())
                .build();
    }

}
