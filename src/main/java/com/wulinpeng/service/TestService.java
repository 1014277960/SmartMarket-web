package com.wulinpeng.service;

import com.wulinpeng.bean.api.account.AccountRspModel;
import com.wulinpeng.bean.api.account.LoginModel;
import com.wulinpeng.bean.api.base.ResponseModel;
import com.wulinpeng.bean.db.User;
import com.wulinpeng.factory.UserFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by wulinpeng on 18/3/1.
 * desc:
 */
@Path("/test")
public class TestService {

    /**
     * 登陆
     * @return
     */
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public TestBean get() {
        return new TestBean("wu", 23);
    }
}
