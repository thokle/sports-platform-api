package com.kleist.sportsportal.config;

import com.google.inject.AbstractModule;
import com.kleist.sportsportal.chains.activity.ActivityChain;
import com.kleist.sportsportal.chains.club.ClubChain;
import com.kleist.sportsportal.chains.member.MemberChain;

import com.kleist.sportsportal.chains.owner.OwnerChain;
import com.kleist.sportsportal.chains.publishers.UpdateStockStream;
import com.kleist.sportsportal.chains.shop.ShopChain;
import com.kleist.sportsportal.chains.shop.UpdateStockHandler;
import com.kleist.sportsportal.handlers.activity.AddMemberToActivityHandler;
import com.kleist.sportsportal.handlers.activity.CreateActivityHandler;
import com.kleist.sportsportal.handlers.activity.HandlerCvrActivity;
import com.kleist.sportsportal.handlers.activity.HasPaidHandler;
import com.kleist.sportsportal.handlers.club.HandlerAddMemberToClub;
import com.kleist.sportsportal.handlers.club.HandlerGetActivities;
import com.kleist.sportsportal.handlers.club.HandlerGetAllClubs;
import com.kleist.sportsportal.handlers.club.HandlerGetClubMembers;
import com.kleist.sportsportal.handlers.coach.HandlerAddActivity;
import com.kleist.sportsportal.handlers.owner.HandlerGetClubs;
import com.kleist.sportsportal.handlers.member.*;
import com.kleist.sportsportal.handlers.owner.HandlerAddClub;
import com.kleist.sportsportal.handlers.owner.HandlerCreateOwner;
import com.kleist.sportsportal.handlers.owner.HandlerLoginOwner;
import com.kleist.sportsportal.handlers.shop.GetShopItemsHandler;
import com.kleist.sportsportal.handlers.shop.ItemToShopHandler;
import com.kleist.sportsportal.handlers.shop.ShopHandlerByUserName;
import com.kleist.sportsportal.services.*;


public class BinderModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(com.kleist.sportsportal.handlers.member.Get.class).asEagerSingleton();
        bind(GetByIdHandler.class).asEagerSingleton();
        bind(IMemberService.class).to(MemberService.class).asEagerSingleton();
        bind(LoginHandler.class).asEagerSingleton();
        bind(MemberChain.class).asEagerSingleton();
        bind(ActivityChain.class).asEagerSingleton();
        bind(ClubChain.class).asEagerSingleton();
        bind(HandlerAddChild.class).asEagerSingleton();
        bind(com.kleist.sportsportal.handlers.member.Post.class).asEagerSingleton();
        bind(CorsHandler.class).asEagerSingleton();
        bind(GetShopItemsHandler.class).asEagerSingleton();
        bind(HandlerGetClubMembers.class).asEagerSingleton();
        //activites
        bind(com.kleist.sportsportal.handlers.club.HandlerAddOwnertoClub.class).asEagerSingleton();
        bind(com.kleist.sportsportal.handlers.club.HandlerCreateClub.class).asEagerSingleton();
        bind(AddMemberToActivityHandler.class).asEagerSingleton();
        bind(CreateActivityHandler.class).asEagerSingleton();
        bind(ActivityService.class).asEagerSingleton();
        bind(ISecutityService.class).to(SecutityService.class).asEagerSingleton();
        bind(IOwnerService.class).to(OwnerService.class).asEagerSingleton();
        bind(OwnerChain.class).asEagerSingleton();
        bind(ICopyFileService.class).to(CopyFIleService.class).asEagerSingleton();
        bind(HandlerCreateOwner.class).asEagerSingleton();
        bind(HandlerAddClub.class).asEagerSingleton();
        bind(HandlerLoginOwner.class).asEagerSingleton();
        bind(HandlerAddAdressMember.class).asEagerSingleton();
        bind(HandlerAddPayment.class).asEagerSingleton();
        bind(HandlerGetClubs.class).asEagerSingleton();
        bind(HandlerAddActivity.class).asEagerSingleton();
        bind(com.kleist.sportsportal.handlers.club.HandlerAddActivity.class).asEagerSingleton();
        bind(HandlerAddMemberToClub.class).asEagerSingleton();
        bind(HandlerGetActivities.class).asEagerSingleton();
        bind(HandlerGetAllClubs.class).asEagerSingleton();
        bind(HasPaidHandler.class).asEagerSingleton();
        bind(HasPaidUpdateHandler.class).asEagerSingleton();
        bind(HandlerCvrActivity.class).asEagerSingleton();
        bind(HandlerAddCreditCard.class).asEagerSingleton();
        bind(HandlerGetMemberCreditCards.class).asEagerSingleton();
        bind(HandlerAddShopToMember.class).asEagerSingleton();
        bind(UserVideoStream.class).asEagerSingleton();
        bind(ShopHandlerByUserName.class).asEagerSingleton();
        bind(ShopChain.class).asEagerSingleton();
        bind(ItemToShopHandler.class).asEagerSingleton();
        bind(UpdateStockStream.class).asEagerSingleton();
        bind(UpdateStockHandler.class).asEagerSingleton();
    }
}
