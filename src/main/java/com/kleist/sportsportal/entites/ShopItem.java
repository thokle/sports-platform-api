package com.kleist.sportsportal.entites;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.HashSet;
import java.util.Set;

@NodeEntity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties( ignoreUnknown = true)
public class ShopItem extends Entity {

    @Getter
    @Setter
    private String typeItem;
    @Getter
    @Setter
    private String model;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private Double price;
    @Getter
    @Setter
    private  int whoIsLooking;
    @Getter
    @Setter
    private  String size;
    @Getter
    @Setter
    private  String condition;
    @Getter
    @Setter
    private  int itemInStock;

    @Getter
    @Setter
    private  String pictureUrl;

    @Setter
    @Getter
    @Relationship(direction = Relationship.INCOMING, type = "BELONGS_TO_SHOP")
    @Builder.Default
    private Set<Shop> shopItemSet = new HashSet<>();

    public void addShop(Shop item){
        this.shopItemSet.add(item);
        item.getShopItemSet().add(this);
    }

}
