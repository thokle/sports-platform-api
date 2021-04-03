package com.kleist.sportsportal.handlers.owner;

import com.google.inject.Inject;
import com.kleist.sportsportal.entites.Club;
import com.kleist.sportsportal.entites.Owner;
import com.kleist.sportsportal.services.OwnerService;
import lombok.val;
import ratpack.handling.Context;
import ratpack.handling.Handler;
import ratpack.http.Status;
import ratpack.jackson.Jackson;

import static ratpack.jackson.Jackson.json;

public class HandlerAddClub implements Handler {


    private OwnerService ownerService;
@Inject
    public  HandlerAddClub(OwnerService ownerService){
        this.ownerService = ownerService;
    }
    @Override
    public void handle(Context ctx) throws Exception {
        if(ctx.getRequest().getMethod().isPost()){
            ctx.parse(Jackson.fromJson(Club.class)).then(club -> {
                val ownerId = ctx.getRequest().getHeaders().get("ownerid");
               val owner =  this.ownerService.AddClubToOwner(Long.parseLong(ownerId), club);
               ctx.getResponse().status(Status.CREATED);
               ctx.render(json(owner.get()));
            });

        }
    }
}
