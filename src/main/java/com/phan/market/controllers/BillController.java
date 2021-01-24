package com.phan.market.controllers;

import com.phan.market.config.DBconfig;
import com.phan.market.entity.Bill;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin/bill")
public class BillController {
    private List<Bill> bills;
    private List<Bill> billSearch;
    private List<Bill> billItem;
    private float sumPrice;
    private String alert = "";
    private String date11 = "";
    private String date22 = "";

    public void default_date(){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        date11 = date22 = formatter.format(date);
    }
    public void copy(){
        billSearch = new ArrayList<>();
        for(Bill b: bills){
            billSearch.add(b);
        }
    }
    @GetMapping
    public String _default(ModelMap modelMap){
        try{
            bills = DBconfig.connectBillDao().selectBill();
            billItem = DBconfig.connectBillDao().selectItemById(bills.get(0).getId());
            getSumItem();
            copy();
            default_date();  
        }catch(Exception e){

        }

        modelMap.addAttribute("idS",bills.get(0).getId());
        modelMap.addAttribute("sum",sumPrice);
        modelMap.addAttribute("listBill",bills);
        modelMap.addAttribute("billItem",billItem);
        modelMap.addAttribute("date1",date11);
        modelMap.addAttribute("date2",date22);
        return "bill";
    }
    public void getSumItem(){
        sumPrice=0;
        for(Bill b:billItem){
            sumPrice+=b.getSum_price();
        }
    }
    @GetMapping("/detail")
    public String _default_Item(ModelMap modelMap, @RequestParam int id){
        billItem = DBconfig.connectBillDao().selectItemById(id);
        getSumItem();
        modelMap.addAttribute("idS",id);
        modelMap.addAttribute("sum",sumPrice);
        modelMap.addAttribute("listBill",bills);
        modelMap.addAttribute("billItem",billItem);
        modelMap.addAttribute("date1",date11);
        modelMap.addAttribute("date2",date22);
        return "bill";
    }
    @GetMapping("/search")
    public String _default_Search(ModelMap modelMap, @RequestParam(name="txtDate1") String txtDate1,@RequestParam(name="txtDate2") String txtDate2){

        if(null == txtDate1 || null == txtDate1 ) {
            throw new IllegalArgumentException("{\"error\":\"At least one parameter is invalid or not supplied\"}");
        }else{
            try {
                date11 = txtDate1;date22 = txtDate2;
                SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
                Date date1 = formatter1.parse(txtDate1);
                Date date2 = formatter1.parse(txtDate2);
                if(compareDate(date1,date2)){

                }else{
                    alert = "";
                    List<Bill> billList = new ArrayList<>();
                    for(Bill b: billSearch){
                        Date date3 = formatter1.parse(b.getDate());
                        if(date2.compareTo(date3)>=0 && date1.compareTo(date3)<=0){
                            billList.add(b);
                        }
                    }
                    if(billList.size()!=0){
                        bills=new ArrayList<>();
                        for(Bill b: billList){
                            bills.add(b);
                        }
                        billItem = DBconfig.connectBillDao().selectItemById(bills.get(0).getId());
                        getSumItem();
                    }
                }



            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        modelMap.addAttribute("alert",alert);
        modelMap.addAttribute("idS",bills.get(0).getId());
        modelMap.addAttribute("sum",sumPrice);
        modelMap.addAttribute("listBill",bills);
        modelMap.addAttribute("billItem",billItem);
        modelMap.addAttribute("date1",date11);
        modelMap.addAttribute("date2",date22);
        return "bill";
    }
    public boolean compareDate(Date date1, Date date2){
        if(date1.compareTo(date2)>0){
            alert = "<p style='margin-left:10px'>Bạn điền sai. Xin nhập lại!</p>";
            return true;
        }
        return false;
    }
}
