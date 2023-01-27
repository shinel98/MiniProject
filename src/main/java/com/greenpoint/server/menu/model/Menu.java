package com.greenpoint.server.menu.model;

import com.greenpoint.server.common.BaseEntity;
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
@SQLDelete(sql = "UPDATE menu SET deleted = true Where id = ?")
public class Menu extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
//    private Store store;

    private Long storeId;
    private String name;
    private String image;
    private int price;


    public static Menu from(Long sid, MenuRequest request){
        return Menu.builder()
                .storeId(sid)
                .name(request.getName())
                .image(request.getImage())
                .price( request.getPrice())
                .build();
    }

    public void update(MenuRequest request) {
        this.name = request.getName();
        this.price = request.getPrice();
        this.image = request.getImage();
    }
}
