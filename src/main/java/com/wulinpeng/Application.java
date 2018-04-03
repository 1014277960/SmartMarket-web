package com.wulinpeng;

import com.wulinpeng.provider.AuthRequestFilter;
import com.wulinpeng.provider.GsonProvider;
import org.glassfish.jersey.server.ResourceConfig;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by wulinpeng on 18/2/5.
 * desc:
 */
public class Application extends ResourceConfig {

    private final static Logger ORG_GLASSFISH_JERSEY_LOGGER = Logger
            .getLogger("org.glassfish.jersey");
    static {
        ORG_GLASSFISH_JERSEY_LOGGER.setLevel(Level.OFF);
    }

    public Application() {
        // 配置包含接口入口类的所有包名
        packages("com.wulinpeng.service");
        // 注册Json解析器，GET/POST返回实体类自动转换Json
        register(GsonProvider.class);
        // 注册全局拦截器
        register(AuthRequestFilter.class);
        // 注册日志打印
        register(Logger.class);
    }
}
