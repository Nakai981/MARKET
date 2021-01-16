package com.phan.market.controllers;

import com.phan.market.config.DBconfig;
import com.phan.market.entity.ImportCoupon;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/coupons")
public class ImportCouponsController {

    List<ImportCoupon> importCoupons;

    @GetMapping
    public String _coupons(ModelMap modelMap){
        importCoupons =  DBconfig.connectImportCouponDao().importCouponDaoList();
        modelMap.addAttribute("listImportCoupons",importCoupons);
        return "coupons";
    }
}
