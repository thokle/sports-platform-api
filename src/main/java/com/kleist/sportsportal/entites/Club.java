package com.kleist.sportsportal.entites;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.checkerframework.checker.index.qual.SearchIndexBottom;
import org.neo4j.ogm.annotation.Labels;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NodeEntity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties( ignoreUnknown = true)
public class Club extends  Entity {


        @Getter
        @Setter
        private  String name;
        @Getter
        @Setter
        private  String type;
        @Getter
        @Setter
        private  int cvr;


    @Setter
    @Getter
    @Labels
    @Builder.Default
    private List<String> labels = new ArrayList<>();


    @Setter
    @Getter
    @Relationship(direction = Relationship.OUTGOING, type = "CLUB_HAS_ACTIVITY")
    @Builder.Default
    private Set<Activity> activities = new HashSet<>();


    @Setter
    @Getter
    @Relationship(direction = Relationship.OUTGOING, type = "CLUB_HAS_ADDRESS")
    @Builder.Default
    private Set<Address> addresses = new HashSet<>();


    @Setter
    @Getter
    @Relationship(direction = Relationship.OUTGOING, type = "CLUB_HAS_COMPETITION")
    @Builder.Default
    private Set<Competition> competitions = new HashSet<>();


    @Setter
    @Getter
    @Relationship(direction = Relationship.OUTGOING, type = "CLUB_HAS_SPORTS")
    @Builder.Default
    private Set<Sports> sports = new HashSet<>();

    @Setter
    @Getter
    @Relationship(direction = Relationship.OUTGOING, type = "CLUB_HAS_MEMBERS")
    @Builder.Default
    private Set<Member> members = new HashSet<>();

    @Setter
    @Getter
    @JsonIgnore
    @Relationship(direction = Relationship.OUTGOING, type = "CLUB_BELONGS_TO_OWNER")
    @Builder.Default
    private Set<Owner> owner = new HashSet<>();

    @Setter
    @Getter
    @JsonBackReference(value = "CLUB_HAS_MEMBERS")
    @Relationship(direction = Relationship.OUTGOING, type = "CLUB_HAS_MEMBERS")
    @Builder.Default
    private Set<Member> member = new HashSet<>();


    @Setter
    @Getter
    @JsonBackReference(value = "CLUB_HAS_SHOP")
    @Relationship(direction = Relationship.OUTGOING, type = "CLUB_HAS_SHOP")
    @Builder.Default
    private Set<Shop> shops = new HashSet<>();
    
    public  void addOwner(Owner owner){
        getOwner().add(owner);
        owner.getClubs().add(this);
    }

    public void addMember(Member member){
        getMembers().add(member);
        member.getClubs().add(this);
    }
}
