package com.kleist.sportsportal.services;

import com.kleist.sportsportal.entites.Activity;
import com.kleist.sportsportal.entites.Child;
import com.kleist.sportsportal.entites.Club;
import com.kleist.sportsportal.entites.Member;
import ratpack.exec.Promise;

import java.util.Optional;
import java.util.Set;


public interface IActivityService {

      void CreateActivity(Activity activity) throws  Exception;
      Activity AddMemberToActivity(Long member, Long activity) throws  Exception;
      Activity AddChildToActivity(Child child, Activity activity) throws  Exception;
      void  UpdateActivity(Activity activity) throws  Exception;
     Activity getActivityById(int id);
     Optional<Club> getActivityByCvr(Long cvr) throws  Exception;

}
