package com.greenpoint.server.history.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HistoryCntResponse {
    Integer dayCnt;

    public static HistoryCntResponse from(Integer cnt){
        return HistoryCntResponse.builder()
                .dayCnt(cnt)
                .build();

    }
}


