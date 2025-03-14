package com.example.employeemanagement.model;
import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "domain", nullable = false)
    private String domain;

    @Column(name = "role", nullable = false)
    private String role;

    @Column(name = "experience")
    private int experience;

    @Column(name = "salary")
    private double salary;

   
    public Employee() {}

    
    public int getId(){ 
        return id; 
    }
    public void setId(int id) { 
        this.id = id; 
    }
    public String getName() { 
        return name; 
    }
    public void setName(String name) { 
        this.name = name; 
    }
    public String getDomain() { 
        return domain; 
    }
    public void setDomain(String domain) { 
        this.domain = domain; 
    }
    public String getRole() { 
        return role; 
    }
    public void setRole(String role) { 
        this.role = role; 
    }
    public int getExperience() { 
        return experience; 
    }
    public void setExperience(int experience) { 
        this.experience = experience; 
    }
    public double getSalary() { 
        return salary; 
    }
    public void setSalary(double salary) { 
        this.salary = salary; 
    }
}
