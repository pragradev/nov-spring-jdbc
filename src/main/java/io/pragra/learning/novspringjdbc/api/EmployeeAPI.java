package io.pragra.learning.novspringjdbc.api;

import io.pragra.learning.novspringjdbc.dao.EmployeeDAO;
import io.pragra.learning.novspringjdbc.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeAPI {
    @Autowired
    EmployeeDAO employeeDAO;

    @GetMapping("/getall")
    public List<Employee> getAllEmployee(){
        return employeeDAO.getEmployees();
    }
}
