package com.kleist.sportsportal.entites;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.HashSet;
import java.util.Set;

@NodeEntity
@Builder
@AllArgsConstructor
@JsonIgnoreProperties( ignoreUnknown = true)
public class Score  extends  Entity {

    @Getter
    @Setter
    private  int score;


    @Setter
    @Getter
    private  String timeStamp;

    @Setter
    @Getter
    @Relationship(direction = Relationship.INCOMING, type = "BELONGS_TO_MEMBER")
    @Builder.Default
    private Set<Member> members = new HashSet<>();

    @Setter
    @Getter
    @Relationship(direction = Relationship.INCOMING, type = "BELONGS_TO_ACTIVITY")
    @Builder.Default
    private Set<Activity> activities = new HashSet<>();



    public void addMember(Member member) {
        this.members.add(member);
        member.getScore().add(this);
    }

    public void addActivity(Activity activity) {
        this.activities.add(activity);
        activity.getScores().add(this);
    }
}
