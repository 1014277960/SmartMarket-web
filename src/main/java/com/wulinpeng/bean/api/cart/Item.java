package com.wulinpeng.bean.api.cart;

/**
 * Created by wulinpeng on 18/2/25.
 * desc:
 */
public class Item {

    private String goodsId;
    private int count;

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
