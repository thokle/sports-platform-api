package com.kleist.sportsportal.handlers.member;

import com.google.inject.Inject;
import com.kleist.sportsportal.entites.Payment;
import com.kleist.sportsportal.services.MemberService;
import lombok.val;
import ratpack.handling.Context;
import ratpack.handling.Handler;
import ratpack.http.Status;
import ratpack.jackson.Jackson;

import static ratpack.jackson.Jackson.json;

public class HandlerAddPayment implements Handler {

    private MemberService memberService;

    @Inject
    public HandlerAddPayment(MemberService memberService){
        this.memberService = memberService;
    }

    @Override
    public void handle(Context ctx) throws Exception {
        if(ctx.getRequest().getMethod().isPost()){
             val userid = ctx.getRequest().getHeaders().get("userid");
             ctx.parse(Jackson.fromJson(Payment.class)).then(payment -> {

            val res =     memberService.AddCreditPayment(Long.parseLong(userid), payment);

            ctx.getResponse().status(Status.CREATED);
            ctx.render(json(res));
             });
        }
    }
}
