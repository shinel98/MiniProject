package com.greenpoint.server.store.model;

import com.greenpoint.server.point.service.PointService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StoreClientResponse {


    private Long storeId;
    private String category;
    private String name;
    private String image;
    private double latitude;
    private double longitude;
    private int maximumPoint;

    public static StoreClientResponse from(Store store){
        return StoreClientResponse.builder()
                .storeId(store.getId())
                .category(store.getCategory())
                .name(store.getName())
                .image(store.getImage())
                .latitude(store.getLatitude())
                .longitude(store.getLongitude())
                .build();
    }
    public void maxp(int n){
        this.maximumPoint = n;
    }

}
