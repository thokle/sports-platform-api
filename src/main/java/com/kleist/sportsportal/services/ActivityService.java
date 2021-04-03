package com.kleist.sportsportal.services;

import com.google.inject.Inject;
import com.kleist.sportsportal.entites.Activity;
import com.kleist.sportsportal.entites.Child;
import com.kleist.sportsportal.entites.Club;
import com.kleist.sportsportal.entites.Member;
import com.kleist.sportsportal.exceptions.ActivityFilledException;
import lombok.val;
import org.neo4j.ogm.session.Session;
import ratpack.exec.Promise;

import java.util.HashMap;
import java.util.Optional;
import java.util.Set;

public class ActivityService implements  IActivityService{

    private Session session;

@Inject
    public  ActivityService(Session session){
        this.session = session;
    }


    @Override
    public void CreateActivity(Activity activity) throws Exception {
        session.save(activity);
    }

    @Override
    public  Activity AddMemberToActivity(Long member, Long activity) throws Exception {

        try {

          Activity activity1 =  this.session.load(Activity.class, activity);
          Member member1 = this.session.load(Member.class, member);
          if(activity1.getParticipates() == null){
              activity1.AddMember(member1);
              activity1.setParticipates(1 );
              this.session.save(activity1);
              return  activity1;
          }
          else if(activity1.getParticipates() < activity1.getMax()) {
              activity1.AddMember(member1);
              activity1.setParticipates(activity1.getParticipates() +1 );
              this.session.save(activity1);
              return  activity1;
          } else {
              throw  new ActivityFilledException(activity1.getName() + " is fully booked you will be added to a waiting list");
          }

        }catch (Exception exception) {

            throw  new Exception(exception.getMessage(), exception.getCause());
        }

    }

    @Override
    public Activity  AddChildToActivity(Child child, Activity activity) throws Exception {

        val loadActivity = session.load(Activity.class, activity.getId(), 3);
        val loadChild = session.load(Child.class, child.getId(), 3);
        if(loadActivity.getParticipates() >= loadActivity.getMax()) {

        }else  {
            loadActivity.getChildren().add(child);
            session.save(loadActivity);
        }
return  loadActivity;
    }

    @Override
    public void UpdateActivity(Activity activity) throws Exception {

    }

    @Override
    public Activity getActivityById(int id) {
        return session.load(Activity.class, id);
    }

    @Override
    public Optional<Club> getActivityByCvr(Long cvr) throws Exception {
       try {
           val map = new HashMap<String, Object>();
           map.put("cvr", cvr);
           val res = this.session.query(Club.class  ,"match (c:Club {cvr:$cvr})-[r:CLUB_HAS_ACTIVITY]->(a:Activity) return c,r,a", map);
           return  Optional.of(res.iterator().next());
       }catch (Exception ex){
           throw  new Exception(ex.getMessage(), ex.getCause());
       }
    }


}
