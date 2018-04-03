package com.wulinpeng.bean.api.account;

import com.google.common.base.Strings;

/**
 * Created by wulinpeng on 18/2/6.
 * desc:
 */
public class RegisterModel {

    private String phone;
    private String password;
    private String name;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static boolean check(RegisterModel model) {
        return model != null
                && !Strings.isNullOrEmpty(model.getPhone())
                && !Strings.isNullOrEmpty(model.getPassword())
                && !Strings.isNullOrEmpty(model.getName());
    }
}
