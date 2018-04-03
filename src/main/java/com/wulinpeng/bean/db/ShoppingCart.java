package com.wulinpeng.bean.db;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.security.Principal;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by wulinpeng on 18/2/12.
 * desc: 用户购物车记录，一条记录对应一个用户和一个商品
 */
@Entity(name = "TB_SHOPPING_CART")
public class ShoppingCart {

    @Id
    @PrimaryKeyJoinColumn
    // 使用名称为uuid的generator
    @GeneratedValue(generator = "uuid")
    // 定义名称为uuid的generator，策略是uuid2，如果是assigned那就是手动输入的
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(updatable = false, nullable = false)
    private String id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "userId")
    private User user;
    // 为了简化操作，因为在hibernate创建数据库的时候会创建senderId字段，这里主要用来接受，以便在java代码中直接使用，不然数据库中有，但是java中没有
    // 要从User拿到，非常麻烦
    // 定义为不能自己插入修改，就是为了让数据库自己插入
    @Column(updatable = false, insertable = false)
    private String userId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "goodsId")
    private Goods goods;
    // 为了简化操作，因为在hibernate创建数据库的时候会创建senderId字段，这里主要用来接受，以便在java代码中直接使用，不然数据库中有，但是java中没有
    // 要从User拿到，非常麻烦
    // 定义为不能自己插入修改，就是为了让数据库自己插入
    @Column(updatable = false, insertable = false)
    private String goodsId;

    @Column
    private int count;

    public void addCount(int count) {
        this.count += count;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

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
