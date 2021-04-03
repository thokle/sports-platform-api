package com.kleist.sportsportal.handlers.club;

import com.google.inject.Inject;
import com.kleist.sportsportal.handlers.owner.HandlerGetClubs;
import com.kleist.sportsportal.services.ClubService;
import lombok.val;
import ratpack.handling.Context;
import ratpack.handling.Handler;

import static ratpack.jackson.Jackson.json;

public class HandlerGetAllClubs implements Handler {

    private ClubService clubService;
    @Inject
    public HandlerGetAllClubs(ClubService clubService){
        this.clubService = clubService;
    }
    @Override
    public void handle(Context ctx) throws Exception {
        val res = clubService.getAllClubs();


        ctx.render(json(res.get()));
    }
}
