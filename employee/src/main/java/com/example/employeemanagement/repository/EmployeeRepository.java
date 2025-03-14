package com.example.employeemanagement.repository;

import com.example.employeemanagement.model.Employee;
import java.util.List;

public interface EmployeeRepository {
    List<Employee> getAllEmployees();
    Employee getEmployeeById(int id);
    Employee addEmployee(Employee employee);
    Employee updateEmployee(int id, Employee employee);
    void deleteEmployee(int id);
    List<Employee> getEmployeesByDomain(String domain);
    List<Employee> getEmployeesByRole(String role);
    List<Employee> getEmployeesByExperience(int experience);
}