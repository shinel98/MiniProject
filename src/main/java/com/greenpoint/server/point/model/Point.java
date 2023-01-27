package com.greenpoint.server.point.model;

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
@SQLDelete(sql = "UPDATE point SET deleted = true Where id = ?")
public class Point extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
//    private Store store;
    private Long storeId;
    private String name;
    private int weight;

    public static Point from(PointRequest request){
        return Point.builder()
                .storeId(request.getStoreId())
                .name(request.getName())
                .weight(request.getWeight())
                .build();
    }

    public void update(PointRequest request) {
        this.name = request.getName();
        this.weight = request.getWeight();
    }
}
