package com.kleist.sportsportal.handlers.member;

import com.google.inject.Inject;
import com.kleist.sportsportal.services.MemberService;
import lombok.val;
import ratpack.handling.Context;
import ratpack.handling.Handler;

import static ratpack.jackson.Jackson.json;

public class HasPaidUpdateHandler implements Handler {

    private MemberService memberService;

    @Inject
    public HasPaidUpdateHandler(MemberService memberService){
        this.memberService  = memberService;
    }

    @Override
    public void handle(Context context) throws Exception {

        //:acticityId/:haspaid

        val acid = context.getPathTokens().get("acticityId");
        val hasPaid = context.getPathTokens().get("haspaid");
        val res = memberService.updateHasPaid(Long.parseLong(acid),hasPaid(hasPaid));
        context.render(json(res.get()));
    }

    private  boolean hasPaid(String haspaid) {
       if(Integer.parseInt(haspaid) == 1){
           return  true;
       } else {
           return  false;
       }
    }
}
