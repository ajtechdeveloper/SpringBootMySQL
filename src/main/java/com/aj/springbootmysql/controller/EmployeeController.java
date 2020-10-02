package com.aj.springbootmysql.controller;

import com.aj.springbootmysql.domain.Employee;
import com.aj.springbootmysql.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
	public ResponseEntity<Iterable<Employee>> getAllEmployees() {
        logger.info("In EmployeeController.getAllEmployees");
        Iterable<Employee> employees = employeeService.findAll();
        return new ResponseEntity<>(employees, HttpStatus.OK);
	}

    @GetMapping("/{name}")
    public ResponseEntity<Iterable<Employee>> findByName(@PathVariable String name) {
        logger.info("Name in EmployeeController.findByName is: {}", name);
        List<Employee> employees = employeeService.findByName(name);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> addEmployee(@RequestBody Employee employeeRequest) {
        logger.info("Request received in EmployeeController.addEmployee is: {}", employeeRequest.toString());
        Map<String, String> response = new HashMap<>();
        employeeService.save(employeeRequest);
        response.put("message", "Employee saved successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Map<String, String>> updateEmployee(@RequestBody Employee employeeRequest) {
        logger.info("Request received in EmployeeController.updateEmployee is: {}", employeeRequest.toString());
        Map<String, String> response = new HashMap<>();
        int rowsUpdated = employeeService.updateEmployee(employeeRequest);
        if(rowsUpdated > 0) {
            response.put("message", "Employee updated successfully");
        }
        else{
            response.put("message", "Employee not updated");
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteEmployee(@PathVariable Integer id) {
        logger.info("ID in EmployeeController.deleteEmployee is: {}", id.toString());
        Map<String, String> response = new HashMap<>();
        employeeService.delete(id);
        response.put("message", "Employee deleted successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
