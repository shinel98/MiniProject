package com.greenpoint.server.stomp.controller;

import com.greenpoint.server.menu.service.MenuService;
import com.greenpoint.server.seat.model.Seat;
import com.greenpoint.server.seat.service.SeatService;
import com.greenpoint.server.stomp.model.ChatMessage;
import com.greenpoint.server.stomp.model.ChatMessageRequest;
import com.greenpoint.server.stomp.service.ChatMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@CrossOrigin
@RequiredArgsConstructor
public class StompController {
    private final SimpMessagingTemplate template; //특정 Broker로 메세지를 전달
    @Autowired
    private ChatMessageService chatMessageService;

    @Autowired
    private SeatService seatService;

    @Autowired
    private MenuService menuService;

//    @MessageMapping(value = "/chat/room/{roomId}")
    @MessageMapping(value = "/chat/message/store")
    public void message(@RequestBody ChatMessageRequest message){
        Seat seat = seatService.findById(message.getSeatId());
        if(message.getType().equals("message")){
            chatMessageService.save(ChatMessage.from(seat, message));
        }
//        template.convertAndSend("/sub/chat/room/" + message.getRoomId(), message);
        template.convertAndSend("/sub/seat/" + message.getSeatId(), message);
        template.convertAndSend("/sub/store", message);
    }

    // RoomId -> Message 전부 가져오는 API
    @GetMapping(value="/chat/messages/{seatId}")
    public ResponseEntity<List<ChatMessage>> findAllByRoomId(@PathVariable Long seatId){
        List<ChatMessage> response = chatMessageService.findChatMessageBySeatId(seatId);
        return ResponseEntity.ok(response);
    }

}
