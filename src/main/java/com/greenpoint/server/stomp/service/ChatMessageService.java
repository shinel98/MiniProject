package com.greenpoint.server.stomp.service;

import com.greenpoint.server.stomp.model.ChatMessage;
import com.greenpoint.server.stomp.repository.ChatMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ChatMessageService {

    @Autowired
    private ChatMessageRepository chatMessageRepository;

    @Transactional(readOnly = true)
    public List<ChatMessage> findChatMessageBySeatId(Long seatId) {
        List<ChatMessage> ret = chatMessageRepository.findChatMessageBySeatId(seatId);
        return ret;
    }
    @Transactional
    public ChatMessage save(ChatMessage message) {
        ChatMessage ret = chatMessageRepository.save(message);
        return ret;
    }
}
