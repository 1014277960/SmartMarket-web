package com.wulinpeng.bean.db;

import com.google.common.base.Strings;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.security.Principal;

/**
 * Created by wulinpeng on 18/2/7.
 * desc:
 */
@Entity(name = "TB_GOODS")
public class Goods implements Principal {

    // 商品编码
    @Id
    @PrimaryKeyJoinColumn
    @Column(nullable = false, updatable = false)
    private String id;

    @Column(updatable = false, nullable = true, unique = true)
    private String barcode;

    @Column
    private String picture;

    @Column(updatable = false, nullable = false, length = 128, unique = true)
    private String name;

    @Column(nullable = true)
    private String description;

    @Column(nullable = true)
    private int price;

    @Column
    private int count;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String desc) {
        this.description = desc;
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

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public static boolean check(Goods goods) {
        return !Strings.isNullOrEmpty(goods.getId())
                && !Strings.isNullOrEmpty(goods.getName());
    }
}
