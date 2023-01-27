package com.greenpoint.server.store.model;


import com.greenpoint.server.common.BaseEntity;
import com.greenpoint.server.history.model.History;
import com.greenpoint.server.menu.model.Menu;
import com.greenpoint.server.point.model.Point;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Where(clause = "deleted = false")
@SQLDelete(sql = "UPDATE store SET deleted = true Where id = ?")
public class Store extends BaseEntity{

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


}
