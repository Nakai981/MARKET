package com.phan.market.dao;

import com.phan.market.entity.Employee;
import com.phan.market.entity.ImpCouponDetail;
import com.phan.market.entity.ImportCoupon;
import com.phan.market.entity.Item;
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
    public List<ImportCoupon> selectCouponBySearch(String name){
        List<ImportCoupon> importCouponList;
        String query = "SELECT * FROM NHA_CUNG_CAP WHERE MA_CUNG_CAP='"+name+"'";

        importCouponList = this.jdbcTemplate.query(query, new RowMapper<ImportCoupon>() {
            @Override
            public ImportCoupon mapRow(ResultSet resultSet, int i) throws SQLException {
                ImportCoupon importCoupon = new ImportCoupon();
                importCoupon.setId(resultSet.getInt(1));
                importCoupon.setNameSupplier(resultSet.getString(2));
                return importCoupon;
            }
        });
        return importCouponList;
    }
    public int addItem(final Item i){
        String query = "INSERT INTO MAT_HANG VALUES (N'"+i.getName()+"',N'"+i.getUnit()+"',1)";
        return this.jdbcTemplate.update(query);
    }

    public List<ImportCoupon> importCouponList(){
        List<ImportCoupon> importCouponList;
        String query = "SELECT PNH.MA_PHIEU,PNH.NGAY_NHAP,NHAN_VIEN.TEN_NV FROM PHIEU_NHAP_HANG PNH\n" +
                "INNER JOIN NHAN_VIEN ON NHAN_VIEN.MA_NV=PNH.MA_NV WHERE PNH.ENABLE=1 ORDER BY PNH.MA_PHIEU DESC";

        importCouponList = this.jdbcTemplate.query(query, new RowMapper<ImportCoupon>() {
            @Override
            public ImportCoupon mapRow(ResultSet resultSet, int i) throws SQLException {
                ImportCoupon importCoupon = new ImportCoupon();
                importCoupon.setId(resultSet.getInt(1));
                importCoupon.setDate(resultSet.getString(2));
                importCoupon.setNameEmployee(resultSet.getString(3));
                return importCoupon;
            }
        });
        return importCouponList;
    }
    public List<ImpCouponDetail> importDetailCouponList(int id){
        List<ImpCouponDetail> importCouponList;
        String query = "EXEC DS_CHI_TIET_PHIEU_NHAP @id="+id;

        importCouponList = this.jdbcTemplate.query(query, new RowMapper<ImpCouponDetail>() {
            @Override
            public ImpCouponDetail mapRow(ResultSet resultSet, int i) throws SQLException {
                ImpCouponDetail importCoupon = new ImpCouponDetail(resultSet.getInt(1),
                        resultSet.getInt(2),resultSet.getInt(3),resultSet.getFloat(4),
                        resultSet.getString(5),resultSet.getString(6),resultSet.getInt(7),
                        resultSet.getString(8)
                        );

                return importCoupon;
            }
        });
        return importCouponList;
    }
    public int addCoupon(int id){
        String query = " INSERT INTO PHIEU_NHAP_HANG(ENABLE,MA_NV) VALUES (1,"+id+")";
        return this.jdbcTemplate.update(query);
    }
    public int delCoupon(int id){
        String query = " UPDATE  PHIEU_NHAP_HANG SET ENABLE=0 WHERE MA_PHIEU="+id;
        return this.jdbcTemplate.update(query);
    }
    public int addDetailCoupon(ImpCouponDetail imp){
        String query = " INSERT INTO CHI_TIET_PHIEU_NHAP VALUES ('"+imp.getCount()+"',"+imp.getPrice()+","+imp.getIdCoupon()+","+imp.getIdSupplier()+",'"+imp.getIdShipment()+"')";
        return this.jdbcTemplate.update(query);
    }
    public int updateDetailCoupon(ImpCouponDetail imp){
        String query = "UPDATE CHI_TIET_PHIEU_NHAP SET SL_NHAP="+imp.getCount()+",GIA_NHAP="+imp.getPrice()+",MA_CUNG_CAP="+imp.getIdSupplier()+",MA_LO='"+imp.getIdShipment()+"' WHERE MA_CT_PHIEU="+imp.getId();
        return this.jdbcTemplate.update(query);
    }
    public int delDetailCoupon(int id){
        String query = "DELETE FROM CHI_TIET_PHIEU_NHAP WHERE MA_CT_PHIEU="+id;
        return this.jdbcTemplate.update(query);
    }
}
