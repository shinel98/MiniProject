package com.greenpoint.server.menu.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MenuRequest {
    private String name;
    private String image;
    private int price;
}
