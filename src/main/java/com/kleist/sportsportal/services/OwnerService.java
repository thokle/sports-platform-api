package com.kleist.sportsportal.services;

import com.google.inject.Inject;
import com.kleist.sportsportal.entites.Activity;
import com.kleist.sportsportal.entites.Club;
import com.kleist.sportsportal.entites.Owner;
import com.kleist.sportsportal.entites.Payment;
import lombok.val;
import org.neo4j.ogm.session.Session;


import java.util.HashMap;
import java.util.Optional;
import java.util.Set;

public class OwnerService implements  IOwnerService{

    private Session session;
    private  SecutityService secutityService;

  @Inject
  public OwnerService(Session session, SecutityService secutityService){
      this.session = session;
      this.secutityService = secutityService;
  }
    @Override
    public void create(Owner owner) throws Exception {
        try {
            session.save(owner);

        } catch (Exception ex){
            throw  new Exception(ex.getMessage(),ex.getCause());

        }
    }

    @Override
    public Optional<Owner> getOwnerById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Owner> AddClubToOwner(Long id, Club club) throws Exception {
      try {
         val owner =  session.load(Owner.class, id);
         club.addOwner(owner);
         session.save(owner);
         return Optional.of(owner);
      } catch (Exception ex) {
          throw  new Exception(ex.getMessage(), ex.getCause());
      }

    }

    @Override
    public Optional<Owner> AddPaymentMethod(Long id, Payment payment) throws Exception {
        try {

            val owner = session.load(Owner.class, id);
            return Optional.of(owner);
        }catch (Exception ex) {
            throw new Exception(ex.getMessage(), ex.getCause());
        }
    }

    @Override
    public Optional<Owner> login(String username, String password) throws Exception {
      try {
          val map = new HashMap<String, Object>();
          map.put("ownerUsername", username);
          map.put("password", password);
            return  Optional.of(session.queryForObject(Owner.class ,"match (o:Owner) where o.ownerUsername=$ownerUsername and o.password=$password return o",map));
      }catch (Exception ex) {
       throw  new Exception(ex.getMessage(),ex.getCause());
      }
    }

    @Override
    public Optional<Set<Club>> getClubsByOwnerId(Long id) throws Exception {
        try {
           val owner =  session.load(Owner.class, id, 5);
           return Optional.of(owner.getClubs());
        } catch (Exception ex) {
            throw new Exception(ex.getMessage(), ex.getCause());
        }
    }

}
