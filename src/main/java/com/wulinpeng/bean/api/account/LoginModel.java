package com.wulinpeng.bean.api.account;

import com.google.common.base.Strings;

/**
 * Created by wulinpeng on 18/1/24.
 * desc:
 */
public class LoginModel {

    private String phone;
    private String password;

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

    /**
     * 校验合法性
     * @param model
     * @return
     */
    public static boolean check(LoginModel model) {
        return model != null
                && !Strings.isNullOrEmpty(model.getPhone())
                && !Strings.isNullOrEmpty(model.getPassword());
    }
}
