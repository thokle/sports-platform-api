package com.kleist.sportsportal.handlers.member;

import com.google.inject.Inject;
import com.kleist.sportsportal.entites.Member;
import com.kleist.sportsportal.services.MemberService;

import com.kleist.sportsportal.services.SecutityService;
import ratpack.handling.Context;
import ratpack.handling.Handler;
import ratpack.http.Status;
import ratpack.jackson.Jackson;

public class Post implements Handler {

    private MemberService memberService;
    private SecutityService secutityService;
    @Inject
    public Post(MemberService memberService, SecutityService secutityService){
        this.memberService = memberService;
        this.secutityService = secutityService;
    }

    @Override
    public void handle(Context ctx) throws Exception {
        if(ctx.getRequest().getMethod().isPost()){
            ctx.parse(Jackson.fromJson(Member.class)).then(member -> {

                member.setPassword(this.secutityService.endcodePassword(member.getPassword()));
                memberService.CreateMember(member);

ctx.getResponse().status(Status.CREATED);
ctx.render("Member Created");
            });
        } else {
            ctx.next();
        }
    }
}
