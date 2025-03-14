package com.example.employeemanagement.controller;

import com.example.employeemanagement.model.Employee;
import com.example.employeemanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable("id") int id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable("id") int id, @RequestBody Employee employee) {
        return employeeService.updateEmployee(id, employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable("id") int id) {
        employeeService.deleteEmployee(id);
    }

    @GetMapping("/domain/{domain}")
    public List<Employee> getEmployeesByDomain(@PathVariable("domain") String domain) {
        return employeeService.getEmployeesByDomain(domain);
    }

    @GetMapping("/role/{role}")
    public List<Employee> getEmployeesByRole(@PathVariable("role") String role) {
        return employeeService.getEmployeesByRole(role);
    }

    @GetMapping("/experience/{experience}")
    public List<Employee> getEmployeesByExperience(@PathVariable("experience") int experience) {
        return employeeService.getEmployeesByExperience(experience);
    }
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleRuntimeException(RuntimeException ex) {
        return ex.getMessage();
    }
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)  // 400 Bad Request
    public String handleEmptyRequest(HttpMessageNotReadableException ex) {
        return "Request body is missing or invalid!";
    }

}
