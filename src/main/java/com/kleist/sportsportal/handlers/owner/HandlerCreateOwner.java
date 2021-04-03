package com.kleist.sportsportal.handlers.owner;

import com.google.inject.Inject;
import com.kleist.sportsportal.entites.Owner;
import com.kleist.sportsportal.services.OwnerService;
import com.kleist.sportsportal.services.SecutityService;
import ratpack.handling.Context;
import ratpack.handling.Handler;
import ratpack.http.Status;
import ratpack.jackson.Jackson;

import static ratpack.jackson.Jackson.json;

public class HandlerCreateOwner implements Handler {

    private OwnerService ownerService;
    private SecutityService secutityService;

    @Inject
    public  HandlerCreateOwner(OwnerService ownerService, SecutityService secutityService){
        this.ownerService = ownerService;
        this.secutityService = secutityService;
    }
    @Override
    public void handle(Context ctx) throws Exception {
        if(ctx.getRequest().getMethod().isPost()){
            ctx.parse(Jackson.fromJson(Owner.class)).then(owner -> {
                owner.setPassword(this.secutityService.endcodePassword(owner.getPassword()));

                this.ownerService.create(owner);
                ctx.getResponse().status(Status.CREATED);
                ctx.render(json(owner));
            });


        }
    }
}
