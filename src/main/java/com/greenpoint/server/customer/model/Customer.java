package com.greenpoint.server.customer.model;


import com.greenpoint.server.common.BaseEntity;
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
@SQLDelete(sql = "UPDATE customer SET deleted = true Where id = ?")
public class Customer extends BaseEntity {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String img;
    private int point;
    private int totalPoint;

    public void insertUserToken(String token){
        this.kakao_token = token;
    }

    public void addpoint(int savedPoint) {
        this.point = this.point + savedPoint;
        this.totalPoint = this.totalPoint + savedPoint;
    }

    public void usepoint(int usedPoint) {
        this.point = this.point - usedPoint;
    }
}
