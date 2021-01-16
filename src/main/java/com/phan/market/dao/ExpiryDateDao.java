package com.phan.market.dao;

import com.phan.market.entity.Employee;
import com.phan.market.entity.ExpiryDate;
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
                ExpiryDate expiryDate = new ExpiryDate(resultSet.getInt(1),resultSet.getString(2),
                        resultSet.getString(3),resultSet.getString(4),resultSet.getInt(5),
                        resultSet.getFloat(6));
                return expiryDate;
            }
        });
        return expiryDateList;
    }
}
