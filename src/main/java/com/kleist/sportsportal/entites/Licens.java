package com.kleist.sportsportal.entites;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties( ignoreUnknown = true)
public class Licens extends Entity {

    @Getter
    @Setter
    public String name;

    @Getter
    @Setter
    private  int members;



}
