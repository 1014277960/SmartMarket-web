package com.wulinpeng.service;

import com.wulinpeng.bean.api.account.AccountRspModel;
import com.wulinpeng.bean.api.account.LoginModel;
import com.wulinpeng.bean.api.account.RegisterModel;
import com.wulinpeng.bean.api.base.ResponseModel;
import com.wulinpeng.bean.api.account.UpdateInfoModel;
import com.wulinpeng.bean.card.UserCard;
import com.wulinpeng.bean.db.User;
import com.wulinpeng.factory.UserFactory;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by wulinpeng on 18/2/5.
 * desc:
 */

@Path("/account")
public class AccountService extends BaseService {

    /**
     * 登陆
     * @return
     */
    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseModel<AccountRspModel> login(LoginModel model) {

        if (!LoginModel.check(model)) {
            return ResponseModel.buildParameterError();
        }

        User user = UserFactory.login(model.getPhone(), model.getPassword());
        if (user != null) {
            return ResponseModel.buildOk(new AccountRspModel(user));
        } else {
            return ResponseModel.buildLoginError();
        }
    }

    /**
     * 注册
     * @return
     */
    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseModel<AccountRspModel> register(RegisterModel model) {

        if (!RegisterModel.check(model)) {
            return ResponseModel.buildParameterError();
        }

        User user = UserFactory.findByPhone(model.getPhone());
        if (user != null) {
            return ResponseModel.buildHaveAccountError();
        }

        user = UserFactory.register(model.getPhone(), model.getPassword(), model.getName());
        if (user != null) {
            return ResponseModel.buildOk(new AccountRspModel(user));
        } else {
            return ResponseModel.buildLoginError();
        }
    }

    /**
     * 注册
     * @return
     */
    @POST
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseModel<AccountRspModel> updateInfo(UpdateInfoModel model) {

        if (!UpdateInfoModel.check(model)) {
            return ResponseModel.buildParameterError();
        }

        User user = getSelf();
        user.setPortrait(model.getPortrait());
        user = UserFactory.update(user);
        if (user != null) {
            return ResponseModel.buildOk(new AccountRspModel(user));
        } else {
            return ResponseModel.buildLoginError();
        }
    }
}
