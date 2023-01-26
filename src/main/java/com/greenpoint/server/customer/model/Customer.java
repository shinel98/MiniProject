package com.greenpoint.server.customer.model;


import com.greenpoint.server.common.BaseEntity;
import com.greenpoint.server.level.model.Level;
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
@SQLDelete(sql = "UPDATE customer SET deleted = true Where kakaoToken = ?")
public class Customer extends BaseEntity {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

    @Id
    @Column(unique = true)
    private String kakaoToken;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Level level;

    private String contact;
    private String image;
    private String nickname;
    private double latitude;
    private double longitude;
    private int point;
    private int totalPoint;


}
