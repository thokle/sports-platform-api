package com.kleist.sportsportal.entites;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
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
public class Child  extends  Entity{

    @Getter
    @Setter
    private  String firstname;

    @Setter
    @Getter
    private  String lastname;

    @Setter
    @Getter
   private int age;
    @Setter
    @Getter
   private String birthdate;


    @Setter
    @Getter
    @Labels
    @Builder.Default
    private List<String> labels = new ArrayList<>();


    @Setter
    @Getter
    @Relationship(direction = Relationship.INCOMING, type = "CHILD_BELONGS_TO_ACTIVITY")
    @Builder.Default
    private Set<Activity> activities = new HashSet<>();
}
