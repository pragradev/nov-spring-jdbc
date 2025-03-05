package io.pragra.learning.novspringjdbc.dao;

import io.pragra.learning.novspringjdbc.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.print.DocFlavor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;
    // CRUD
    public List<Employee> getEmployees(){

        RowMapper<Employee> rm = new RowMapper<Employee>() {
            @Override
            public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
                Employee employee = new Employee();
                employee.setEmployeeId(rs.getString("EMPLOYEE_ID"));
                employee.setFirstName(rs.getString("FIRST_NAME"));
                employee.setLastName(rs.getString("LAST_NAME"));
                employee.setEmail(rs.getString("EMAIL_ID"));
                return employee;
            }
        };


        List<Employee> employeeList = jdbcTemplate.query("SELECT * FROM EMPLOYEE", rm);
        System.out.println(employeeList);
        return employeeList;
    }
}
