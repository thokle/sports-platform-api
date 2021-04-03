package com.kleist.sportsportal.services;

import com.kleist.sportsportal.entites.Activity;
import com.kleist.sportsportal.entites.Address;
import com.kleist.sportsportal.entites.Coach;

import java.util.Optional;

public interface ICoachService {
public  void createCoach(Coach coach);
public Optional<Coach> getCoachbyId(long id);
public Optional<Coach> addActicity(long id, Activity activity);
public Optional<Coach> addAddress(long id, Address address);
public Optional<Coach> Login(String username, String password);

}
