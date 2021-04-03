package com.kleist.sportsportal.handlers.member;


import com.google.inject.Inject;
import com.kleist.sportsportal.entites.Address;
import com.kleist.sportsportal.services.MemberService;
import lombok.val;
import ratpack.handling.Context;
import ratpack.handling.Handler;
import ratpack.jackson.Jackson;

import static ratpack.jackson.Jackson.json;

public class HandlerAddAdressMember  implements Handler {

    private MemberService memberService;
@Inject
    public  HandlerAddAdressMember(MemberService memberService){
        this.memberService = memberService;
    }
    @Override
    public void handle(Context ctx) throws Exception {
        if(ctx.getRequest().getMethod().isPost()) {
            ctx.parse(Jackson.fromJson(Address.class)).then(address -> {

              val memberId =   ctx.getRequest().getHeaders().get("memberid");

              val resultat = this.memberService.AddAdress(Long.parseLong(memberId), address);

        ctx.render(json(resultat));
            });

        }

    }
}
