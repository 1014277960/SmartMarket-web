package com.wulinpeng.service;

import com.google.common.base.Strings;
import com.wulinpeng.bean.api.base.ResponseModel;
import com.wulinpeng.bean.api.goods.AddGoodsModel;
import com.wulinpeng.bean.db.Goods;
import com.wulinpeng.factory.GoodsFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by wulinpeng on 18/2/7.
 * desc:
 */
@Path("/goods")
public class GoodsService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseModel<List<Goods>> getAllGoods() {

        List<Goods> goodsList = GoodsFactory.getAllGoods();
        if (goodsList != null && goodsList.size() > 0) {
            return ResponseModel.buildOk(goodsList);
        } else {
            return ResponseModel.buildGoodsNotFoundError();
        }
    }

    /**
     * 根据id搜索商品
     * @return
     */
    @GET
    @Path("/code/{code}")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseModel<Goods> searchGoodsByCode(@PathParam("code") String code) {
        if (Strings.isNullOrEmpty(code)) {
            return ResponseModel.buildParameterError();
        }
        Goods goods = GoodsFactory.findByCode(code);
        if (goods != null) {
            return ResponseModel.buildOk(goods);
        } else {
            return ResponseModel.buildGoodsNotFoundError();
        }
    }

    /**
     * 根据barcode搜索商品
     * @return
     */
    @GET
    @Path("/barcode/{barcode}")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseModel<Goods> searchGoodsByBarcode(@PathParam("barcode") String barcode) {
        if (Strings.isNullOrEmpty(barcode)) {
            return ResponseModel.buildParameterError();
        }
        Goods goods = GoodsFactory.findByBarcode(barcode);
        if (goods != null) {
            return ResponseModel.buildOk(goods);
        } else {
            return ResponseModel.buildGoodsNotFoundError();
        }
    }

    /**
     * 根据barcode搜索商品
     * @return
     */
    @PUT
    @Path("/addGoods")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseModel<Goods> addGoods(AddGoodsModel model) {
        if (!AddGoodsModel.check(model)) {
            return ResponseModel.buildParameterError();
        }

        Goods goods = GoodsFactory.findByName(model.getName());
        if (goods != null) {
            // 修改count
            goods.setCount(goods.getCount() + model.getCount());
            // 更新当前价格
            goods.setPrice(model.getPrice());
            goods.setDescription(model.getDesc());
        } else {
            goods = new Goods();
            goods.setId(model.getCode());
            goods.setName(model.getName());
            goods.setPicture(model.getPicture());
            goods.setDescription(model.getDesc());
            goods.setPrice(model.getPrice());
            goods.setCount(model.getCount());
            goods.setBarcode(model.getBarcode());
        }
        return ResponseModel.buildOk(GoodsFactory.addGoods(goods));
    }
}
