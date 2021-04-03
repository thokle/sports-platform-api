package com.kleist.sportsportal.entites;


import com.fasterxml.jackson.annotation.JsonBackReference;
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
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreditCard extends Entity {

    @Setter
    @Getter
    private String cardType;
    @Setter
    @Getter
    private Integer cardnumber;
    @Setter
    @Getter
    private Integer endMonth;
    @Setter
    @Getter
    private Integer endYear;
    @Setter
    @Getter
    private Integer cvc;

    @Setter
    @Getter
    @JsonBackReference
    @Relationship(direction = Relationship.INCOMING, type = "CREDIT_CARD_BELONGS_TO_MEMBER")
    @Builder.Default
    private Set<Member> member = new HashSet<>();


    public void addMember(Member member) {
        this.member.add(member);
        member.getCreditCards().add(this);
    }
}
