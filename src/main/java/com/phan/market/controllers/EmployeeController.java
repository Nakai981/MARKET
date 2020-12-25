package com.phan.market.controllers;

import com.phan.market.config.DBconfig;
import com.phan.market.entity.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class EmployeeController {
    private List<Employee> alllist;
    private String html;
    private static final int ITEM = 3;
    private double size_page;
    private int status = 0;
    private List<Employee> list_page;

    public List<Employee> getPageArray(int begin, int end){
        int size=0;
        if(end> alllist.size()){
            size = alllist.size();
        }else{
            size = end;
        }
        List<Employee> list = new ArrayList<>();
        for(int i=begin;i<size;i++){
            list.add(alllist.get(i));
        }
        return list;
    }
    @RequestMapping("/admin/account")
    public String _default(ModelMap modelMap) {
        //get data to DB
        alllist = DBconfig.connectEmployeeDao().employeeList();
        // panigation
        list_page = this.getPageArray(0,ITEM);
        size_page = Math.ceil((double) alllist.size()/ITEM);
        // Out view
        modelMap.addAttribute("listEmployee",list_page);
        modelMap.addAttribute("sizepage",size_page);
        modelMap.addAttribute("btnUpdate","Thêm mới");
        return "account";
    }
    @RequestMapping("/admin/account/page")
    public String _default_page(ModelMap modelMap,@RequestParam int page) {
        // panigation
        list_page = this.getPageArray((page-1)*ITEM,page*ITEM);
        // Out view
        modelMap.addAttribute("listEmployee",list_page);
        modelMap.addAttribute("sizepage",size_page);
        modelMap.addAttribute("btnUpdate","Thêm mới");
        return "account";
    }

    @RequestMapping(value="/admin/account/add")
    public String _default_add(ModelMap modelMap,@RequestParam int txtId,@RequestParam String txtName, @RequestParam int txtGT, @RequestParam Long txtSDT, @RequestParam Long txtCMND,
                            @RequestParam String txtDiaChi, @RequestParam String txtUser, @RequestParam String txtPass,@RequestParam int txtCV) {
        if(txtCV==3 && status==0){
            Employee emp1 = new Employee(txtName, txtGT, txtSDT, txtCMND, txtDiaChi, txtUser, txtPass,1);
            Employee emp2 = new Employee(txtName, txtGT, txtSDT, txtCMND, txtDiaChi, txtUser, txtPass,2);
            DBconfig.connectEmployeeDao().addEmployee(emp1);
            DBconfig.connectEmployeeDao().addEmployee(emp2);

            alllist = DBconfig.connectEmployeeDao().employeeList();
            list_page = this.getPageArray(0, ITEM);
            size_page = Math.ceil((double) alllist.size() / ITEM);
            //Alert
            html = "<div style=\"height: 30px;width: 100%; background: #bd4147\"><p style=\"color:white;padding:7px 15px;font-size: 13px\">Thêm thành công nhân viên</p></div>";

        }else if(txtCV!=3 && status==0){
            Employee emp = new Employee(txtName, txtGT, txtSDT, txtCMND, txtDiaChi, txtUser, txtPass,txtCV);

                //DB
                DBconfig.connectEmployeeDao().addEmployee(emp);
                //Page
                alllist = DBconfig.connectEmployeeDao().employeeList();
                list_page = this.getPageArray(0, ITEM);
                size_page = Math.ceil((double) alllist.size() / ITEM);
                //Alert
                html = "<div style=\"height: 30px;width: 100%; background: #bd4147\"><p style=\"color:white;padding:7px 15px;font-size: 13px\">Thêm thành công nhân viên</p></div>";

            }else if (status!=0){
                Employee emp = new Employee(txtName, txtGT, txtSDT, txtCMND, txtDiaChi, txtUser, txtPass,txtCV);
                emp.setId(txtId);
                DBconfig.connectEmployeeDao().updateEmployee(emp);
                updateAllist(emp,alllist);
                updateAllist(emp,list_page);
            html = "<div style=\"height: 30px;width: 100%; background: #bd4147\"><p style=\"color:white;padding:7px 15px;font-size: 13px\">Chỉnh sửa thành công</p></div>";
                status = 0;
            }else{
            html = "<div style=\"height: 30px;width: 100%; background: #bd4147\"><p style=\"color:white;padding:7px 15px;font-size: 13px\">Không thành công</p></div>";
        }

        modelMap.addAttribute("alert",html);
        modelMap.addAttribute("listEmployee",list_page);
        modelMap.addAttribute("sizepage",size_page);
        modelMap.addAttribute("btnUpdate","Thêm mới");
        return "account";
    }
    public Employee getEmployeeToId(int id){
        Employee emp = new Employee();
        for(Employee e:alllist){
            if(e.getId() == id){
                emp = e;
            }
        }
        return emp;
    }
    public void updateAllist(Employee emp, List<Employee> emps){

        for(int i=0;i<emps.size();i++){
            if(emps.get(i).getId() == emp.getId()){
                int location = i;
                emps.remove(location);
                emps.add(i,emp);
            }
        }
    }
    @RequestMapping("/admin/account/update")
    public String _default_update(ModelMap modelMap, @RequestParam int id) {
        Employee emp = this.getEmployeeToId(id);
        status = 1;
        // Out view
        modelMap.addAttribute("empUpdate",emp);
        modelMap.addAttribute("btnUpdate","Sửa nhân viên");
        modelMap.addAttribute("listEmployee",list_page);
        modelMap.addAttribute("sizepage",size_page);
        return "account";
    }
    @RequestMapping("/admin/account/delete")
    public String _default_delete(ModelMap modelMap, @RequestParam int id) {
        DBconfig.connectEmployeeDao().deleteEmployee(id);
        alllist = DBconfig.connectEmployeeDao().employeeList();
        for(int i=0;i<list_page.size();i++){
            if(list_page.get(i).getId() == id){
                list_page.remove(i);
            }
        }
        size_page = Math.ceil((double) alllist.size()/ITEM);
        // Out view
        modelMap.addAttribute("btnUpdate","Thêm mới");
        modelMap.addAttribute("listEmployee",list_page);
        modelMap.addAttribute("sizepage",size_page);
        return "account";
    }

}
