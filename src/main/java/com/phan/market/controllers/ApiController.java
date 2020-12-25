package com.phan.market.controllers;

import com.phan.market.config.DBconfig;
import com.phan.market.dao.EmployeeDao;
import com.phan.market.entity.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ApiController  {

    @RequestMapping(value="/api/account",method = RequestMethod.GET)
    @ResponseBody
    public String addPageAccount(@RequestParam int startNum){
        String html ="";
//        List<Employee> employeeList = DBconfig.connectEmployeeDao().getListEmployee(startNum);
//        for(Employee i: employeeList ){
//            html += "<tr>";
//            html += "<td>"+i.getTenNV()+"</td>";
//            html += "<td>"+i.getGioiTinh()+"</td>";
//            html += "<td>"+i.getCmnd()+"</td>";
//            html += "<td>"+i.getSoDienThoai()+"</td>";
//            html += "<td>"+i.getDiaChi()+"</td>";
//            html += "<td>"+i.getUsername()+"</td>";
//            html += "<td>"+i.getPassword()+"</td>";
//            html += "<td><a class=\"btn btn-success\"href=\"/admin/position?MaNV="+i.getMaNV()+"\">+</a></td>";
//            html += "<td><a class=\"btn btn-success\"href=\"/admin/position?MaNV="+i.getMaNV()+"\">Sửa</a>"
//                    +"<a class=\"btn btn-success\"href=\"/admin/deleteAccount?MaNV="+i.getMaNV()+"\">Xóa</a></td>";
//            html += "</tr>";
//        }
        return html;
    }
}
