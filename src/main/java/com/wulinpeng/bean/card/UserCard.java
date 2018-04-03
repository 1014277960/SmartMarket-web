package com.wulinpeng.bean.card;

import com.wulinpeng.bean.db.User;

/**
 * Created by wulinpeng on 18/2/5.
 * desc:
 */
public class UserCard {

    public UserCard(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.phone = user.getPhone();
        this.portrait = user.getPortrait();
    }

    private String id;

    private String name;

    private String phone;

    private String portrait;

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

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }
}
