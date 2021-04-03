package com.kleist.sportsportal.handlers.activity;

import com.google.inject.Inject;
import com.kleist.sportsportal.entites.HasPaied;
import com.kleist.sportsportal.services.MemberService;
import lombok.val;
import ratpack.handling.Context;
import ratpack.handling.Handler;
import ratpack.jackson.Jackson;

import static ratpack.jackson.Jackson.json;

public class HasPaidHandler implements Handler {

    MemberService memberService;

    @Inject
    public HasPaidHandler(MemberService memberService){
        this.memberService = memberService;
    }

    @Override
    public void handle(Context ctx) throws Exception {
        if(ctx.getRequest().getMethod().isPost()){
            ctx.parse(Jackson.fromJson(HasPaied.class)).then(hasPaied -> {
               val menberid =  ctx.getRequest().getHeaders().get("memberid");
               val resultat  = this.memberService.hasPaid(hasPaied, Long.parseLong(menberid));
               ctx.render(json(resultat.get()));
            });
        }
    }
}
