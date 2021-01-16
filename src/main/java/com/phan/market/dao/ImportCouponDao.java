package com.phan.market.dao;

import com.phan.market.entity.Employee;
import com.phan.market.entity.ImportCoupon;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ImportCouponDao {
    private JdbcTemplate jdbcTemplate;

    public ImportCouponDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<ImportCoupon> importCouponDaoList(){
        List<ImportCoupon> importCouponList;
        String query = "SELECT * FROM THONG_TIN_PHIEU_NHAP_HANG";

        importCouponList = this.jdbcTemplate.query(query, new RowMapper<ImportCoupon>() {
            @Override
            public ImportCoupon mapRow(ResultSet resultSet, int i) throws SQLException {
                ImportCoupon importCoupon = new ImportCoupon(resultSet.getInt(1),
                        resultSet.getString(2),resultSet.getString(3),
                        resultSet.getString(4),resultSet.getInt(5),resultSet.getFloat(6));
                return importCoupon;
            }
        });
        return importCouponList;
    }
}
