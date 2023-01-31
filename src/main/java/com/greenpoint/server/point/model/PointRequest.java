package com.greenpoint.server.point.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PointRequest {
    private Long storeId;
    private String name;
    private int weight;
}
