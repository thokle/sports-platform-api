package com.kleist.sportsportal.handlers.activity;

import com.google.inject.Inject;
import com.kleist.sportsportal.entites.Activity;
import com.kleist.sportsportal.services.ActivityService;
import lombok.val;
import ratpack.handling.Context;
import ratpack.handling.Handler;

import static ratpack.jackson.Jackson.json;

public class HandlerCvrActivity implements Handler {

    private ActivityService activityService;

    @Inject
    public HandlerCvrActivity(ActivityService activityService){
        this.activityService = activityService;
    }

    @Override
    public void handle(Context context) throws Exception {
        if(context.getRequest().getMethod().isGet()){
            val cvr = context.getPathTokens().get("cvr");
            val res = this.activityService.getActivityByCvr(Long.parseLong(cvr));
            context.render(json(res.get()));
        }
    }
}
