package com.kleist.sportsportal.handlers.shop;

import com.google.inject.Inject;
import com.kleist.sportsportal.services.ShopService;
import lombok.val;
import ratpack.handling.Context;
import ratpack.handling.Handler;

import static ratpack.jackson.Jackson.json;

public class GetShopItemsHandler implements Handler {

    private ShopService shopService;

    @Inject
    public GetShopItemsHandler(ShopService shopService) {
        this.shopService = shopService;
    }

    @Override
    public void handle(Context ctx) throws Exception {
    if(ctx.getRequest().getMethod().isGet()){
        val name = ctx.getPathTokens().get("name");
        val res = this.shopService.getShopItems(name);
        ctx.render(json(res.get()));
    }
    }
}
