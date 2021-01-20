package com.phan.market.controllers;

import com.phan.market.config.DBconfig;
import com.phan.market.entity.Supplier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin/supplier")
public class SupplierController {

    private List<Supplier> suppliers;
    private int status;
    @GetMapping
    public String _default(ModelMap modelMap){
        suppliers = DBconfig.connectSupplierDao().supplierList();
        modelMap.addAttribute("listSupplier",suppliers);
        modelMap.addAttribute("btnInsert","Thêm mới");
        return "supplier";
    }
    @GetMapping("/function")
    public String _default_function(ModelMap modelMap,@RequestParam int txtId, @RequestParam String txtName, @RequestParam String txtDiaChi, @RequestParam int txtSDT){
        Supplier sp = new Supplier(txtName,txtSDT,txtDiaChi);
        String html;
        if(status == 0){
            //Insert
            DBconfig.connectSupplierDao().addSupplier(sp);
            suppliers = DBconfig.connectSupplierDao().supplierList();
            html = "<div style=\"height: 30px;width: 100%; background: #bd4147\"><p style=\"color:white;padding:7px 15px;font-size: 13px\">Thêm thành công nhà cung cấp</p></div>";
        }else{
            //Update
            DBconfig.connectSupplierDao().updateSupplier(sp);
            sp.setId(txtId);
            updateAllist(sp,suppliers);
            html = "<div style=\"height: 30px;width: 100%; background: #bd4147\"><p style=\"color:white;padding:7px 15px;font-size: 13px\">Sửa thành công nhà cung cấp</p></div>";
            status = 0;
        }
        modelMap.addAttribute("btnInsert","Thêm mới");
        modelMap.addAttribute("listSupplier",suppliers);
        modelMap.addAttribute("alert",html);
        return "supplier";
    }
    public void updateAllist(Supplier emp, List<Supplier> emps){

        for(int i=0;i<emps.size();i++){
            if(emps.get(i).getId() == emp.getId()){
                int location = i;
                emps.remove(location);
                emps.add(location,emp);
            }
        }
    }

    public Supplier getItembyId(int id){
        Supplier i = new Supplier();
        for(Supplier e:suppliers){
            if(e.getId() == id){
                i = e;
            }
        }
        return i;
    }
    @GetMapping("/update")
    public String _default_update(ModelMap modelMap, @RequestParam int id){
        status = 1;
        Supplier i = getItembyId(id);
        modelMap.addAttribute("idSupp",id);
        modelMap.addAttribute("item",i);
        modelMap.addAttribute("listSupplier",suppliers);
        modelMap.addAttribute("btnInsert","Sửa nhà cung cấp");
        return "supplier";
    }
    @GetMapping("/delete")
    public String _default_delete(ModelMap modelMap, @RequestParam int id){
        DBconfig.connectSupplierDao().deleteSupplier(id);
        for(int i=0;i<suppliers.size();i++){
            if(suppliers.get(i).getId() == id){
                suppliers.remove(i);
            }
        }
        modelMap.addAttribute("listSupplier",suppliers);
        modelMap.addAttribute("btnInsert","Thêm mới");
        return "supplier";
    }
}
