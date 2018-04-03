package com.wulinpeng.service;

import com.wulinpeng.bean.api.base.ResponseModel;
import com.wulinpeng.bean.api.cart.AddGoodsToCartModel;
import com.wulinpeng.bean.api.cart.DeleteGoodsFromCartModel;
import com.wulinpeng.bean.api.goods.AddGoodsModel;
import com.wulinpeng.bean.card.ShoppingCartCard;
import com.wulinpeng.bean.db.Goods;
import com.wulinpeng.bean.db.ShoppingCart;
import com.wulinpeng.factory.CartFactory;
import com.wulinpeng.factory.GoodsFactory;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by wulinpeng on 18/2/12.
 * desc:
 */
@Path("/cart")
public class ShoppingCartService extends BaseService {

    /**
     * 加入购物车
     * @return
     */
    @PUT
    @Path("/addGoodsToCart")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseModel<List<ShoppingCartCard>> addCarts(AddGoodsToCartModel model) {

        if (!AddGoodsToCartModel.check(model)) {
            return ResponseModel.buildParameterError();
        }

        List<ShoppingCartCard> addGoods = CartFactory.addGoodsListToCart(getSelf(), model.getItems());
        return ResponseModel.buildOk(addGoods);
    }

    /**
     * 加入购物车
     * @return
     */
    @PUT
    @Path("/deleteGoodsFromCart")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseModel<List<ShoppingCartCard>> deleteCarts(DeleteGoodsFromCartModel model) {

        if (!DeleteGoodsFromCartModel.check(model)) {
            return ResponseModel.buildParameterError();
        }

        List<ShoppingCartCard> deleteGoods = CartFactory.deleteGoodsListFromCart(getSelf(), model.getItems());
        return ResponseModel.buildOk(deleteGoods);
    }

    /**
     * 获取购物车数据
     * @return
     */
    @GET
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseModel<List<ShoppingCartCard>> carts() {

        List<ShoppingCart> shoppingCarts =  getSelf().getShoppingCarts();
        List<ShoppingCartCard> shoppingCartCards = shoppingCarts
                .stream().map(ShoppingCartCard::new).collect(Collectors.toList());
        if (shoppingCarts != null) {
            return ResponseModel.buildOk(shoppingCartCards);
        } else {
            return ResponseModel.buildServiceError();
        }
    }
}
