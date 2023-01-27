package com.greenpoint.server.auth.model;

import lombok.Data;

public class KakaoProfile {
    private Long id;
    private Properties properties;

    @Data
    public class Properties {
        public String nickname;
        public String profile_image; // 이미지 경로 필드1
    }

}
