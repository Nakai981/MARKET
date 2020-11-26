package com.phan.market.controllers;

import com.phan.market.dao.DBConnection;
import com.phan.market.dao.EmployeeDao;
import com.phan.market.entity.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class LoginController {

    @GetMapping
    public String _default(ModelMap modelMap){
        ApplicationContext app = new ClassPathXmlApplicationContext("IoC.xml");
        DBConnection dbConnection = (DBConnection) app.getBean("dbConnect");
        EmployeeDao employeeDao = new EmployeeDao(dbConnection.getJdbcTemplate());
        List<Employee> list = new ArrayList<>();
        list= employeeDao.getListEmployee();
        modelMap.addAttribute("list",list.size());
        return "login";
    }

}
