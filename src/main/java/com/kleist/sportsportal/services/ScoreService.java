package com.kleist.sportsportal.services;

import com.google.inject.Inject;
import com.kleist.sportsportal.entites.Activity;
import com.kleist.sportsportal.entites.Member;
import com.kleist.sportsportal.entites.Score;
import lombok.val;
import org.neo4j.ogm.session.Session;

import java.util.Optional;

public class ScoreService implements  IScoreService{

    private Session session;
    @Inject
    public ScoreService(Session session){
        this.session = session;
    }

    @Override
    public Optional<Score> addScore(Long memberId, Long activity, Score score) throws Exception {
        try {
            val menber = this.session.load(Member.class, memberId, 4);
            val act = this.session.load(Activity.class, activity, 4);
            score.addActivity(act);
            score.addMember(menber);
            this.session.save(score);
            return  Optional.of(score);
        }catch (Exception ex){
            throw  new Exception(ex.getMessage(), ex.getCause());
        }
    }
}
