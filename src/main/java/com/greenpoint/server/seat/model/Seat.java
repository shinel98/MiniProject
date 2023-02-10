package com.greenpoint.server.seat.model;

import com.greenpoint.server.common.BaseEntity;
import com.greenpoint.server.stomp.model.ChatMessage;
import com.greenpoint.server.store.model.Store;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Where(clause = "deleted = false")
@SQLDelete(sql = "UPDATE seat SET deleted = true Where id = ?")
public class Seat extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Store store;
    private int seatNum;

    public static Seat from(Store s, SeatRequest request){
        return Seat.builder()
                .store(s)
                .seatNum(request.getSeatNum())
                .build();
    }

}
