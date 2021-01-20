package com.phan.market.dao;

import com.phan.market.entity.ExpiryDate;
import com.phan.market.entity.Item;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ItemDao {
    private JdbcTemplate jdbcTemplate;

    public ItemDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

//    public List<ExpiryDate> itemDaoList(){
//        List<ExpiryDate> items;
//        String query = "SELECT * FROM THONG_TIN_MAT_HANG";
//        items = this.jdbcTemplate.query(query, new RowMapper<ExpiryDate>() {
//            @Override
//            public ExpiryDate mapRow(ResultSet resultSet, int i) throws SQLException {
//                ExpiryDate item = new ExpiryDate(resultSet.getString(1),resultSet.getString(3),
//                        resultSet.getString(2),resultSet.getInt(4),resultSet.getString(5),resultSet.getFloat(6));
//                return item;
//            }
//        });
//        return items;
//    }
    public List<Item> selectItemBySearch(String name){
        List<Item> items;
        String query = "SELECT * FROM MAT_HANG WHERE TEN_MH LIKE '%"+name+"%'";
        items = this.jdbcTemplate.query(query, new RowMapper<Item>() {
            @Override
            public Item mapRow(ResultSet resultSet, int i) throws SQLException {
                Item item = new Item(resultSet.getString(2),resultSet.getString(3));
                return item;
            }
        });
        return items;
    }
        public int addItem(final Item i){
            String query = "INSERT INTO MAT_HANG VALUES (N'"+i.getName()+"',N'"+i.getUnit()+"',1)";
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
}
