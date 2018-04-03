package com.wulinpeng.bean.card;

import com.wulinpeng.bean.db.Goods;
import com.wulinpeng.bean.db.ShoppingCart;

/**
 * Created by wulinpeng on 18/2/17.
 * desc:
 */
public class ShoppingCartCard {

    public ShoppingCartCard(String id, int count, Goods goods) {
        this.id = id;
        this.count = count;
        this.goods = goods;
    }

    public ShoppingCartCard(ShoppingCart cart) {
        this.id = cart.getId();
        this.count = cart.getCount();
        this.goods = cart.getGoods();
    }

    private String id;
    private int count;
    private Goods goods;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }
}
