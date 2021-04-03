package com.kleist.sportsportal.handlers.club;

import com.google.inject.Inject;
import com.kleist.sportsportal.entites.Activity;
import com.kleist.sportsportal.entites.Club;
import com.kleist.sportsportal.entites.Owner;
import com.kleist.sportsportal.handlers.activity.HasPaidHandler;
import com.kleist.sportsportal.services.ClubService;
import lombok.val;
import ratpack.handling.Context;
import ratpack.handling.Handler;
import ratpack.jackson.Jackson;
import ratpack.registry.Registry;

import static ratpack.jackson.Jackson.json;

public class HandlerAddActivity implements Handler {

    private ClubService clubService;
@Inject
    public HandlerAddActivity(ClubService  clubService){
        this.clubService = clubService;
    }

    @Override
    public void handle(Context ctx) throws Exception {
if(ctx.getRequest().getMethod().isPost()){
    ctx.parse(Jackson.fromJson(Activity.class)).then(activity -> {
        val clubId = ctx.getPathTokens().get("clubid");
         val res =    clubService.addActivityToClub(Long.parseLong(clubId),activity );

        ctx.render(json(res.get()));

    });

}

    }
}
