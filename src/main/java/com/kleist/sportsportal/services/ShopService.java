package com.kleist.sportsportal.services;

import com.google.inject.Inject;
import com.kleist.sportsportal.entites.Shop;
import com.kleist.sportsportal.entites.ShopItem;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.neo4j.ogm.session.Session;

import java.io.File;
import java.util.HashMap;
import java.util.Optional;

@Slf4j
public class ShopService implements  IShopService{

    private Session session;

    @Inject
    public  ShopService(Session session)
    {    this.session = session;

    }

    @Override
    public Optional<Iterable<Shop>> getShopByUsername(String username) throws Exception {
            try {
                val map = new HashMap<String , Object>();
                map.put("username", username);
                return  Optional.of(session.query(Shop.class ,"match (s:Shop)-[sr:SHOP_BElONGS_TO_MEMBER]-(m:Member {username: $username }) return s,sr,m", map));
            }catch (Exception ex){
                throw  new Exception(ex.getMessage(), ex.getCause());
            }
    }

    @Override
    public Optional<Shop> addItemToShop(Long shopId, ShopItem shopItem) throws Exception {
        try {
            val shop = session.load(Shop.class, shopId);


            shopItem.addShop(shop);

            session.save(shopItem);
            return  Optional.of(shop);

        }catch (Exception e){
            throw new Exception(e.getMessage(), e.getCause());
        }
    }

    @Override
    public Optional<Iterable<ShopItem>> getShopItems(String name) throws Exception {
        try {
val map = new HashMap<String, Object>();
map.put("name", name);

      return Optional.of(session.query(ShopItem.class,"match (s:Shop  {name:$name })-[sr:BELONGS_TO_SHOP]-(i:ShopItem) return s, sr, i", map));
        }catch (Exception ex) {
            throw  new Exception(ex.getMessage(), ex.getCause());
        }
    }

    @Override
    public Optional<ShopItem> getItemByMember(long menberId, Long itemname) throws Exception {
       try {
           val map = new HashMap<String , Object>();
           map.put("memberId", menberId);
           map.put("itemname", itemname);
         return Optional.of(session.queryForObject(ShopItem.class , "match (s:Shop)-[sr:SHOP_BElONGS_TO_MEMBER]-(m:Member {username:'test1', password:'test'}) return s,sr,m   ",map));
    } catch (Exception ex){
           throw  new Exception(ex.getMessage(), ex.getCause());
       }
    }

    @Override
    public Optional<ShopItem> getItemByClub(long clubId, Long itemId) throws Exception {
        return Optional.empty();
    }

    @Override
    public Optional<ShopItem> updateItem(long item, ShopItem shopItem) throws Exception {
        return Optional.empty();
    }

    @Override
    public Optional<ShopItem> updateHowIsLooking(long item) throws Exception {
        return Optional.empty();
    }

    @Override
    public Optional<Shop> updateStock(long item, int stocitem) throws Exception {
        return Optional.empty();
    }
}
