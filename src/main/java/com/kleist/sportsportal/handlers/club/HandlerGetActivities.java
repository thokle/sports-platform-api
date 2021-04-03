package com.kleist.sportsportal.handlers.club;

import com.google.inject.Inject;
import com.kleist.sportsportal.services.ClubService;
import lombok.val;
import ratpack.handling.Context;
import ratpack.handling.Handler;

import static ratpack.jackson.Jackson.json;

public class HandlerGetActivities implements Handler {

    private ClubService clubService;

    @Inject
    public  HandlerGetActivities(ClubService clubService){
        this.clubService = clubService;
    }

    @Override
    public void handle(Context ctx) throws Exception {
        if(ctx.getRequest().getMethod().isGet()) {
            val clubid =    ctx.getPathTokens().get("clubid");
          val val =   this.clubService.getActivitiesByClub(Long.parseLong(clubid));

          ctx.render(json(val.get()));
        }


    }
}
