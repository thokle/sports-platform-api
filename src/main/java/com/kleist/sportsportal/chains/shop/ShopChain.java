package com.kleist.sportsportal.chains.shop;

import com.kleist.sportsportal.handlers.shop.GetShopItemsHandler;
import com.kleist.sportsportal.handlers.shop.ItemToShopHandler;
import com.kleist.sportsportal.handlers.shop.ShopHandlerByUserName;
import ratpack.func.Action;
import ratpack.handling.Chain;

public class ShopChain implements Action<Chain> {
    @Override
    public void execute(Chain chain) throws Exception {
        chain.get("byusername/:username", ShopHandlerByUserName.class)
                .post("additem/:shopId", ItemToShopHandler.class)
                .get("shopItems/:name", GetShopItemsHandler.class).get("updatestock/:item", UpdateStockHandler.class);
    }
}
