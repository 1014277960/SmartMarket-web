package com.wulinpeng.factory;

import com.wulinpeng.bean.db.User;
import com.wulinpeng.utils.Hib;
import com.wulinpeng.utils.TextUtil;
import org.hibernate.Session;

import java.util.UUID;

/**
 * Created by wulinpeng on 18/2/5.
 * desc:
 */
public class UserFactory {

    public static User findByToken(String token) {
        return Hib.query(session -> (User) session
                .createQuery("from com.wulinpeng.bean.db.User where token=:token")
                .setParameter("token", token)
                .uniqueResult());
    }

    public static User findById(String id) {
        return Hib.query(session -> (User) session
                .createQuery("from com.wulinpeng.bean.db.User where id=:id")
                .setParameter("id", id)
                .uniqueResult());
    }

    public static User findByPhone(String phone) {
        return Hib.query(session -> (User) session
                .createQuery("from com.wulinpeng.bean.db.User where phone=:phone")
                .setParameter("phone", phone)
                .uniqueResult());
    }

    public static User login(String phone, String password) {
        final String pass = encodePassword(password);
        User user = Hib.query(session -> (User) session
                .createQuery("from com.wulinpeng.bean.db.User where phone=:phone and password=:password")
                .setParameter("phone", phone)
                .setParameter("password", pass)
                .uniqueResult()
        );
        if (user != null) {
            login(user);
        }
        return user;
    }

    public static User update(User user) {
        return Hib.query(session -> {
            session.saveOrUpdate(user);
            return user;
        });
    }

    /**
     * 登录操作，实则为更新token
     * @param user
     */
    private static void login(User user) {
        String token = UUID.randomUUID().toString();
        token = TextUtil.encodeBase64(token);
        user.setToken(token);
        Hib.queryOnly(session -> {
            session.saveOrUpdate(user);
        });
    }

    public static User register(String phone, String password, String name) {
        final String pass = encodePassword(password);
        User user = createUser(phone, pass, name);
        if (user != null) {
            login(user);
        }
        return user;
    }

    private static User createUser(String phone, String password, String name) {
        User user = new User();
        user.setPhone(phone);
        user.setName(name);
        user.setPassword(password);

        return update(user);
    }

    private static String encodePassword(String password) {
        password = password.trim();
        password = TextUtil.getMD5(password);
        return TextUtil.encodeBase64(password);
    }
}
