package com.greenpoint.server.history.model;


import com.greenpoint.server.common.BaseEntity;
import com.greenpoint.server.customer.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Where(clause = "deleted = false")
@SQLDelete(sql = "UPDATE history SET deleted = true Where id = ?")
public class History extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Customer customer;
    private Long storeId;
    private String historyContent;
    private int savedPoint;
    private int usedPoint;

}
