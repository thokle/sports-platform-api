package com.kleist.sportsportal.entites;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.neo4j.ogm.annotation.Labels;
import org.neo4j.ogm.annotation.NodeEntity;

import java.util.ArrayList;
import java.util.List;

@NodeEntity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties( ignoreUnknown = true)
public class Competition  extends  Entity{



    @Setter
    @Getter
    @Labels
    @Builder.Default
    private List<String> labels = new ArrayList<>();


    



}
