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
public class Owner  extends  Entity{

    @Getter
    @Setter
    private String clubtype;

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
    private  String  ownerUsername;
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

    @Getter
    @Setter
    @Builder.Default
    @Relationship(direction = Relationship.OUTGOING, type = "OWNER_HAS_LICENS")
        private  Set<Licens> license = new HashSet<>();

    @Setter
    @Getter
    @Labels
    @Builder.Default
    private List<String> labels = new ArrayList<>();


    @Setter
    @Getter
    @Relationship(direction = Relationship.OUTGOING, type = "OWNER_HAS_CLUB")
    @Builder.Default
    private Set<Club> clubs = new HashSet<>();
}
