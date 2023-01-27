package com.greenpoint.server.store.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StoreRequest {
    private String loginID;
    private String password;
    private String category;
    private String name;
    private String image;
    private double latitude;
    private double longitude;
}
