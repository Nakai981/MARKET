package com.phan.market.dao;

import com.phan.market.entity.ExpiryDate;
import com.phan.market.entity.Shipment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ExpiryDateDao {
    private JdbcTemplate jdbcTemplate;
    public ExpiryDateDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate  = jdbcTemplate;
    }

    public List<ExpiryDate> selectExpiry(int index){
        List<ExpiryDate> expiryDateList;
        String query = "EXEC DS_MH_HET_HAN @count="+index;

        expiryDateList = this.jdbcTemplate.query(query, new RowMapper<ExpiryDate>() {
            @Override
            public ExpiryDate mapRow(ResultSet resultSet, int i) throws SQLException {
                ExpiryDate expiryDate = new ExpiryDate(resultSet.getString(1),resultSet.getString(2),
                        resultSet.getString(3),resultSet.getString(4),resultSet.getInt(5),
                        resultSet.getFloat(6));
                return expiryDate;
            }
        });
        return expiryDateList;
    }
    public List<ExpiryDate> selectIteamBySearch(String index){
        List<ExpiryDate> expiryDateList;
        String query = "SELECT LO_HANG.MA_LO,MAT_HANG.TEN_MH FROM LO_HANG INNER JOIN MAT_HANG ON MAT_HANG.MA_MH = LO_HANG.MA_MH WHERE LO_HANG.MA_LO='"+index+"'";

        expiryDateList = this.jdbcTemplate.query(query, new RowMapper<ExpiryDate>() {
            @Override
            public ExpiryDate mapRow(ResultSet resultSet, int i) throws SQLException {
                ExpiryDate expiryDate = new ExpiryDate();
                expiryDate.setId(resultSet.getString(1));
                expiryDate.setNameItem(resultSet.getString(2));
                return expiryDate;
            }
        });
        return expiryDateList;
    }

    public List<ExpiryDate> selectShipment(int index){
        List<ExpiryDate> expiryDateList;
        String query="";
        if (index == -1) {
             query = "SELECT LO_HANG.MA_LO,MAT_HANG.TEN_MH,LO_HANG.SL,LO_HANG.GIA_BAN,LO_HANG.HSD,MAT_HANG.MA_MH FROM LO_HANG\n" +
                    "INNER JOIN MAT_HANG ON LO_HANG.MA_MH=MAT_HANG.MA_MH WHERE  LO_HANG.ENABLE=1  ORDER BY SL DESC";
        }else{
            query = "SELECT LO_HANG.MA_LO,MAT_HANG.TEN_MH,LO_HANG.SL,LO_HANG.GIA_BAN,LO_HANG.HSD,MAT_HANG.MA_MH FROM LO_HANG\n" +
                    "INNER JOIN MAT_HANG ON LO_HANG.MA_MH=MAT_HANG.MA_MH WHERE LO_HANG.MA_MH='"+index+"' AND LO_HANG.ENABLE=1  ORDER BY SL DESC";
        }


        expiryDateList = this.jdbcTemplate.query(query, new RowMapper<ExpiryDate>() {
            @Override
            public ExpiryDate mapRow(ResultSet resultSet, int i) throws SQLException {
                ExpiryDate expiryDate = new ExpiryDate();
                expiryDate.setId(resultSet.getString(1));
                expiryDate.setNameItem(resultSet.getString(2));
                expiryDate.setCount(resultSet.getInt(3));
                expiryDate.setPrice(resultSet.getInt(4));
                expiryDate.setExpiryDate(resultSet.getString(5));
                expiryDate.setStartDate(resultSet.getString(6));
                return expiryDate;
            }
        });
        return expiryDateList;
    }
    public int insertShipment(final Shipment shipment){
        String query = " INSERT INTO LO_HANG VALUES ('"+shipment.getId()+"','0','"+shipment.getExpiryDate()+"',"+shipment.getPrice()+",1,'"+shipment.getIdItem()+"')";
        return this.jdbcTemplate.update(query);
    }
    public int updateShipment(final Shipment shipment, String id){
        String query = "UPDATE LO_HANG SET MA_LO='"+shipment.getId()+"',SL="+shipment.getCount()+",HSD='"+shipment.getExpiryDate()+"',GIA_BAN='"+shipment.getPrice()+"' WHERE MA_LO='"+id+"'";
        return this.jdbcTemplate.update(query);
    }
    public int delShipment(String id){
        String query = " UPDATE LO_HANG SET ENABLE=0 WHERE MA_LO='"+id+"'";
        return this.jdbcTemplate.update(query);
    }
}
