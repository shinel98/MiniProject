package com.greenpoint.server.store.model;


import com.greenpoint.server.common.BaseEntity;
import com.greenpoint.server.history.model.History;
import com.greenpoint.server.menu.model.Menu;
import com.greenpoint.server.point.model.Point;
import com.greenpoint.server.storeLevel.model.StoreLevel;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Where(clause = "deleted = false")
@SQLDelete(sql = "UPDATE store SET deleted = true Where id = ?")
public class Store extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String loginID;
    private String password;
    private String category;
    private String name;
    private String image;
    private double latitude;
    private double longitude;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private StoreLevel storeLevel;
    public static Store from(StoreRequest request){
        return Store.builder()
                .loginID(request.getLoginID())
                .password(request.getPassword())
                .category(request.getCategory())
                .name(request.getName())
                .image(request.getImage())
                .latitude(request.getLatitude())
                .longitude(request.getLongitude())
                .build();
    }


    public void update(StoreRequest request) {
        this.category = request.getCategory();
        this.image = request.getImage();
        this.loginID = request.getLoginID();
        this.name = request.getName();
        this.password = request.getPassword();
        this.latitude = request.getLatitude();
        this.longitude = request.getLongitude();
    }
}
