package com.phan.market.dao;

import com.phan.market.entity.Bill;
import com.phan.market.entity.Employee;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BillDao {
    private JdbcTemplate jdbcTemplate;

    public BillDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Bill> selectBill(){
        List<Bill> bills;
        String query = "SELECT * FROM DANH_SACH_HOA_DON";

        bills = this.jdbcTemplate.query(query, new RowMapper<Bill>() {
            @Override
            public Bill mapRow(ResultSet resultSet, int i) throws SQLException {
                Bill bill = new Bill(resultSet.getInt(1),resultSet.getString(2),
                        resultSet.getString(3));
                return bill;
            }
        });
        return bills;
    }
    public List<Bill> selectItemById(int id){
        List<Bill> bills;
        String query = "EXEC DANH_SACH_MAT_HANG_THEO_MAHD @id = "+id;

        bills = this.jdbcTemplate.query(query, new RowMapper<Bill>() {
            @Override
            public Bill mapRow(ResultSet resultSet, int i) throws SQLException {
                Bill bill = new Bill(resultSet.getString(1),resultSet.getInt(2),resultSet.getFloat(3),
                        resultSet.getFloat(4));
                return bill;
            }
        });
        return bills;
    }
    public List<Bill> selectItemBydate(String date,int select){
        String query = null;
        switch (select){
            case 1: // day
                query = "EXEC DOANH_THU_THEO_NGAY @date='"+date+"'";
                break;
            case 2: // month
                query = "EXEC DOANH_THU_THEO_THANG @date='"+date+"'";
                break;
            case 3: // year
                query = "EXEC DOANH_THU_THEO_NAM @date='"+date+"'";
                break;
            default: //day
                query = "EXEC DOANH_THU_THEO_NGAY @date='"+date+"'";
                break;
        }

        List<Bill> bills;
        bills = this.jdbcTemplate.query(query, new RowMapper<Bill>() {
            @Override
            public Bill mapRow(ResultSet resultSet, int i) throws SQLException {
                Bill bill = new Bill(resultSet.getInt(1),resultSet.getString(2)
                        ,resultSet.getString(3),resultSet.getString(4),resultSet.getInt(5),
                        resultSet.getFloat(6),resultSet.getFloat(7));
                return bill;
            }
        });
        return bills;
    }
}
