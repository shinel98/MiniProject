package com.greenpoint.server.level.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LevelResponse {
    private Long id;
    private int grade;
    private String name;
    private String image;
}
