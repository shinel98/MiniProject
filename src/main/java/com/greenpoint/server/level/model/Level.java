package com.greenpoint.server.level.model;

import com.greenpoint.server.common.BaseEntity;
import com.greenpoint.server.customer.model.Customer;
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
@SQLDelete(sql = "UPDATE level SET deleted = true Where id = ?")
public class Level extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String image;

    public static Level from(LevelRequest request) {
        return Level.builder()
                .name(request.getName())
                .image(request.getImage())
                .build();
    }
}
