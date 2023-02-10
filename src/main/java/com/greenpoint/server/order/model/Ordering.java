package com.greenpoint.server.order.model;


import com.greenpoint.server.common.BaseEntity;
import com.greenpoint.server.history.model.History;
import com.greenpoint.server.menu.model.Menu;
import com.greenpoint.server.seat.model.Seat;
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
@SQLDelete(sql = "UPDATE ordering SET deleted = true Where id = ?")
public class Ordering extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "historyId")
    private History history;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Seat seat;
    private Long customerId;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Menu menu;
    private int count;
    // 0 : 대기중, 1 : 조리중
    private Boolean status;


}
