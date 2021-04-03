package com.kleist.sportsportal.handlers.activity;

import com.google.inject.Inject;
import com.kleist.sportsportal.entites.Activity;
import com.kleist.sportsportal.services.ActivityService;
import ratpack.handling.Context;
import ratpack.handling.Handler;
import ratpack.http.Status;
import ratpack.jackson.Jackson;

public class CreateActivityHandler implements Handler {

    private ActivityService activityService;
@Inject
    public CreateActivityHandler(ActivityService activityService){

        this.activityService = activityService;
    }

    @Override
    public void handle(Context ctx) throws Exception {
        if(ctx.getRequest().getMethod().isPost()){
            ctx.parse(Jackson.fromJson(Activity.class)).then(activity -> {
                this.activityService.CreateActivity(activity);
            });
            ctx.getResponse().status(Status.CREATED);
        }
    }
}
