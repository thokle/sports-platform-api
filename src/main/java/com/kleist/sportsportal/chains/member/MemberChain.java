package com.kleist.sportsportal.chains.member;

import com.kleist.sportsportal.handlers.activity.HasPaidHandler;
import com.kleist.sportsportal.handlers.member.*;
import ratpack.func.Action;
import ratpack.handling.Chain;
import ratpack.handling.Handler;
import ratpack.registry.Registry;
import ratpack.server.ServerConfig;

public class    MemberChain implements Action<Chain> {

    @Override
    public void execute(Chain chain) throws Exception {
        chain.get(Get.class).get("byid/:id", GetByIdHandler.class)
                .post("create", Post.class)
                .get("login", LoginHandler.class)
                .post("addchild", HandlerAddChild.class)
                .post("addpayment", HandlerAddPayment.class)
                .post("address", HandlerAddAdressMember.class)
                    .post("haspaid", HasPaidHandler.class)
                .post("addCreditCard", HandlerAddCreditCard.class).post("addshop", HandlerAddShopToMember.class)
                .get("update/:acticityId/:haspaid", HasPaidUpdateHandler.class).get("creditcards", HandlerGetMemberCreditCards.class);
    }
}
