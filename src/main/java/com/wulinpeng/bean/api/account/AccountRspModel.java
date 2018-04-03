package com.wulinpeng.bean.api.account;

import com.wulinpeng.bean.card.UserCard;
import com.wulinpeng.bean.db.User;

/**
 * Created by wulinpeng on 18/2/5.
 * desc:
 */
public class AccountRspModel {

    public AccountRspModel(User user) {
        this.userCard = new UserCard(user);
        this.token = user.getToken();
    }

    private UserCard userCard;

    // account返回的是登陆／注册的api，需要返回token
    private String token;

    public UserCard getUserCard() {
        return userCard;
    }

    public void setUserCard(UserCard userCard) {
        this.userCard = userCard;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
