package com.wulinpeng.factory;

import com.google.common.base.Strings;
import com.wulinpeng.bean.db.Goods;
import com.wulinpeng.bean.db.User;
import com.wulinpeng.utils.Hib;

import java.util.List;

/**
 * Created by wulinpeng on 18/2/7.
 * desc:
 */
public class GoodsFactory {

    public static Goods findByCode(String code) {
        return Hib.query(session -> (Goods) session
                .createQuery("from com.wulinpeng.bean.db.Goods where id=:code")
                .setParameter("code", code)
                .uniqueResult());
    }

    public static Goods findByBarcode(String barcode) {
        return Hib.query(session -> (Goods) session
                .createQuery("from com.wulinpeng.bean.db.Goods where barcode=:barcode")
                .setParameter("barcode", barcode)
                .uniqueResult());
    }

    public static Goods findByName(String name) {
        return Hib.query(session -> (Goods) session
                .createQuery("from com.wulinpeng.bean.db.Goods where name=:name")
                .setParameter("name", name)
                .uniqueResult());
    }

    public static List<Goods> searchGoods(String name) {
        if (Strings.isNullOrEmpty(name)) {
            name = "";
        }
        String searchName = "%" + name + "%"; // 匹配模糊
        return Hib.query(session -> {
            return (List<Goods>) session.createQuery("from com.wulinpeng.bean.db.Goods where lower(name) like :name")
                    .setParameter("name", searchName)
                    .setMaxResults(20)
                    .list();
        });
    }

    public static Goods addGoods(Goods goods) {
        return Hib.query(session -> {
            session.saveOrUpdate(goods);
            return goods;
        });
    }

    public static List<Goods> getAllGoods() {
        return Hib.query(session -> {
            return session.createQuery("from com.wulinpeng.bean.db.Goods")
                    .list();
        });
    }
}
