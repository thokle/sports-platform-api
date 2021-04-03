package com.kleist.sportsportal.services;

import com.kleist.sportsportal.entites.Activity;
import com.kleist.sportsportal.entites.Club;
import com.kleist.sportsportal.entites.Coach;
import com.kleist.sportsportal.entites.Member;
import ratpack.exec.Promise;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface IClubService {
    public  void create(Club club);
    public Promise<Club> getClubById(Long id) throws Exception;
    public void  addOwnerToClub(Club club);
    public Optional<Club> addMembertoClub(Long clubid,Member member) throws Exception;
    public Optional<Club> addActivityToClub(Long clubid, Activity activity) throws Exception;
    public Optional<Club> addCoach(Long id , Coach coach);
    public Optional<List<Club>> getClubByOwner(Long ownerID);
    public Optional<Set<Activity>>  getActivitiesByClub(Long id) throws Exception;
    public Optional<Collection<Club>> getAllClubs() throws  Exception;
    public Optional<Iterable<Member>> getAllMembersOfAClubByNameAndType(String clubname) throws  Exception;
}
