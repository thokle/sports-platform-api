package com.kleist.sportsportal.handlers.club;

import com.google.inject.Inject;
import com.kleist.sportsportal.entites.Member;
import com.kleist.sportsportal.services.ClubService;
import lombok.val;
import ratpack.handling.Context;
import ratpack.handling.Handler;
import ratpack.jackson.Jackson;

import static ratpack.jackson.Jackson.json;

public class HandlerAddMemberToClub implements Handler {

    private ClubService clubService;

    @Inject
    public HandlerAddMemberToClub(ClubService clubService){
        this.clubService = clubService;
    }

    @Override
    public void handle(Context ctx) throws Exception {
        if(ctx.getRequest().getMethod().isPost()){
            val clubid = ctx.getPathTokens().get("clubid");
            ctx.parse(Jackson.fromJson(Member.class)).then(member -> {
             val res =    this.clubService.addMembertoClub(Long.parseLong(clubid), member);
                ctx.render(json(res.get()));


            });

        }
    }
}
