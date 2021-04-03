package com.kleist.sportsportal.entites;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class Shop extends Entity {

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String startyear;





    @Setter
    @Getter
    @JsonBackReference(value = "SHOP_BELONGS_TO_MEMBER")
    @Relationship(direction = Relationship.INCOMING, type = "SHOP_BElONGS_TO_MEMBER")
    @Builder.Default
    private Set<Member> members = new HashSet<>();

    @Setter
    @Getter
    @JsonBackReference(value = "SHOP_BELONGS_TO_CLUB")
    @Relationship(direction = Relationship.INCOMING, type = "SHOP_BELONGS_TO_CLUB")
    @Builder.Default
    private Set<Club> clubs = new HashSet<>();

    @Setter
    @Getter
    @JsonBackReference(value = "SHOP_HAS_ITEMS")
    @Relationship(direction = Relationship.INCOMING, type = "SHOP_HAS_ITEMS")
    @Builder.Default
    private Set<ShopItem> shopItemSet = new HashSet<>();

    public void addMember(Member member) {
        members.add(member);
        member.getShops().add(this);
    }

    public void addClub(Club club){
        clubs.add(club);
        club.getShops().add(this);
    }



}

