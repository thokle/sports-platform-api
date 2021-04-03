package com.kleist.sportsportal.services;

import com.google.inject.Inject;
import com.kleist.sportsportal.entites.Activity;
import com.kleist.sportsportal.entites.Address;
import com.kleist.sportsportal.entites.Coach;
import com.kleist.sportsportal.exceptions.CoachExistsException;
import lombok.val;
import org.neo4j.ogm.session.Session;

import java.util.HashMap;
import java.util.Optional;

public class CoachService implements  ICoachService{


    private Session session;
    private  SecutityService secutityService;
    @Inject
    public CoachService(Session session, SecutityService secutityService ){
        this.session = session;
        this.secutityService = secutityService;
    }
    @Override
    public void createCoach(Coach coach) {
        try {
            val map = new HashMap<String, Object>();
            map.put("username", coach.getUsername());
            map.put("email", coach.getEmail());
            map.put("mobil", coach.getMobil());
            val res = session.query(Coach.class, "match (c:Coach) where c.username=$username and c.email=$coach and mobil=$mobil return c", map);

            if(res.iterator().hasNext()){
                throw new CoachExistsException("Coach already exists ");
            }else {
                session.save(coach);
            }
        }catch (Exception ex){}

    }

    @Override
    public Optional<Coach> getCoachbyId(long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Coach> addActicity(long id, Activity activity) {
        return Optional.empty();
    }

    @Override
    public Optional<Coach> addAddress(long id, Address address) {
        return Optional.empty();
    }

    @Override
    public Optional<Coach> Login(String username, String password) {
        return Optional.empty();
    }
}
