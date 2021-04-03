package com.kleist.sportsportal.entites;


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
public class HasPaied extends Entity {

    @Getter
    @Setter
    private Long activityId;

    @Getter
    @Setter
    private Long particapenId;

    @Getter
    @Setter
    private boolean hasPaied;

    @Setter
    @Getter
    @JsonIgnore
    @Relationship(direction = Relationship.OUTGOING, type = "BELONGS_TO_MEMBER")
    @Builder.Default
    private Set<Member> members = new HashSet<>();

    public void addMember(Member member){
        members.add(member);
        member.getHasPaieds().add(this);
    }

}