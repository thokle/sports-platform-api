package com.kleist.sportsportal.services;

import com.google.inject.Inject;
import com.kleist.sportsportal.entites.Activity;
import com.kleist.sportsportal.entites.Club;
import com.kleist.sportsportal.entites.Coach;
import com.kleist.sportsportal.entites.Member;
import com.kleist.sportsportal.exceptions.UserExistsException;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.neo4j.ogm.session.Session;
import ratpack.exec.Promise;

import java.util.*;

@Slf4j
public class ClubService implements  IClubService
{

    private Session session = null;
@Inject
    public  ClubService(Session session){
        this.session = session;
    }
    @Override
    public void create(Club club) {
        try {
            val map = new HashMap<String, Object>();
            val res = session.query(Club.class, "macth (c:Club) where c.cvr=$cvr", map);
            if(res.iterator().hasNext()){

            }else {

            }
        }catch (Exception ex){

        }
    }

    @Override
    public Promise<Club> getClubById(Long id) throws Exception {
        try {
            return  Promise.value(session.load(Club.class, id));
        } catch (Exception ex) {
            throw  new Exception(ex.getMessage(), ex.getCause());
        }
    }

    @Override
    public void addOwnerToClub(Club club) {

    }

    @Override
    public Optional<Club> addMembertoClub(Long clubid, Member member) throws Exception {
        try {
            val map = new HashMap<String, Object>();
            map.put("memberUsername", member.getMemberUsername());
            map.put("email", member.getEmail());
           val userexcist = session.query("match (m:Member) where m.memberUsername=$memberUsername and m.email=$email return m", map);

           if(userexcist.iterator().hasNext()) {
               throw  new UserExistsException("Bruger eksistere i forvejen");
           } else {
               val club = session.load(Club.class, clubid);
               //club.getActivities().add(activity);
               member.addClub(club);
               club.addMember(member);
               session.save(club);
               return Optional.of(club);
           }
        }catch (Exception ex) {
            throw  new Exception(ex.getMessage(),ex.getCause());
        }
    }

    @Override
    public Optional<Club> addActivityToClub(Long clubid, Activity activity) throws Exception {
        try {
            val club =  session.load(Club.class, clubid);
            //club.getActivities().add(activity);
            activity.AddClub(club);
            session.save(club);
            return Optional.of(club);
        }catch (Exception ex) {
            throw  new Exception(ex.getMessage(),ex.getCause());
        }

    }

    @Override
    public Optional<Club> addCoach(Long id, Coach coach) {
        return Optional.empty();
    }

    @Override
    public Optional<List<Club>> getClubByOwner(Long ownerID) {
        return Optional.empty();
    }

    @Override
    public Optional<Set<Activity>> getActivitiesByClub(Long id) throws Exception {
        try {
           val club =      session.load(Club.class, id);
          return Optional.of(club.getActivities());
        }catch (Exception ex) {
            throw  new Exception(ex.getMessage(), ex.getCause());
        }
    }

    @Override
    public Optional<Collection<Club>> getAllClubs() throws Exception {
try {
    return  Optional.of(session.loadAll(Club.class));
}catch (Exception ex) {
    throw  new Exception(ex.getMessage(), ex.getCause());
}
    }

    @Override
    public Optional<Iterable<Member>> getAllMembersOfAClubByNameAndType(String clubname) throws Exception {
        try {
            val map = new HashMap<String, Object>();
       return Optional.of(session.query(Member.class ,"optional  match (c:Club  {name:$clubname})-[mr:CLUB_HAS_MEMBERS]-(m:Member) return m", map));
        }catch(Exception ex ) {
            throw new Exception(ex.getMessage(), ex.getCause());
        }
    }
}
