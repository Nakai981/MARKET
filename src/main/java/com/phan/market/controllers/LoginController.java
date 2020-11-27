package com.phan.market.controllers;

import com.phan.market.dao.DBConnection;
import com.phan.market.dao.EmployeeDao;
import com.phan.market.entity.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Controller

public class LoginController {

    @RequestMapping(value = {"/login", "/"})
    public String login(@RequestParam(value = "error", required = false) final String error,
                        final Model model) {
        if (error != null) {
            model.addAttribute("message", "Username and password Failed!");
        }
        return "login";
    }
    @RequestMapping("/logout")
    public String logout(final Model model) {
        model.addAttribute("message", "Logged out!");
        return "login";
    }
    @RequestMapping("/direction")
    public String direction() {
        return "direction";
    }
}
