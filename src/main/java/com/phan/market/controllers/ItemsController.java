package com.phan.market.controllers;

import com.phan.market.config.DBconfig;
import com.phan.market.entity.ExpiryDate;
import com.phan.market.entity.Item;
import com.phan.market.entity.Shipment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin/items")
public class ItemsController {

    private List<Item> items;
    private List<ExpiryDate> shipments;
    private int status;
    private int statusShip=0;
    private String idShipentOld;
    private int updateShi;

    @GetMapping
    public String _default(ModelMap modelMap){
         updateShi = 0;
        items = DBconfig.connectItemDao().itemDaoList();
        shipments=DBconfig.connectExpiryDateDao().selectShipment(-1);
        modelMap.addAttribute("listItem",items);
        modelMap.addAttribute("listShipment",shipments);
        modelMap.addAttribute("statusUpdate",updateShi);
        modelMap.addAttribute("btnInsert","Thêm mới");
        modelMap.addAttribute("btnInsert1","Thêm mới");
        return "items";
    }
    @GetMapping("/function")
    public String _default_function(ModelMap modelMap, @RequestParam String txtId, @RequestParam String txtTen,@RequestParam String txtDonVi){
        Item i = new Item(txtId,txtTen,txtDonVi);
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
        modelMap.addAttribute("listShipment",shipments);
        return "redirect:/admin/items";
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
        modelMap.addAttribute("ds2","display: none");
        modelMap.addAttribute("ds1","display: inline !important");
        modelMap.addAttribute("item",i);
        modelMap.addAttribute("listItem",items);
        modelMap.addAttribute("btnInsert","Sửa mặt hàng");
        modelMap.addAttribute("listShipment",shipments);
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
        modelMap.addAttribute("listShipment",shipments);
        return "redirect:/admin/items";
    }
    private int idItems=-1;
    @GetMapping("/addShipment")
    public String _addShipment(ModelMap modelMap, @RequestParam int id){
        updateShi++;
        shipments=DBconfig.connectExpiryDateDao().selectShipment(id);
        modelMap.addAttribute("ds3","display: inline !important");
        modelMap.addAttribute("listItem",items);
        modelMap.addAttribute("listShipment",shipments);
        idItems=id;
        modelMap.addAttribute("idShipment",idItems);
        modelMap.addAttribute("btnInsert1","Thêm mới");
        modelMap.addAttribute("statusUpdate",updateShi);
        return "items";
    }
    @GetMapping("/shipment/function")
    public String _functionShipment(ModelMap modelMap, @RequestParam String txtMaLo,@RequestParam float txtGiaBan,@RequestParam String txtHSD){
        Shipment shipment = new Shipment(txtMaLo,txtHSD,txtGiaBan,String.valueOf(idItems));
        if(statusShip==0){
            try {
                int index = DBconfig.connectExpiryDateDao().insertShipment(shipment);
                shipments=DBconfig.connectExpiryDateDao().selectShipment(idItems);
            }catch (Exception ex){

            }
        }else{
            try {
                int index = DBconfig.connectExpiryDateDao().updateShipment(shipment,idShipentOld);
                shipments=DBconfig.connectExpiryDateDao().selectShipment(idItems);
                statusShip=0;
                idShipentOld="";
            }catch (Exception ex){

            }
        }


        modelMap.addAttribute("ds3","display: inline !important");
        modelMap.addAttribute("listItem",items);
        modelMap.addAttribute("listShipment",shipments);
        modelMap.addAttribute("btnInsert1","Thêm mới");
        modelMap.addAttribute("statusUpdate",updateShi);
        return "items";
    }
    @GetMapping("/shipment/update")
    public String _update(ModelMap modelMap, @RequestParam String idShipment1){
        statusShip=1;
        idShipentOld=idShipment1;
        Shipment sp1 = new Shipment();
        for(ExpiryDate sp:shipments){
            if(sp.getId().equals(idShipment1)){
                 sp1.setId(sp.getId());sp1.setExpiryDate(sp.getExpiryDate());sp1.setPrice(sp.getPrice());
            }
        }
        modelMap.addAttribute("sp1",sp1);
        modelMap.addAttribute("idShipment1",idShipment1);
        modelMap.addAttribute("ds3","display: inline !important");
        modelMap.addAttribute("listItem",items);
        modelMap.addAttribute("listShipment",shipments);
        modelMap.addAttribute("btnInsert1","Chỉnh sửa");
        modelMap.addAttribute("statusUpdate",updateShi);
        return "items";
    }
    @GetMapping("/shipment/del")
    public String _shipmentDel(ModelMap modelMap, @RequestParam String idShipment1){
        try {
            int index = DBconfig.connectExpiryDateDao().delShipment(idShipment1);
            for(int i=0;i<shipments.size();i++){
                if(shipments.get(i).getId().equals(idShipment1)){
                    shipments.remove(i);
                }
            }
        }catch (Exception ex){}
        modelMap.addAttribute("ds3","display: inline !important");
        modelMap.addAttribute("listItem",items);
        modelMap.addAttribute("listShipment",shipments);
        modelMap.addAttribute("btnInsert1","Chỉnh sửa");
        modelMap.addAttribute("statusUpdate",updateShi);
        return "items";
    }
}