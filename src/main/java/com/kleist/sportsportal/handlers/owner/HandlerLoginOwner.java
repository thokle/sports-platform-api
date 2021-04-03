package com.kleist.sportsportal.handlers.owner;

import com.google.inject.Inject;
import com.kleist.sportsportal.entites.Owner;
import com.kleist.sportsportal.services.OwnerService;
import com.kleist.sportsportal.services.SecutityService;
import lombok.val;
import ratpack.handling.Context;
import ratpack.handling.Handler;

import static ratpack.jackson.Jackson.json;

public class HandlerLoginOwner implements Handler {

    private OwnerService ownerService;
    private SecutityService secutityService;
   @Inject
   public HandlerLoginOwner(OwnerService ownerService, SecutityService secutityService){
       this.ownerService = ownerService;
       this.secutityService = secutityService;
   }
    @Override
    public void handle(Context ctx) throws Exception {
        if(ctx.getRequest().getMethod().isGet()){
            val username = ctx.getRequest().getHeaders().get("username");
            val password = ctx.getRequest().getHeaders().get("password");

         val owner =    this.ownerService.login(username, this.secutityService.endcodePassword(password));
            ctx.render(json(owner.get()));
        }
    }
}
