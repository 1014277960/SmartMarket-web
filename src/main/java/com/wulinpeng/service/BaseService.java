package com.wulinpeng.service;

import com.wulinpeng.bean.db.User;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;

/**
 * Created by wulinpeng on 18/1/25.
 * desc:
 */
public class BaseService {

    // 添加一个上下文注解，该注解会给securityContext赋值，为拦截器中返回的上下文
    @Context
    protected SecurityContext securityContext;

    /**
     * 从上下文直接获取自己信息
     * @return
     */
    protected User getSelf() {
        if (securityContext == null) {
            return null;
        }
        return (User) securityContext.getUserPrincipal();
    }
}
