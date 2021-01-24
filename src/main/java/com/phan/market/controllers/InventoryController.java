package com.phan.market.controllers;

import com.phan.market.config.DBconfig;
import com.phan.market.entity.Employee;
import com.phan.market.entity.Inventory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/admin/inventory")
public class InventoryController {
    int idInven=0;
    private List<Inventory> inventories;
    private List<Inventory> inventoriyDetails;
    @GetMapping
    public String _default(ModelMap modelMap){
        inventories = DBconfig.connectInventoryDao().selectInventory();
        idInven=inventories.get(0).getId();
        inventoriyDetails= DBconfig.connectInventoryDao().selectDetailInventory(idInven);
        modelMap.addAttribute("idInven",idInven);
        modelMap.addAttribute("inventories",inventories);
        modelMap.addAttribute("inventoriyDetails",inventoriyDetails);
        return "inventory";
    }
    @GetMapping("/add")
    public String _default_add(ModelMap modelMap, Principal principal){

        try{
            Employee idEmp = DBconfig.connectEmployeeDao().getIdEmpolyeeByName(principal.getName());
            int index = DBconfig.connectInventoryDao().addInventory(idEmp.getId());
        }catch(Exception e){

        }

        return "redirect:/admin/inventory";
    }
    @GetMapping("/del")
    public String _default_del(ModelMap modelMap, Principal principal, @RequestParam int id){

        try{
            int index = DBconfig.connectInventoryDao().delInventory(id);
        }catch(Exception e){

        }

        return "redirect:/admin/inventory";
    }
    @GetMapping("/detail")
    public String _default_detail(ModelMap modelMap, Principal principal, @RequestParam int id){
        try{
            idInven=id;
            inventoriyDetails= DBconfig.connectInventoryDao().selectDetailInventory(idInven);
        }catch (Exception e){}
        modelMap.addAttribute("idInven",idInven);
        modelMap.addAttribute("inventoriyDetails",inventoriyDetails);
        modelMap.addAttribute("inventories",inventories);
        return "inventory";
    }
    @GetMapping("/detailadd")
    public String _default_detail_add(ModelMap modelMap, @RequestParam int txtSl,@RequestParam String txtMaLo){
        try{
            int index = DBconfig.connectInventoryDao().addDetailInventory(txtSl,txtMaLo,idInven);
        }catch (Exception e){}

        return "redirect:/admin/inventory/detail?id="+idInven;
    }
}
