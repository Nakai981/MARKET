package com.phan.market.dao;

import com.phan.market.entity.Item;
import com.phan.market.entity.Supplier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class SupplierDao {
    private JdbcTemplate jdbcTemplate;

    public SupplierDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Supplier> supplierList(){
        List<Supplier> suppliers;
        String query = "SELECT * FROM NHA_CUNG_CAP WHERE ENABLE=1 ORDER BY MA_CUNG_CAP DESC;";
        suppliers = this.jdbcTemplate.query(query, new RowMapper<Supplier>() {
            @Override
            public Supplier mapRow(ResultSet resultSet, int i) throws SQLException {
                Supplier supplier = new Supplier(resultSet.getInt(1),resultSet.getString(2),resultSet.getInt(3),resultSet.getString(4));
                return supplier;
            }
        });
        return suppliers;
    }
    public int addSupplier(final Supplier sp){
        String query = "INSERT INTO NHA_CUNG_CAP VALUES (N'"+sp.getName()+"',"+sp.getPhone()+",N'"+sp.getAddress()+"',1);";
        return this.jdbcTemplate.update(query);
    }
    public int deleteSupplier(final int id){
        String query = "UPDATE NHA_CUNG_CAP SET ENABLE=0 WHERE MA_CUNG_CAP ="+id+"";
        return this.jdbcTemplate.update(query);
    }
    public int updateSupplier(final Supplier sp){
        String query = "UPDATE NHA_CUNG_CAP SET TEN_CUNG_CAP=N'"+sp.getName()+"',SDT="+sp.getPhone()+",DIACHI=N'"+sp.getAddress()+"' WHERE MA_CUNG_CAP = "+sp.getId()+"";
        return this.jdbcTemplate.update(query);
    }
}
