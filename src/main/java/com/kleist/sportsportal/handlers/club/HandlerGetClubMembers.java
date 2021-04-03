package com.kleist.sportsportal.handlers.club;

import com.google.inject.Inject;
import com.kleist.sportsportal.services.ClubService;
import lombok.val;
import ratpack.handling.Context;
import ratpack.handling.Handler;

import static ratpack.jackson.Jackson.json;

public class HandlerGetClubMembers implements Handler {

    private ClubService clubService;
    @Inject
    public HandlerGetClubMembers(ClubService clubService){
        this.clubService = clubService;
    }

    @Override
    public void handle(Context ctx) throws Exception {
        if(ctx.getRequest().getMethod().isGet()){
          val name =   ctx.getPathTokens().get("name");
          val members = clubService.getAllMembersOfAClubByNameAndType(name);
          ctx.render(json(members.get()));
        }
    }
}
