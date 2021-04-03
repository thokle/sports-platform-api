package com.kleist.sportsportal.handlers.member;

import com.google.inject.Inject;
import com.kleist.sportsportal.services.MemberService;
import lombok.val;
import ratpack.handling.Context;
import ratpack.handling.Handler;

import static ratpack.jackson.Jackson.json;

public class GetByIdHandler implements Handler {

    private  MemberService  memberService;
    @Inject
    public GetByIdHandler(MemberService memberService){this.memberService = memberService;
    }


    @Override
    public void handle(Context ctx) throws Exception {
        if (ctx.getRequest().getMethod().isGet()) {
           val id = ctx.getPathTokens().get("id");
            val member = memberService.GetMemberById(Long.parseLong(id));
            ctx.render(json(member));
        } else {
            ctx.next();
        }
    }
}
