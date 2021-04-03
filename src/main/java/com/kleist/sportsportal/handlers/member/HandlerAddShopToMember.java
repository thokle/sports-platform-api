package com.kleist.sportsportal.handlers.member;

import com.google.inject.Inject;
import com.kleist.sportsportal.entites.Shop;
import com.kleist.sportsportal.services.MemberService;
import lombok.val;
import ratpack.handling.Context;
import ratpack.handling.Handler;
import ratpack.http.Status;
import ratpack.jackson.Jackson;

import static ratpack.jackson.Jackson.json;

public class HandlerAddShopToMember implements Handler {

    private MemberService memberService;
    @Inject
    public HandlerAddShopToMember(MemberService memberService){
        this.memberService = memberService;
    }

    @Override
    public void handle(Context ctx) throws Exception {
        ctx.parse(Jackson.fromJson(Shop.class)).then(shop -> {
            val memberId = ctx.getRequest().getHeaders().get("memberId");
            val res = memberService.AddShop(Long.parseLong(memberId), shop);
            ctx.getResponse().status(Status.CREATED);
            ctx.render(json(res));
        });
    }
}
