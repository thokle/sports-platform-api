package com.kleist.sportsportal.handlers.member;

import com.google.inject.Inject;
import com.kleist.sportsportal.services.MemberService;
import lombok.val;
import ratpack.handling.Context;
import ratpack.handling.Handler;

import static ratpack.jackson.Jackson.json;

public class HandlerGetMemberCreditCards implements Handler {

    private MemberService memberService;
    @Inject
    public HandlerGetMemberCreditCards(MemberService  memberService){
        this.memberService = memberService;
    }

    @Override
    public void handle(Context context) throws Exception {
        if(context.getRequest().getMethod().isGet()){
            val memberid = context.getRequest().getHeaders().get("memberid");
            val res = memberService.GetCreditCardByMemberId(Long.parseLong(memberid));
            context.render(json(res.get()));
        }
    }
}
