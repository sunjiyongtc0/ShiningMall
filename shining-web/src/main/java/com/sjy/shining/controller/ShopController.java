package com.sjy.shining.controller;


import com.sjy.shining.annotation.SysLog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShopController {

    @SysLog("会员管理页面")
    @RequestMapping(value = {"/", "shop/shopuser.html"})
    public String shopuser(){
        return "page/shop/shopuser";
    }

    @SysLog("会员优惠券页面")
    @RequestMapping(value = {"/", "shop/usercoupon.html"})
    public String usercoupon(){
        return "page/shop/usercoupon";
    }

    @SysLog("会员收藏页面")
    @RequestMapping(value = {"/", "shop/collect.html"})
    public String collect(){
        return "page/shop/collect";
    }

    @SysLog("会员足迹页面")
    @RequestMapping(value = {"/", "shop/footprint.html"})
    public String footprint(){
        return "page/shop/footprint";
    }

    @SysLog("搜索历史页面")
    @RequestMapping(value = {"/", "shop/searchhistory.html"})
    public String searchhistory(){
        return "page/shop/searchhistory";
    }

    @SysLog("购物车页面")
    @RequestMapping(value = {"/", "shop/cart.html"})
    public String cart(){
        return "page/shop/cart";
    }

    @SysLog("收货地址页面")
    @RequestMapping(value = {"/", "shop/address.html"})
    public String address(){
        return "page/shop/address";
    }

    @SysLog("商品属性页面")
    @RequestMapping(value = {"/", "shop/attributecategory.html"})
    public String attributecategory(){
        return "page/shop/attributecategory";
    }

    @SysLog("商品规格页面")
    @RequestMapping(value = {"/", "shop/specification.html"})
    public String specification(){
        return "page/shop/specification";
    }

    @SysLog("商品类型页面")
    @RequestMapping(value = {"/", "shop/category.html"})
    public String category(){
        return "page/shop/category";
    }

    @SysLog("商品制造商页面")
    @RequestMapping(value = {"/", "shop/brand.html"})
    public String brand(){
        return "page/shop/brand";
    }

    @SysLog("商品问答页面")
    @RequestMapping(value = {"/", "shop/goodsissue.html"})
    public String goodsissue(){
        return "page/shop/goodsissue";
    }

    @SysLog("反馈页面")
    @RequestMapping(value = {"/", "shop/feedback.html"})
    public String feedback(){
        return "page/shop/feedback";
    }

    @SysLog("关键词页面")
    @RequestMapping(value = {"/", "shop/keywords.html"})
    public String keywords(){
        return "page/shop/keywords";
    }

    @SysLog("所有商品页面")
    @RequestMapping(value = {"/", "shop/goods.html"})
    public String goods(){
        return "page/shop/goods";
    }

    @SysLog("商品规格页面")
    @RequestMapping(value = {"/", "shop/goodsspecification.html"})
    public String goodsspecification(){
        return "page/shop/goodsspecification";
    }


    @SysLog("商品设置页面")
    @RequestMapping(value = {"/", "shop/product.html"})
    public String product(){
        return "page/shop/product";
    }


    @SysLog("用户评论页面")
    @RequestMapping(value = {"/", "shop/comment.html"})
    public String comment(){
        return "page/shop/comment";
    }

    @SysLog("商品回收页面")
    @RequestMapping(value = {"/", "shop/goodshistory.html"})
    public String goodshistory(){
        return "page/shop/goodshistory";
    }

    @SysLog("订单页面")
    @RequestMapping(value = {"/", "shop/order.html"})
    public String order(){
        return "page/shop/order";
    }

    @SysLog("票据页面")
    @RequestMapping(value = {"/", "shop/orderPrint.html"})
    public String orderPrint(){
        return "page/shop/orderPrint";
    }

    @SysLog("广告位置页面")
    @RequestMapping(value = {"/", "shop/adposition.html"})
    public String adposition(){
        return "page/shop/adposition";
    }

    @SysLog("广告页面")
    @RequestMapping(value = {"/", "shop/ad.html"})
    public String ad(){ return "page/shop/ad";}

    @SysLog("优惠券页面")
    @RequestMapping(value = {"/", "shop/coupon.html"})
    public String coupon(){
        return "page/shop/coupon";
    }
}
