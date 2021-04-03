package com.kleist.sportsportal.handlers.member;

import com.google.inject.Inject;
import com.kleist.sportsportal.entites.Member;
import com.kleist.sportsportal.services.MemberService;
import ratpack.handling.Context;
import ratpack.handling.Handler;
import ratpack.jackson.Jackson;

public class Get implements Handler {


    private  MemberService  memberService;
    @Inject
    public Get(MemberService memberService){this.memberService = memberService;
    }

    @Override
    public void handle(Context ctx) throws Exception {

ctx.getResponse().send("hello");

    }
}
