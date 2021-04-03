package com.kleist.sportsportal.handlers.owner;

import com.google.inject.Inject;
import com.kleist.sportsportal.services.OwnerService;
import lombok.val;
import ratpack.handling.Context;
import ratpack.handling.Handler;

import static ratpack.jackson.Jackson.json;

public class HandlerGetClubs implements Handler {

    private OwnerService ownerService;
    @Inject
    public HandlerGetClubs(OwnerService ownerService) {
        this.ownerService = ownerService;
    }


    @Override
    public void handle(Context ctx) throws Exception {
        if(ctx.getRequest().getMethod().isGet()) {
           val ownerId =  ctx.getRequest().getHeaders().get("ownerid");
           val clubs = ownerService.getClubsByOwnerId(Long.parseLong(ownerId));
           ctx.render(json(clubs.get()));
        }

    }
}
