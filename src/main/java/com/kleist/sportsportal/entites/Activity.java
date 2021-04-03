package com.kleist.sportsportal.entites;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Activity extends Entity {

    @Getter
    @Setter
    private  String name;

    @Getter
    @Setter
    private String type;

    @Getter
    @Setter
    @Builder.Default
    private Integer max = 40;

    @Getter
    @Setter
    @Builder.Default
    private Integer participates =0;

    @Setter
    @Getter
    private  Double price;


    @Getter
    @Setter
    private  String  startDate;

     @Getter
     @Setter
     private  String endDate;

    @Setter
    @Getter
    @JsonBackReference
    @Relationship(direction = Relationship.INCOMING, type = "ACTIVITY_HAS_MEMBER")
    @Builder.Default
    private Set<Member> members = new HashSet<>();

    @Setter
    @Getter
    @JsonBackReference(value = "ACTIVITY_HAS_CHILD")
    @Relationship(direction = Relationship.INCOMING, type = "ACTIVITY_HAS_CHILD")
    @Builder.Default
    private Set<Child> children = new HashSet<>();

    @Setter
    @Getter
    @JsonBackReference(value = "ACTIVITY_HAS_SCORE")
    @Relationship(direction = Relationship.OUTGOING, type = "ACTIVITY_HAS_SCORE")
    @Builder.Default
    private Set<Score> scores = new HashSet<>();

    @Setter
    @Getter
    @JsonIgnore
    @Relationship(direction = Relationship.OUTGOING, type = "BELONGS_TO_CLUB")
    @Builder.Default
    private Set<Club> club = new HashSet<>();

    public void AddClub(Club club){
        getClub().add(club);
        club.getActivities().add(this);
    }

    public void AddMember(Member member){
        getMembers().add(member);
        member.getActivities().add(this);
    }

    public void  addChild(Child child){
        getChildren().add(child);
        child.getActivities().add(this);
    }




}
