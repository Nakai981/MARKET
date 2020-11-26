package com.phan.market.dao;

import com.phan.market.entity.Employee;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeDao{

    private  JdbcTemplate jdbcTemplate;

    public EmployeeDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Employee> getListEmployee(){
        String query="select * from NhanVien";
        List<Employee> employeeList = new ArrayList<>();
        employeeList = this.jdbcTemplate.query(query, new RowMapper<Employee>() {
            @Override
            public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
                Employee emp = new Employee();
                emp.setMaNV(resultSet.getInt(1));
                emp.setTenNV(resultSet.getString(2));
                emp.setGioiTinh(resultSet.getInt(3));
                emp.setCmnd(resultSet.getLong(4));
                emp.setDiaChi(resultSet.getString(5));
                emp.setUsername(resultSet.getString(6));
                emp.setPassword(resultSet.getString(7   ));
                return emp;
            }
        });
        return employeeList;
    }
}
