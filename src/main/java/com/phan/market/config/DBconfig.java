package com.phan.market.config;

import com.phan.market.dao.*;
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
    public static ImportCouponDao connectImportCouponDao(){
        ImportCouponDao importCouponDao = new ImportCouponDao(DBconfig.dbconnect().getJdbcTemplate());
        return importCouponDao;
    }
    public static BillDao connectBillDao(){
        BillDao billDao = new BillDao(DBconfig.dbconnect().getJdbcTemplate());
        return billDao;
    }
    public static ExpiryDateDao connectExpiryDateDao(){
        ExpiryDateDao expiryDateDao = new ExpiryDateDao(DBconfig.dbconnect().getJdbcTemplate());
        return expiryDateDao;
    }
    public static InventoryDao connectInventoryDao(){
        InventoryDao inventoryDao = new InventoryDao(DBconfig.dbconnect().getJdbcTemplate());
        return inventoryDao;
    }
}
