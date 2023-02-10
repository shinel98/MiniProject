package com.greenpoint.server.stomp.repository;

import com.greenpoint.server.stomp.model.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {
//    @Query("select m from ChatMessage m where m.seat.id = :seatId")
@Query("select m from ChatMessage m where m.seatId = :seatId")
List<ChatMessage> findChatMessageBySeatId(Long seatId);
}
