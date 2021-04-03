package com.kleist.sportsportal.handlers.shop;

import com.google.inject.Inject;
import com.kleist.sportsportal.entites.ShopItem;
import com.kleist.sportsportal.services.ShopService;
import lombok.val;
import ratpack.handling.Context;
import ratpack.handling.Handler;
import ratpack.jackson.Jackson;

import static ratpack.jackson.Jackson.json;

public class ItemToShopHandler implements Handler {

    private ShopService shopService;

    @Inject
    public  ItemToShopHandler(ShopService shopService){
        this.shopService = shopService;
    }

    @Override
    public void handle(Context ctx) throws Exception {
        ctx.parse(Jackson.fromJson(ShopItem.class)).then(shopItem -> {
            val shopId = ctx.getPathTokens().get("shopId");
           val re = shopService.addItemToShop(Long.parseLong(shopId), shopItem);
           ctx.render(json(re.get()));
        });
    }
}
