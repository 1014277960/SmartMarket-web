package com.wulinpeng.bean.api.account;

import com.google.common.base.Strings;

/**
 * Created by wulinpeng on 18/2/6.
 * desc:
 */
public class UpdateInfoModel {

    private String portrait;

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public static boolean check(UpdateInfoModel model) {
        return model != null && !Strings.isNullOrEmpty(model.getPortrait());
    }
}
