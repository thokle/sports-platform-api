package com.kleist.sportsportal.handlers.shop;

import com.google.inject.Inject;
import com.kleist.sportsportal.services.ShopService;
import lombok.val;
import ratpack.handling.Context;
import ratpack.handling.Handler;

import static ratpack.jackson.Jackson.json;

public class ShopHandlerByUserName implements Handler {

    private ShopService shopService;
@Inject
    public ShopHandlerByUserName(ShopService shopService){
        this.shopService = shopService;
    }
    @Override
    public void handle(Context ctx) throws Exception {
        if(ctx.getRequest().getMethod().isGet()){
            val username = ctx.getPathTokens().get("username");
            val res = shopService.getShopByUsername(username);

            ctx.render(json(res.get()));
        }
    }
}
