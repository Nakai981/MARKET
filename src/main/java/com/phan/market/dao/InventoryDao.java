package com.phan.market.dao;

import com.phan.market.entity.Bill;
import com.phan.market.entity.Inventory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class InventoryDao {
    private JdbcTemplate jdbcTemplate;

    public InventoryDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Inventory> selectInventory(){
        List<Inventory> inventorys;
        String query = "SELECT PHIEU_KIEM_KE.MA_PHIEU_KIEM,PHIEU_KIEM_KE.NGAY_LAP,NHAN_VIEN.TEN_NV FROM PHIEU_KIEM_KE\n" +
                "INNER JOIN NHAN_VIEN ON NHAN_VIEN.MA_NV = PHIEU_KIEM_KE.MA_NV\n" +
                "ORDER BY MA_PHIEU_KIEM DESC";

        inventorys = this.jdbcTemplate.query(query, new RowMapper<Inventory>() {
            @Override
            public Inventory mapRow(ResultSet resultSet, int i) throws SQLException {
                Inventory inventory = new Inventory();
                inventory.setId(resultSet.getInt(1));
                inventory.setDate(resultSet.getString(2));
                inventory.setNameEmployee(resultSet.getString(3));
                return inventory;
            }
        });
        return inventorys;
    }
    public int addInventory(int id){
        String query = "INSERT INTO PHIEU_KIEM_KE(ENABLE,MA_NV) VALUES (1,'"+id+"')";
        return this.jdbcTemplate.update(query);
    }
    public int delInventory(int id){
        String query = "UPDATE PHIEU_KIEM_KE SET ENABLE =1 WHERE MA_PHIEU_KIEM="+id;
        return this.jdbcTemplate.update(query);
    }
    public List<Inventory> selectDetailInventory(int id){
        List<Inventory> inventorys;
        String query = "EXEC DS_CT_PHIEU_KIEM_KE @id="+id;

        inventorys = this.jdbcTemplate.query(query, new RowMapper<Inventory>() {
            @Override
            public Inventory mapRow(ResultSet resultSet, int i) throws SQLException {
                Inventory inventory = new Inventory();
                inventory.setIdDetail(resultSet.getInt(1));
                inventory.setNameShiment(resultSet.getString(2));
                inventory.setCount(resultSet.getInt(3));
                inventory.setCounted(resultSet.getInt(4));
                inventory.setCo(resultSet.getInt(5));
                return inventory;
            }
        });
        return inventorys;
    }
    public int addDetailInventory(int count, String idShipment,int idInven){
        String query = "INSERT INTO CHI_TIET_KIEM_KE VALUES ("+count+",'"+idShipment+"',"+idInven+")";
        return this.jdbcTemplate.update(query);
    }
}
