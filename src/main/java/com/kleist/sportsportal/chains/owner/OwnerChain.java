package com.kleist.sportsportal.chains.owner;

import com.kleist.sportsportal.handlers.owner.HandlerGetClubs;
import com.kleist.sportsportal.handlers.owner.HandlerAddClub;
import com.kleist.sportsportal.handlers.owner.HandlerCreateOwner;
import com.kleist.sportsportal.handlers.owner.HandlerLoginOwner;
import ratpack.func.Action;
import ratpack.handling.Chain;

public class OwnerChain implements Action<Chain> {
    @Override
    public void execute(Chain chain) throws Exception {
        chain.post("create", HandlerCreateOwner.class).post("addclub", HandlerAddClub.class).get("login", HandlerLoginOwner.class).get("clubs", HandlerGetClubs.class);
    }
}
