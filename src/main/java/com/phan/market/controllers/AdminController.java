package com.phan.market.controllers;

import com.phan.market.config.DBconfig;
import com.phan.market.entity.Bill;
import com.phan.market.entity.ExpiryDate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class AdminController {
    private int id;
    private List<ExpiryDate> expiryDateList;
    private List<Bill> bills;
    private int sumBill;
    private String txtDate1;

    public void sumPrice(){
        sumBill=0;
        for(Bill b:bills){
            sumBill += b.getSum_price();
        }
    }

    @RequestMapping(value = {"/admin","/admin/home"})
    public String admin(ModelMap modelMap) {
        expiryDateList = DBconfig.connectExpiryDateDao().selectExpiry(1);
        id=1;
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        txtDate1 = formatter.format(date);
        bills = DBconfig.connectBillDao().selectItemBydate(txtDate1,1);
        sumPrice();
        modelMap.addAttribute("date",txtDate1);
        modelMap.addAttribute("sumBill",sumBill);
        modelMap.addAttribute("listExpiry",expiryDateList);
        modelMap.addAttribute("idd",id);
        return "home";
    }
    @RequestMapping("/admin/home/detail")
    public String admin_home_2(ModelMap modelMap,@RequestParam(value="i") String i) {
        if(null==i){
            throw new IllegalArgumentException("{\"error\":\"At least one parameter is invalid or not supplied\"}");
        }else{
            id = Integer.valueOf(i);
            expiryDateList = DBconfig.connectExpiryDateDao().selectExpiry(id);
        }
        modelMap.addAttribute("date",txtDate1);
        modelMap.addAttribute("sumBill",sumBill);
        modelMap.addAttribute("idd",id);
        modelMap.addAttribute("listExpiry",expiryDateList);
        return "home";
    }
    @RequestMapping("/admin/home/date")
    public String admin_home_date(ModelMap modelMap,@RequestParam(value="txtDate") String txtDate,@RequestParam(value="txtSelect") String txtSelect) {
        if(null==txtDate || txtSelect == null){
            throw new IllegalArgumentException("{\"error\":\"At least one parameter is invalid or not supplied\"}");
        }else{
           bills = DBconfig.connectBillDao().selectItemBydate(txtDate,Integer.valueOf(txtSelect));
           sumPrice();
        }
        modelMap.addAttribute("date",txtDate);
        modelMap.addAttribute("sumBill",sumBill);
        modelMap.addAttribute("idd",id);
        modelMap.addAttribute("listExpiry",expiryDateList);
        return "home";
    }


}
