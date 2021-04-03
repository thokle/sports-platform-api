package com.kleist.sportsportal.handlers.member;

import com.google.inject.Inject;
import com.kleist.sportsportal.entites.HasPaied;
import com.kleist.sportsportal.services.MemberService;
import lombok.val;
import ratpack.handling.Context;
import ratpack.handling.Handler;
import ratpack.jackson.Jackson;

import static ratpack.jackson.Jackson.json;

public class HandlerHasPaid implements Handler {

    private MemberService memberService;

    @Inject
    public HandlerHasPaid(MemberService m){
        this.memberService = m;
    }


    @Override
    public void handle(Context context) throws Exception {
        if(context.getRequest().getMethod().isPost()){
            context.parse(Jackson.fromJson(HasPaied.class)).then(hasPaied -> {
                val memberid = context.getRequest().getHeaders().get("memberid");
               val res =  this.memberService.hasPaid(hasPaied, Long.parseLong(memberid));
               context.render(json(res.get()));
            });
        }

    }
}
