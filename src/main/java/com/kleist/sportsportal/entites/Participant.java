package com.kleist.sportsportal.entites;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
@Builder
@AllArgsConstructor
@JsonIgnoreProperties( ignoreUnknown = true)
public class Participant  extends  Entity{
}
