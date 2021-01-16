package com.phan.market.controllers;

import com.phan.market.config.DBconfig;
import com.phan.market.dao.EmployeeDao;
import com.phan.market.entity.Employee;
import com.phan.market.entity.ImportCoupon;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ApiController  {

    @RequestMapping(value="/admin/api/coupon1",method = RequestMethod.GET)
    @ResponseBody
    public String addPageAccount(@RequestParam String txtNameSearch){
        String html ="<%@ page contentType=\"text/html;charset=UTF-8\" language=\"java\" %>";
        List<ImportCoupon> importCoupons=DBconfig.connectImportCouponDao().selectCouponBySearch(txtNameSearch);
        if(importCoupons.size()>0){
            for(ImportCoupon imp:importCoupons){
                html = html+"<table><tr>" +
                        "<th>#</th>" +
                        "<th>Tên nhà cung cấp</th>" +
                        "</tr>";
                html = html+"<tr>" +
                        "<td>"+imp.getId()+"</td>" +
                        "<td>"+imp.getNameSupplier()+"</td>" +
                        "</tr>";
            }
            html = html + "</table>";
        }else{
            html = html + "<h4>Không có dữ liệu. Bạn phải thêm nhà cung cấp</h4>";
            html = html + "<a href='/admin/supplier' style='padding: 5px 15px;text-decoration:none;color: #fff;background:#827FFE'>Thêm mới</a>";
        }

        return html;
    }
}
