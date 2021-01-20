package com.phan.market.controllers;

import com.phan.market.config.DBconfig;
import com.phan.market.entity.Employee;
import com.phan.market.entity.ImportCoupon;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/admin/coupons")
public class ImportCouponsController {
    List<ImportCoupon> importCouponList;
    List<ImportCoupon> importCouponDetail;
    private String accountName="";
    private int idCoupon=0;
    private float sumPrice;

    public void totalCoupons(){
        sumPrice =0;
        for(ImportCoupon im: importCouponDetail){
            sumPrice+=im.getPriceCoupon();
        }
    }

    @GetMapping
    public String _coupons(ModelMap modelMap, Principal principal){
        accountName = principal.getName();
        importCouponList =  DBconfig.connectImportCouponDao().importCouponList();
        idCoupon=importCouponList.get(0).getId();
        importCouponDetail=DBconfig.connectImportCouponDao().importDetailCouponList(idCoupon);
        totalCoupons();

        modelMap.addAttribute("user",accountName);
        modelMap.addAttribute("idCoupon",idCoupon);
        modelMap.addAttribute("importCoupons",importCouponList);
        modelMap.addAttribute("total",sumPrice);
        modelMap.addAttribute("importCouponsDetail",importCouponDetail);
        return "coupons";
    }

    @GetMapping("/detail")
    public String _coupons_detail(ModelMap modelMap,@RequestParam int id){

        try{
            idCoupon=id;
            importCouponDetail=DBconfig.connectImportCouponDao().importDetailCouponList(idCoupon);
            totalCoupons();
        }catch (Exception ex){}

        modelMap.addAttribute("user",accountName);
        modelMap.addAttribute("importCoupons",importCouponList);
        modelMap.addAttribute("importCouponsDetail",importCouponDetail);
        modelMap.addAttribute("idCoupon",idCoupon);
        modelMap.addAttribute("total",sumPrice);
        return "coupons";
    }
    @GetMapping("/detail/add")
    public String _coupons_detail_add(ModelMap modelMap,@RequestParam String txtMaLo,@RequestParam String txtNCC,@RequestParam float txtDonGia,@RequestParam int txtSL){

        try{
            ImportCoupon imp = new ImportCoupon(idCoupon,txtNCC,txtMaLo,txtSL,txtDonGia);
            int index = DBconfig.connectImportCouponDao().addDetailCoupon(imp);
        }catch (Exception ex){}

        modelMap.addAttribute("user",accountName);
        modelMap.addAttribute("importCoupons",importCouponList);
        modelMap.addAttribute("importCouponsDetail",importCouponDetail);
        modelMap.addAttribute("idCoupon",idCoupon);
        return "redirect:/admin/coupons/detail?id="+idCoupon;
    }
    @GetMapping("/add")
    public String _coupons_add(ModelMap modelMap){

        try{
            Employee employee = DBconfig.connectEmployeeDao().getIdEmpolyeeByName(accountName);
            int index = DBconfig.connectImportCouponDao().addCoupon(employee.getId());

        }catch (Exception ex){}

        modelMap.addAttribute("user",accountName);
        modelMap.addAttribute("importCoupons",importCouponList);
        modelMap.addAttribute("importCouponsDetail",importCouponDetail);
        modelMap.addAttribute("idCoupon",idCoupon);
        return "redirect:/admin/coupons";
    }
    @GetMapping("/del")
    public String _coupons_del(ModelMap modelMap,@RequestParam int id){

        try{
            int index = DBconfig.connectImportCouponDao().delCoupon(id);
        }catch (Exception ex){}

        modelMap.addAttribute("user",accountName);
        modelMap.addAttribute("importCoupons",importCouponList);
        modelMap.addAttribute("importCouponsDetail",importCouponDetail);
        modelMap.addAttribute("idCoupon",idCoupon);
        return "redirect:/admin/coupons";
    }
}
