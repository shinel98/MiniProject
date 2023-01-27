package com.greenpoint.server.customer.model;


import com.greenpoint.server.common.BaseEntity;
import com.greenpoint.server.level.model.Level;
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
@SQLDelete(sql = "UPDATE customer SET deleted = true Where kakaoToken = ?")
public class Customer extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Id
    @Column(unique = true)
    private String kakaoToken;


    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Level level;

    private String contact;
    private String image;
    private String nickname;
    private double latitude;
    private double longitude;
    private int point;
    private int totalPoint;

    public void insertUserToken(String token){
        this.kakaoToken = token;
    }


    public void addpoint(int savedPoint) {
        this.point = this.point + savedPoint;
        this.totalPoint = this.totalPoint + savedPoint;
    }

    public void usepoint(int usedPoint) {
        this.point = this.point - usedPoint;
    }

    public void insertUser(String token, String nickname, String image) {
        this.kakaoToken = token;
        this.nickname = nickname;
        this.image = image;
    }
    public void insertUser(String token) {
        this.kakaoToken = token;
    }

    public static Customer from (String token, String nickname, String image) {
        return Customer.builder()
                .kakaoToken(token)
                .nickname(nickname)
                .image(image)
                .build();
    }

}
