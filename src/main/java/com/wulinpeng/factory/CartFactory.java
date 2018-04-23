package com.wulinpeng.factory;

import com.wulinpeng.bean.api.cart.AddGoodsToCartModel;
import com.wulinpeng.bean.api.cart.DeleteGoodsFromCartModel;
import com.wulinpeng.bean.api.cart.Item;
import com.wulinpeng.bean.card.ShoppingCartCard;
import com.wulinpeng.bean.db.Goods;
import com.wulinpeng.bean.db.ShoppingCart;
import com.wulinpeng.bean.db.User;
import com.wulinpeng.utils.Hib;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wulinpeng on 18/2/12.
 * desc:
 */
public class CartFactory {

    /**
     * todo 返回List<GoodsCard>
     * @param user
     * @param itemList
     * @return 添加成功的Goods
     */
    public static List<ShoppingCartCard> addGoodsListToCart(User user, List<Item> itemList) {
        List<ShoppingCartCard> carts = new ArrayList<>();

        for (Item item : itemList) {
            ShoppingCartCard cart = addGoodsToCart(user, item);
            if (cart != null) {
                carts.add(cart);
            }
        }
        return carts;
    }

    private static ShoppingCartCard addGoodsToCart(User user, Item item) {

        Goods goods = GoodsFactory.findByCode(item.getGoodsId());
        if (goods == null) {
            return null;
        }

        ShoppingCart cart = queryCart(user.getId(), item.getGoodsId());

        if (cart == null) {
            ShoppingCart c = new ShoppingCart();
            c.setUser(user);
            c.setGoods(goods);
            c.setCount(item.getCount());
            Hib.queryOnly(session -> session.saveOrUpdate(c));
            return new ShoppingCartCard(c);
        } else {
            // todo 库存数量检测
            cart.setCount(item.getCount());
            Hib.queryOnly(session -> session.saveOrUpdate(cart));
            return new ShoppingCartCard(cart);
        }
    }

    public static List<ShoppingCartCard> deleteGoodsListFromCart(User self, List<Item> items) {
        List<ShoppingCartCard> carts = new ArrayList<>();

        for (Item item : items) {
            ShoppingCartCard cart = deleteFromCart(self, item);
            if (cart != null) {
                carts.add(cart);
            }
        }
        return carts;
    }

    private static ShoppingCartCard deleteFromCart(User self, Item item) {
        ShoppingCart cart = queryCart(self.getId(), item.getGoodsId());
        if (cart == null) {
            return null;
        }
        Hib.queryOnly(session -> {
            session.delete(cart);
        });
        return new ShoppingCartCard(cart);
    }

    private static ShoppingCart queryCart(String id, String goodsId) {
        return Hib.query(session -> (ShoppingCart) session
                .createQuery("from com.wulinpeng.bean.db.ShoppingCart where userId=:userId and goodsId=:goodsId")
                .setParameter("userId", id)
                .setParameter("goodsId", goodsId)
                .uniqueResult());
    }

}
