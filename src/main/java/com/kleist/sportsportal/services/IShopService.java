package com.kleist.sportsportal.services;

import com.kleist.sportsportal.entites.Shop;
import com.kleist.sportsportal.entites.ShopItem;

import java.util.Optional;

public interface IShopService {

    Optional<ShopItem> getItemByMember(long menberId, Long itemname) throws  Exception;
    Optional<ShopItem> getItemByClub(long clubId, Long itemId) throws  Exception;
    Optional<ShopItem> updateItem(long item, ShopItem shopItem) throws  Exception;
    Optional<ShopItem> updateHowIsLooking(long item) throws  Exception;
    Optional<Shop> updateStock(long item, int stocitem) throws  Exception;
    Optional<Iterable<Shop>> getShopByUsername(String username) throws  Exception;
    Optional<Shop> addItemToShop(Long shopId, ShopItem shopItem) throws  Exception;
    Optional<Iterable<ShopItem>> getShopItems(String name) throws  Exception;

}
