package com.wulinpeng.bean.api.goods;

import com.google.common.base.Strings;

/**
 * Created by wulinpeng on 18/2/7.
 * desc:
 */
public class AddGoodsModel {

    private String code;

    private String name;

    private String picture;

    private String desc;

    private String barcode;

    private int price;

    private int count;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public static boolean check(AddGoodsModel model) {
        return model != null && !Strings.isNullOrEmpty(model.getName())
                && !Strings.isNullOrEmpty(model.getCode());
    }
}
