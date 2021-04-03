package com.kleist.sportsportal;

import com.kleist.sportsportal.chains.activity.ActivityChain;
import com.kleist.sportsportal.chains.club.ClubChain;
import com.kleist.sportsportal.chains.member.MemberChain;
import com.kleist.sportsportal.chains.owner.OwnerChain;
import com.kleist.sportsportal.chains.shop.ShopChain;
import com.kleist.sportsportal.config.BinderModule;
import com.kleist.sportsportal.handlers.member.CorsHandler;
import com.kleist.sportsportal.modules.Config;
import com.kleist.sportsportal.modules.ServiceCommonConfigModule;
import com.kleist.sportsportal.modules.SqlConfig;
import ratpack.dropwizard.metrics.DropwizardMetricsModule;
import ratpack.guice.Guice;
import ratpack.rx2.RxRatpack;
import ratpack.server.BaseDir;
import ratpack.server.RatpackServer;


public class StartSportsPortal {


    public static  void main(String...args) throws  Exception {
        RxRatpack.initialize();

        RatpackServer.start(ratpackServerSpec -> ratpackServerSpec.serverConfig(serverConfigBuilder ->
                serverConfigBuilder.baseDir(BaseDir.find()).yaml("ratpack.yaml")
                .require("/db", Config.class).require("/mysql", SqlConfig.class)
                .props("ratpack.properties").env().development(true).build()).registry(Guice.registry(bindingsSpec -> bindingsSpec.module(BinderModule.class).module(ServiceCommonConfigModule.class).module(DropwizardMetricsModule.class, e -> {
                    e.getGraphite();
                    e.console();
                    e.getJmx();
                    e.getSlf4j();
                    e.jmx();
                }))).handlers(chain -> {
            chain.all(CorsHandler.class).prefix("member", MemberChain.class).prefix("activity", ActivityChain.class).prefix("club", ClubChain.class).prefix("owner", OwnerChain.class).prefix("shop", ShopChain.class);

        }));

    }
    }
