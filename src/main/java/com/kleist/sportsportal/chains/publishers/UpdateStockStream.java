package com.kleist.sportsportal.chains.publishers;

import com.google.inject.Inject;
import ratpack.exec.Promise;
import ratpack.exec.util.ParallelBatch;
import ratpack.handling.Context;
import ratpack.handling.Handler;
import ratpack.sse.ServerSentEvents;
import ratpack.stream.TransformablePublisher;

public class UpdateStockStream implements Handler {

    private int numberInStock;




    @Override
    public void handle(Context ctx) throws Exception {

        TransformablePublisher<Integer> stream = ParallelBatch.of(Promise.value(numberInStock)).publisher();
    ServerSentEvents serverSentEvents  =  ServerSentEvents.serverSentEvents(stream, s -> {

    });


        ctx.render(serverSentEvents);
    }
}
