package com.kleist.sportsportal.handlers.activity;

import com.google.inject.Inject;
import com.kleist.sportsportal.entites.Member;
import com.kleist.sportsportal.services.ActivityService;
import com.kleist.sportsportal.services.MemberService;
import io.netty.buffer.ByteBuf;
import lombok.val;
import ratpack.handling.Context;
import ratpack.handling.Handler;
import ratpack.jackson.Jackson;
import ratpack.registry.Registry;

import static ratpack.jackson.Jackson.json;

public class AddMemberToActivityHandler implements Handler {

    private ActivityService activityService;


    @Inject
    public AddMemberToActivityHandler(ActivityService activityService) {

        this.activityService = activityService;

    }


    @Override
    public void handle(Context ctx) throws Exception {

        if(ctx.getRequest().getMethod().isGet()) {

                val activityid = ctx.getPathTokens().get("acid");
                val member = ctx.getRequest().getHeaders().get("memberid");
                val rest = activityService.AddMemberToActivity(Long.parseLong(member), Long.parseLong(activityid));

                ctx.render(json(rest));




        }


    }
}
