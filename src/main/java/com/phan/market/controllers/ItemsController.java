package com.phan.market.controllers;

import com.phan.market.config.DBconfig;
import com.phan.market.entity.Employee;
import com.phan.market.entity.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin/items")
public class ItemsController {

    private List<Item> items;
    private int status;

    @GetMapping
    public String _default(ModelMap modelMap){
        items = DBconfig.connectItemDao().itemDaoList();
        modelMap.addAttribute("listItem",items);
        modelMap.addAttribute("btnInsert","Thêm mới");
        return "items";
    }
    @GetMapping("/function")
    public String _default_function(ModelMap modelMap,@RequestParam String txtCode,@RequestParam String txtTen,@RequestParam String txtDonVi){
        Item i = new Item(txtCode,txtTen,txtDonVi);
        String html;
        if(status == 0){
            //Insert
            DBconfig.connectItemDao().addItem(i);
            items = DBconfig.connectItemDao().itemDaoList();
            html = "<div style=\"height: 30px;width: 100%; background: #bd4147\"><p style=\"color:white;padding:7px 15px;font-size: 13px\">Thêm thành công mặt hàng</p></div>";
        }else{
            //Update
            DBconfig.connectItemDao().updateItem(i);
            updateAllist(i,items);
            html = "<div style=\"height: 30px;width: 100%; background: #bd4147\"><p style=\"color:white;padding:7px 15px;font-size: 13px\">Sửa thành công mặt hàng</p></div>";
            status = 0;
        }
        modelMap.addAttribute("btnInsert","Thêm mới");
        modelMap.addAttribute("listItem",items);
        modelMap.addAttribute("alert",html);
        return "items";
    }
    public void updateAllist(Item emp, List<Item> emps){

        for(int i=0;i<emps.size();i++){
            if(emps.get(i).getId().equals(emp.getId())){
                int location = i;
                emps.remove(location);
                emps.add(i,emp);
            }
        }
    }

    public Item getItembyId(String id){
        Item i = new Item();
        for(Item e:items){
            if(e.getId().equals(id)){
                i = e;
            }
        }
        return i;
    }
    @GetMapping("/update")
    public String _default_update(ModelMap modelMap, @RequestParam String id){
        status = 1;
        Item i = getItembyId(id);
        modelMap.addAttribute("item",i);
        modelMap.addAttribute("listItem",items);
        modelMap.addAttribute("btnInsert","Sửa mặt hàng");
        return "items";
    }
    @GetMapping("/delete")
    public String _default_delete(ModelMap modelMap, @RequestParam String id){
        DBconfig.connectItemDao().deleteItem(id);
        for(int i=0;i<items.size();i++){
            if(items.get(i).getId() == id){
                items.remove(i);
            }
        }
        items = DBconfig.connectItemDao().itemDaoList();
        modelMap.addAttribute("listItem",items);
        modelMap.addAttribute("btnInsert","Thêm mới");
        return "items";
    }

}
