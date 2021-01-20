package com.phan.market.controllers;

import com.phan.market.config.DBconfig;
import com.phan.market.entity.ExpiryDate;
import com.phan.market.entity.ImportCoupon;
import com.phan.market.entity.Item;
import com.phan.market.entity.Shipment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ApiController  {

    @RequestMapping(value={"/admin/coupons/api/coupon1","/admin/api/coupon1"}, produces = "text/plain;charset=UTF-8",method = RequestMethod.GET)
    @ResponseBody
    public String selectCoupon(@RequestParam String txtNameSearch){
        String html ="";
        List<ImportCoupon> importCoupons=DBconfig.connectImportCouponDao().selectCouponBySearch(txtNameSearch);
        if(importCoupons.size()>0){
            html+="<i style='#1e7e34' class=\"fas fa-check\"></i>";
        }else{
            html+="<i  style='#bd4147' class=\"fas fa-times\"></i>";
        }

        return html;
    }

    @RequestMapping(value={"/admin/coupons/api/shipment","/admin/api/shipment"}, produces = "text/plain;charset=UTF-8",method = RequestMethod.GET)
    @ResponseBody
    public String selectId(@RequestParam String txtIdSearch){
        String html ="";
        List<ExpiryDate> expiryDateList=DBconfig.connectExpiryDateDao().selectIteamBySearch(txtIdSearch);
        if(expiryDateList.size()>0 ){
            html+="<i style='#1e7e34' class=\"fas fa-check\"></i>";

        }else{
            html+="<i  style='#bd4147' class=\"fas fa-times\"></i>";
        }
        return html;
    }
//    @RequestMapping(value="/admin/coupons/supplier/shipment", produces = "text/plain;charset=UTF-8",method = RequestMethod.GET)
//    @ResponseBody
//    public String addShipment(@RequestParam String txtMaLo,@RequestParam String txtHsd,@RequestParam float txtGiaBan,@RequestParam String txtMatHang){
//        String html="";
//        Shipment shipment = new Shipment(txtMaLo,txtHsd,txtGiaBan,txtMatHang);
//        return html;
//    }

    @RequestMapping(value="/admin/api/item", produces = "text/plain;charset=UTF-8",method = RequestMethod.GET)
    @ResponseBody
    public String searchByItemName(@RequestParam String txtName){
        String html="";
        html = html+"<table><tr>" +
                "<th>Tên</th>\n" +
                "                                <th>Đơn vị</th>\n" +
                "                                <th>Sửa</th>\n" +
                "                                <th>Xóa</th>\n" +
                "                                <th>Chi tiết</th>"+
                "</tr>";
        List<Item> items = DBconfig.connectItemDao().selectItemBySearch(txtName);
        if(items.size()>0){
            for(Item imp:items){
                html = html+"<tr>" +
                        "<td>"+imp.getName()+"</td>" +
                        "<td>"+imp.getUnit()+"</td>" +
                        " <td><a style=\"color: #403866\" href=\"/admin/items/update?id=${i.getId()}\"><i class=\"fas fa-pen-alt\" onclick=\"swipResult3()\"> </i></a></td>\n" +
                        "                                    <td><a style=\"color: #bd4147\"href=\"/admin/items/delete?id=${i.getId()}\"><i class=\"fas fa-trash-alt\"></i></a></td>\n" +
                        "                                    <td><a style=\"color: #1e7e34\"href=\"#\"><i class=\"fas fa-arrow-right\"></i></a></td>"+
                        "</tr>";
            }
            html = html + "</table>";
        }else{
            html = html + "<i style='margin-left:5px'>Không có dữ liệu. Bạn phải thêm mới mặt hàng</i>";
        }
        return html;
    }





//    @RequestMapping(value="/admin/shipment/api/item", produces = "text/plain;charset=UTF-8",method = RequestMethod.GET)
//    @ResponseBody
//    public String checkItem(@RequestParam String txtMaMH){
//        String html="";
//        List<ExpiryDate> listItems = DBconfig.connectItemDao().selectItemBySearch(txtMaMH);
//        if(listItems.size()>0){
//            for(ExpiryDate imp:listItems){
//                html = html+"<table><tr>" +
//                        "<th>Tên mặt hàng</th>" +
//                        "<th>Đơn vị</th>" +
//                        "</tr>";
//                html = html+"<tr>" +
//                        "<td>"+imp.getNameItem()+"</td>" +
//                        "<td>"+imp.getUnit()+"</td>" +
//                        "</tr>";
//            }
//            html = html + "</table>";
//        }else{
//            html = html + "<i style='margin-left:5px'>Không có dữ liệu. Bạn phải thêm mới mặt hàng</i>";
//            html = html + "<a href='/admin/supplier' style='padding: 5px 15px;text-decoration:none;color: #fff;background:#827FFE'>Thêm mới</a>";
//        }
//        return html;
//    }
}
