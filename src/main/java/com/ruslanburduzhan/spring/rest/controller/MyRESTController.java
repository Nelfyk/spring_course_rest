package com.ruslanburduzhan.spring.rest.controller;

import com.ruslanburduzhan.spring.rest.entity.Employee;
import com.ruslanburduzhan.spring.rest.exception_handling.NoSuchEmployeeException;
import com.ruslanburduzhan.spring.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {
        Employee employee = employeeService.getEmployee(id);
        if (employee == null) {
            throw new NoSuchEmployeeException("There is no employee with id = " + id + " in Database");
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id){
        if(employeeService.getEmployee(id)==null){
            throw new NoSuchEmployeeException("There is no Employee with ID = "+id);
        }
        return "Employee with ID = \"+id+\" was deleted.";
    }
}
