package com.kleist.sportsportal.handlers.member;

import io.reactivex.BackpressureStrategy;
import ratpack.handling.Context;
import ratpack.handling.Handler;
import ratpack.rx2.RxRatpack;
import ratpack.stream.Streams;

import java.net.ServerSocket;

public class UserVideoStream implements Handler {
    @Override
    public void handle(Context context) throws Exception {

        RxRatpack.publisher(observableEmitter -> {



        }, BackpressureStrategy.BUFFER);

    }
}
