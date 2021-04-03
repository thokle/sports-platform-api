package com.kleist.sportsportal.services;

import com.kleist.sportsportal.entites.Activity;
import com.kleist.sportsportal.entites.Club;
import com.kleist.sportsportal.entites.Owner;
import com.kleist.sportsportal.entites.Payment;

import java.util.Optional;
import java.util.Set;

public interface IOwnerService {
    public  void create(Owner owner) throws Exception;
    public Optional<Owner> getOwnerById(Long id);
    public  Optional<Owner> AddClubToOwner(Long id, Club club) throws Exception;
    public Optional<Owner> AddPaymentMethod(Long id, Payment payment) throws Exception;
    public  Optional<Owner> login(String username, String password) throws Exception;
    public Optional<Set<Club>> getClubsByOwnerId(Long id) throws  Exception;

}
