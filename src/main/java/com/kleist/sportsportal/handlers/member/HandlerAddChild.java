package com.kleist.sportsportal.handlers.member;

import com.google.inject.Inject;
import com.kleist.sportsportal.entites.Child;
import com.kleist.sportsportal.services.MemberService;
import lombok.val;
import ratpack.handling.Context;
import ratpack.handling.Handler;
import ratpack.jackson.Jackson;

import static ratpack.jackson.Jackson.json;

public class HandlerAddChild implements Handler {

    private MemberService memberService;

    @Inject
    public HandlerAddChild(MemberService memberService){
        this.memberService = memberService;
    }

    @Override
    public void handle(Context ctx) throws Exception {
        if(ctx.getRequest().getMethod().isPost()){
ctx.parse(Jackson.fromJson(Child.class)).then( child -> {
    val userid  = ctx.getRequest().getHeaders().get("userid");
 val response =    this.memberService.AddChild(Long.parseLong(userid), child);
    ctx.render(json(response.get()));
});

        }
    }
}
