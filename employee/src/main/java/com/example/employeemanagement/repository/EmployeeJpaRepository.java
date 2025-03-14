package com.example.employeemanagement.repository;

import com.example.employeemanagement.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EmployeeJpaRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findByDomain(String domain);
    List<Employee> findByRole(String role);
    List<Employee> findByExperience(int experience);
}
