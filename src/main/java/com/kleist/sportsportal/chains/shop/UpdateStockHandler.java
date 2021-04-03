package com.kleist.sportsportal.chains.shop;

import com.kleist.sportsportal.chains.publishers.UpdateStockStream;
import ratpack.handling.Context;
import ratpack.handling.Handler;
import ratpack.registry.Registry;

public class UpdateStockHandler implements Handler {
    UpdateStockStream updateStockStream = new UpdateStockStream();
    @Override
    public void handle(Context ctx) throws Exception {
        ctx.insert(updateStockStream);
    }
}
