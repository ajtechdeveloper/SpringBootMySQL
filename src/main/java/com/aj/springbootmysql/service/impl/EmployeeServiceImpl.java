package com.aj.springbootmysql.service.impl;

import com.aj.springbootmysql.domain.Employee;
import com.aj.springbootmysql.repository.EmployeeRepository;
import com.aj.springbootmysql.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    public void save(Employee employeeRequest) {
        logger.info("Entering EmployeeServiceImpl.save Method with Employee Details: {}", employeeRequest.toString());
        Employee employee = new Employee();
        employee.setName(employeeRequest.getName());
        employee.setDepartment(employeeRequest.getDepartment());
        employee.setSalary(employeeRequest.getSalary());
        employeeRepository.save(employee);
        logger.info("Leaving EmployeeServiceImpl.save Method");
    }

    public Iterable<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public List<Employee> findByName(String name) {
        return employeeRepository.findByName(name);
    }

    @Transactional
    public int updateEmployee(Employee employeeRequest) {
        logger.info("Entering EmployeeServiceImpl.updateEmployee Method with Employee Details: {}", employeeRequest.toString());
        return employeeRepository.updateEmployee(employeeRequest.getName(), employeeRequest.getDepartment(),
                employeeRequest.getSalary(), employeeRequest.getId());
    }

    public void delete(Integer id) {
        employeeRepository.delete(id);
    }
}
