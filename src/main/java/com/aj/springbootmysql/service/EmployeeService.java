package com.aj.springbootmysql.service;

import com.aj.springbootmysql.domain.Employee;

import java.util.List;

public interface EmployeeService {

    void save(Employee employee);
    Iterable<Employee> findAll();
    List<Employee> findByName(String name);
    int updateEmployee(Employee employeeRequest);
    void delete(Integer id);
}
