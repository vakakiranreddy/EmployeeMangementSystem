package com.example.employeemanagement.service;

import com.example.employeemanagement.model.Employee;
import com.example.employeemanagement.repository.EmployeeJpaRepository;
import com.example.employeemanagement.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService implements EmployeeRepository {
    @Autowired
    private EmployeeJpaRepository employeeJpaRepository;
    @Override
    public List<Employee> getAllEmployees() {
        return employeeJpaRepository.findAll();
    }
    @Override
    public Employee getEmployeeById(int id) {
        return employeeJpaRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found with ID: " + id));
    }
    @Override
    public Employee addEmployee(Employee employee) {
        return employeeJpaRepository.save(employee);
    }
    @Override
    public Employee updateEmployee(int id, Employee employee) {
        Employee existingEmployee = employeeJpaRepository.findById(id).orElse(null);
        if (existingEmployee != null) {
            existingEmployee.setName(employee.getName());
            existingEmployee.setDomain(employee.getDomain());
            existingEmployee.setRole(employee.getRole());
            existingEmployee.setExperience(employee.getExperience());
            existingEmployee.setSalary(employee.getSalary());
            return employeeJpaRepository.save(existingEmployee);
        }
        return null;
    }
    @Override
    public void deleteEmployee(int id) {
        employeeJpaRepository.deleteById(id);
    }
    @Override
    public List<Employee> getEmployeesByDomain(String domain) {
        return employeeJpaRepository.findByDomain(domain);
    }
    @Override
    public List<Employee> getEmployeesByRole(String role) {
        return employeeJpaRepository.findByRole(role);
    }
    @Override
    public List<Employee> getEmployeesByExperience(int experience) {
        return employeeJpaRepository.findByExperience(experience);
    }
}
