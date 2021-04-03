package com.kleist.sportsportal.entites;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties( ignoreUnknown = true)
public class Address extends  Entity{
    @Getter
    @Setter
    private  String streetname;
    @Getter
    @Setter
    private   int streetnumber;
    @Getter
    @Setter
    private  String floor;
    @Getter
    @Setter
    private int zipcode;
    @Getter
    @Setter
    private  String country;
    @Getter
    @Setter
    private int longitude;
    @Getter
    @Setter
    private int lattiude;

}
