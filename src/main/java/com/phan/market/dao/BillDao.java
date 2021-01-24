package com.phan.market.dao;

import com.phan.market.entity.Bill;
import com.phan.market.entity.Employee;
import com.phan.market.entity.Item;
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
    public int addBill(int id){
        String query = "INSERT INTO HOA_DON_BAN(ENABLE,MA_NV) VALUES (1,'"+id+"')";
        return this.jdbcTemplate.update(query);
    }
    public int addDetailBill(Bill bill,int idBill){
        String query = "INSERT INTO CHI_TIET_HOA_DON VALUES("+bill.getCount()+","+idBill+",'"+bill.getName_employee()+"')";
        return this.jdbcTemplate.update(query);
    }
    public Bill getIdBill(){
        Bill bill;
        String query = "SELECT TOP 1 MA_HD FROM HOA_DON_BAN WHERE ENABLE=1 ORDER BY MA_HD DESC";
        bill = this.jdbcTemplate.queryForObject(query, new RowMapper<Bill>() {
            @Override
            public Bill mapRow(ResultSet resultSet, int i) throws SQLException {
                Bill bill = new Bill();
                bill.setId(resultSet.getInt(1));
                return bill;
            }
        });
        return bill;
    }

    public List<Bill> getBillbyIdShipment(String id){
        List<Bill> bills;
        String query = "EXEC TIM_KIEM_SAN_PHAM_THEO_MALO @id="+id;

        bills = this.jdbcTemplate.query(query, new RowMapper<Bill>() {
            @Override
            public Bill mapRow(ResultSet resultSet, int i) throws SQLException {
                Bill bill = new Bill();
                bill.setName_employee(resultSet.getString(3));
                bill.setName_item(resultSet.getString(1));
                bill.setPrice(resultSet.getFloat(2));
                return bill;
            }
        });
        return bills;
    }

    public List<Bill> selectItemBySearchAPI(String name){
        List<Bill> billList;
        String query = "SELECT TOP 5 LO_HANG.MA_LO,MAT_HANG.TEN_MH,LO_HANG.GIA_BAN FROM MAT_HANG\n" +
                "\t\tINNER JOIN LO_HANG \n" +
                "\t\tON MAT_HANG.MA_MH = LO_HANG.MA_MH\n" +
                "\t\tWHERE  LO_HANG.MA_LO LIKE '%"+name+"%'  OR  MAT_HANG.TEN_MH LIKE '%"+name+"%' AND LO_HANG.ENABLE=1 AND LO_HANG.SL>0";
        billList = this.jdbcTemplate.query(query, new RowMapper<Bill>() {
            @Override
            public Bill mapRow(ResultSet resultSet, int i) throws SQLException {
                Bill bill = new Bill();
                //Mã lô
                bill.setName_employee(resultSet.getString(1));
                bill.setName_item(resultSet.getString(2));
                //Tên lô
                bill.setPrice(resultSet.getFloat(3));
                return bill;
            }
        });
        return billList;
    }
}
