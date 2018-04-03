package com.wulinpeng.bean.api.cart;

import java.util.List;

/**
 * Created by wulinpeng on 18/2/12.
 * desc:
 */
public class AddGoodsToCartModel {
    private List<Item> items;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public static boolean check(AddGoodsToCartModel model) {
        return model != null
                && model.getItems() != null
                && model.getItems().size() > 0;
    }
}
