package com.greenpoint.server.store.model;


import com.greenpoint.server.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
    private String userId;
    private String password;

    @OneToMany(mappedBy = "history", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<History> historyList = new ArrayList<>();

    @OneToMany(mappedBy = "point", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<Point> pointList = new ArrayList<>();

    @OneToMany(mappedBy = "menu", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<Menu> menuList = new ArrayList<>();

    private String category;
    private String name;
    private String img;
    private double latitude;
    private double longitude;


}
