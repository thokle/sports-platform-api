package com.kleist.sportsportal.entites;


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
public class Payment extends  Entity{

    @Setter
    @Getter
    private String currency;


    @Setter
    @Getter
    private String email;
    @Setter
    @Getter
    private Long clubId;
    @Setter
    @Getter
    private Long activity;
    @Setter
    @Getter
    private String paidDate;

    @Setter
    @Getter
    @Relationship(direction = Relationship.INCOMING, type = "PAYMENT_BELONGS_TO_MEMBER")
    @Builder.Default
    private Set<Member> member = new HashSet<>();


    public  void addMember(Member member){
        this.member.add(member);
        member.getPayments().add(this);
    }

}
