package com.greenpoint.server.stomp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ChatMessageRequest {

    private String sender;
    private Long seatId;
    private String type;
    private String message;

}
