package com.kleist.sportsportal.chains.activity;

import com.kleist.sportsportal.handlers.activity.AddMemberToActivityHandler;
import com.kleist.sportsportal.handlers.activity.HandlerCvrActivity;
import com.kleist.sportsportal.handlers.member.Get;
import ratpack.func.Action;
import ratpack.handling.Chain;
import ratpack.handling.Handler;
import ratpack.registry.Registry;
import ratpack.server.ServerConfig;

public class ActivityChain implements Action<Chain> {

    @Override
    public void execute(Chain chain) throws Exception {
        chain.get(Get.class).get("add/:acid", AddMemberToActivityHandler.class).get("/:cvr", HandlerCvrActivity.class);
    }
}
