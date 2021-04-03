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
public class Coach  extends  Entity{

    @Getter
    @Setter
    private String firstname;
    @Getter
    @Setter
    private  String lastname;
    @Getter
    @Setter
    private  String middlename;
    @Getter
    @Setter
    private  String createdDate;
    @Getter
    @Setter
    private  String  username;
    @Getter
    @Setter
    private  String email;
    @Getter
    @Setter
    private String password;
    @Getter
    @Setter
    private  String birthDate;

    @Getter
    @Setter
    private  int mobil;

    @Setter
    @Getter
    @Labels
    @Builder.Default
    private List<String> labels = new ArrayList<>();


    @Setter
    @Getter
    @Relationship(direction = Relationship.OUTGOING, type = "COACH_HAS_ACTIVITY")
    @Builder.Default
    private Set<Activity> activities = new HashSet<>();



    @Setter
    @Getter
    @Relationship(direction = Relationship.OUTGOING, type = "COACH_HAS_ADDRESSES")
    @Builder.Default
    private Set<Address> addresses = new HashSet<>();

    @Setter
    @Getter
    @Relationship(direction = Relationship.INCOMING, type = "COACH_BELONGS_TO_CLUBS")
    @Builder.Default
    private Set<Club> clubs = new HashSet<>();

    @Setter
    @Getter
    @Relationship(direction = Relationship.INCOMING, type = "MEMBER_HAS_PAYMENTS")
    @Builder.Default
    private Set<Payment> payments = new HashSet<>();
}
