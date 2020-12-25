package com.phan.market.config;

import com.phan.market.dao.DBConnection;
import com.phan.market.dao.EmployeeDao;
import com.phan.market.dao.ItemDao;
import com.phan.market.dao.SupplierDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DBconfig {
    public static DBConnection dbconnect(){
        ApplicationContext app = new ClassPathXmlApplicationContext("IoC.xml");
        DBConnection dbConnection = (DBConnection)app.getBean("dbConnect");
        return dbConnection;
    }
    public static EmployeeDao  connectEmployeeDao(){
        EmployeeDao emp = new EmployeeDao(DBconfig.dbconnect().getJdbcTemplate());
        return emp;
    }
    public static ItemDao connectItemDao(){
        ItemDao itemDao = new ItemDao(DBconfig.dbconnect().getJdbcTemplate());
        return itemDao;
    }
    public static SupplierDao connectSupplierDao(){
        SupplierDao supplierDao = new SupplierDao(DBconfig.dbconnect().getJdbcTemplate());
        return supplierDao;
    }
}
