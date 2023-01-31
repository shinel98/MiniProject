package com.greenpoint.server.auth.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {
    private Long kakaoId;
    private String token;
    private String nickname;
    private String image;
    private boolean isRegistered;
}
