package com.kleist.sportsportal.entites;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Member extends  Entity {
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
    private  String  memberUsername;
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
    private  String username;
    @Setter
    @Getter
    @Labels
    @Builder.Default
    private List<String> labels = new ArrayList<>();


    @Setter
    @Getter
    @Relationship(direction = Relationship.INCOMING, type = "MEMBER_BELONGS_TO_ACTIVITY")
    @Builder.Default
    private Set<Activity> activities = new HashSet<>();

    @Setter
    @Getter
    @Relationship(direction = Relationship.OUTGOING, type = "MEMBER_HAS_CHILDEREN")
    @Builder.Default
    private Set<Child> children = new HashSet<>();

    @Setter
    @Getter
    @Relationship(direction = Relationship.OUTGOING, type = "MEMBER_HAS_ADDRESSES")
    @Builder.Default
    private Set<Address> addresses = new HashSet<>();

    @Setter
    @Getter
    @Relationship(direction = Relationship.INCOMING, type = "MEMBER_BELONGS_TO_CLUBS")
    @Builder.Default
    private Set<Club> clubs = new HashSet<>();

    @Setter
    @Getter

    @Relationship(direction = Relationship.OUTGOING, type = "MEMBER_HAS_SHOP")
    @Builder.Default
    private Set<Shop> shops = new HashSet<>();

    @Setter
    @Getter
    @Relationship(direction = Relationship.OUTGOING, type = "MEMBER_HAS_PAYMENTS")
    @Builder.Default
    private Set<Payment> payments = new HashSet<>();

    @Setter
    @Getter
    @JsonBackReference(value = "member_has_paid")
    @Relationship(direction = Relationship.INCOMING, type = "MEMBER_HAS_PAID")
    @Builder.Default
    private Set<HasPaied> hasPaieds = new HashSet<>();

    @Setter
    @Getter
    @JsonBackReference
    @Relationship(direction = Relationship.OUTGOING, type = "MEMBER_HAS_CREDITCARD")
    @Builder.Default
    private Set<CreditCard> creditCards = new HashSet<>();


    @Setter
    @Getter
    @JsonBackReference(value = "MEMBER_HAS_SCORE")
    @Relationship(direction = Relationship.OUTGOING, type = "MEMBER_HAS_SCORE")
    @Builder.Default
    private Set<Score> score = new HashSet<>();

    public void addClub(Club club){
        clubs.add(club);
    club.getMembers().add(this);
    }
}
