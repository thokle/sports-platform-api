package com.kleist.sportsportal.handlers.member;

import com.google.inject.Inject;
import com.kleist.sportsportal.services.MemberService;
import lombok.val;
import ratpack.handling.Context;
import ratpack.handling.Handler;
import ratpack.jackson.Jackson;

import static ratpack.jackson.Jackson.json;

public class LoginHandler implements Handler {

    private MemberService memberService;

    @Inject
    public LoginHandler(MemberService memberService){
        this.memberService = memberService;
    }

    @Override
    public void handle(Context ctx) throws Exception {
        if(ctx.getRequest().getMethod().isGet()){

            val usermame = ctx.getRequest().getHeaders().get("username");
            val password = ctx.getRequest().getHeaders().get("password");

           val member =  this.memberService.Login(usermame, password);

           ctx.render(json(member.get()));

        }
    }
}
