package com.phan.market.dao;

import com.phan.market.entity.Employee;
import com.phan.market.entity.Item;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ItemDao {
    private JdbcTemplate jdbcTemplate;

    public ItemDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Item> itemDaoList(){
        List<Item> items;
        String query = "SELECT * FROM MAT_HANG WHERE ENABLE=1 ORDER BY MA_MH DESC";
        items = this.jdbcTemplate.query(query, new RowMapper<Item>() {
            @Override
            public Item mapRow(ResultSet resultSet, int i) throws SQLException {
                Item item = new Item(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3));
                return item;
            }
        });
        return items;
    }
    public int addItem(final Item i){
        String query = "INSERT INTO MAT_HANG VALUES ('"+i.getId()+"',N'"+i.getName()+"',N'"+i.getUnit()+"',1)";
        return this.jdbcTemplate.update(query);
    }
    public int deleteItem(final String id){
        String query = "UPDATE MAT_HANG SET ENABLE=0 WHERE MA_MH = '"+id+"'";
        return this.jdbcTemplate.update(query);
    }
    public int updateItem(final Item i){
        String query = "UPDATE MAT_HANG SET TEN_MH=N'"+i.getName()+"', DON_VI=N'"+i.getUnit()+"' WHERE MA_MH = '"+i.getId()+"'";
        return this.jdbcTemplate.update(query);
    }
}
