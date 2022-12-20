package com.ruslanburduzhan.spring.rest.dao;

import com.ruslanburduzhan.spring.rest.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> getAllEmployees();

    void saveEmployee(Employee employee);

    Employee getEmployee(int id);

    void deleteEmployee(int id);
}
