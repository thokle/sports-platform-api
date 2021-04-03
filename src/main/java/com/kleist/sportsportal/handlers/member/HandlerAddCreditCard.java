package com.kleist.sportsportal.handlers.member;

import com.google.inject.Inject;
import com.kleist.sportsportal.entites.CreditCard;
import com.kleist.sportsportal.entites.Member;
import com.kleist.sportsportal.services.MemberService;
import lombok.val;
import ratpack.handling.Context;
import ratpack.handling.Handler;
import ratpack.jackson.Jackson;

import static ratpack.jackson.Jackson.json;

public class HandlerAddCreditCard implements Handler {

    private MemberService memberService;

    @Inject
    public HandlerAddCreditCard(MemberService memberService){
        this.memberService = memberService;
    }

    @Override
    public void handle(Context context) throws Exception {
        if(context.getRequest().getMethod().isPost()){
            context.parse(Jackson.fromJson(CreditCard.class)).then(creditCard -> {
              val memberid =  context.getRequest().getHeaders().get("memberid");
            val res  =  this.memberService.addCreditCard(Long.parseLong(memberid), creditCard);
            context.render(json(res.get()));

            });
        }
    }
}
