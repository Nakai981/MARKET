package com.phan.market.dao;

import com.phan.market.entity.Employee;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EmployeeDao {
    private final int page = 3;
    private JdbcTemplate jdbcTemplate;

    public EmployeeDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Hien thi nhan vien
    public List<Employee> employeeList() {
        List<Employee> employeeList;
        String query = "SELECT * FROM NHAN_VIEN WHERE ENABLE =1 ORDER BY NHAN_VIEN.MA_NV DESC;";

        employeeList = this.jdbcTemplate.query(query, new RowMapper<Employee>() {
            @Override
            public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
                Employee emp = new Employee(resultSet.getInt(1),resultSet.getString(2),
                        resultSet.getInt(3),resultSet.getLong(4),resultSet.getLong(5),
                        resultSet.getString(6),resultSet.getString(7),resultSet.getString(8),
                        resultSet.getInt(10)
                );
                return emp;
            }
        });
        return employeeList;
    }

    public int addEmployee(final Employee e){
        String query = "INSERT INTO NHAN_VIEN VALUES (N'"+e.getName()+"',"+e.getGender()+","+e.getCard()+","+e.getPhone()+",N'"+e.getAddress()+"','"+e.getUser()+"','{noop}"+e.getPass()+"',1,"+e.getIdPosition()+")";
        return this.jdbcTemplate.update(query);
    }
    public Boolean deleteEmployee(final int id){
        String query = "UPDATE NHAN_VIEN SET ENABLE = 0 WHERE MA_NV = ?";
        return this.jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {
            @Override
            public Boolean doInPreparedStatement(PreparedStatement preparedStatement) throws SQLException, DataAccessException {
                preparedStatement.setInt(1,id);
                return preparedStatement.execute();
            }
        });
    }
    public Boolean updateEmployee(final Employee e){
        String query = "UPDATE NHAN_VIEN SET TEN_NV=?,GIOI_TINH=?,CMND=?,SDT=?,DIACHI=?,TEN_DANG_NHAP=?,MAT_KHAU=? WHERE NHAN_VIEN.MA_NV = ?;";
        return this.jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {
            @Override
            public Boolean doInPreparedStatement(PreparedStatement preparedStatement) throws SQLException, DataAccessException {
                preparedStatement.setString(1,e.getName());
                preparedStatement.setInt(2,e.getGender());
                preparedStatement.setLong(3,e.getCard());
                preparedStatement.setLong(4,e.getPhone());
                preparedStatement.setString(5,e.getAddress());
                preparedStatement.setString(6,e.getUser());
                preparedStatement.setString(7,e.getPass());
                preparedStatement.setInt(8,e.getId());
                return preparedStatement.execute();
            }
        });
    }

}
