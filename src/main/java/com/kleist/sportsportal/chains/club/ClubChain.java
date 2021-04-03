package com.kleist.sportsportal.chains.club;

import com.kleist.sportsportal.handlers.club.*;
import ratpack.func.Action;
import ratpack.handling.Chain;
import ratpack.http.Status;

public class ClubChain implements Action<Chain> {
    @Override
    public void execute(Chain chain) throws Exception {
        chain.get("create", HandlerCreateClub.class).post("addowner", HandlerAddOwnertoClub.class)
                .post("addactivity/:clubid", HandlerAddActivity.class)
                .post("addmember/:clubid", HandlerAddMemberToClub.class)
                .get("getactivites/:clubid", HandlerGetActivities.class)
                .get("allclubs",HandlerGetAllClubs.class).get("members/:name", HandlerGetClubMembers.class);
    }
}
