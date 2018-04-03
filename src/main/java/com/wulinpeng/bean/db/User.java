package com.wulinpeng.bean.db;

import org.hibernate.annotations.*;

import javax.persistence.CascadeType;
import javax.persistence.*;
import javax.persistence.Entity;
import java.security.Principal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by wulinpeng on 17/11/14.
 * desc: 用户的Model，对应数据库
 */
@Entity(name = "TB_USER")
public class User implements Principal {

    @Id
    @PrimaryKeyJoinColumn
    // 使用名称为uuid的generator
    @GeneratedValue(generator = "uuid")
    // 定义名称为uuid的generator，策略是uuid2，如果是assigned那就是手动输入的
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(updatable = false, nullable = false)
    private String id;

    @Column(nullable = false, length = 128, unique = true)
    private String name;

    @Column(nullable = false, length = 62, unique = true)
    private String phone;

    @Column(nullable = true)
    private String password;

    // 头像允许为空
    @Column(nullable = true)
    private String portrait;

    @Column(unique = true)
    private String token;

    // 对应的表字段为TB_USER_FOLLOW.targetId
    @JoinColumn(name = "userId")
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<ShoppingCart> shoppingCarts = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<ShoppingCart> getShoppingCarts() {
        return shoppingCarts;
    }

    public void setShoppingCarts(List<ShoppingCart> shoppingCarts) {
        this.shoppingCarts = shoppingCarts;
    }
}
