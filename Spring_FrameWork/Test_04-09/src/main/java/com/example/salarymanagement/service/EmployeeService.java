package com.example.salarymanagement.service;

import com.example.salarymanagement.model.Employee;
import com.example.salarymanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public String saveEmployee(Employee employee) {
        if (repository.findByName(employee.getName()).isPresent() && employee.getId() == null) {
            return "Error: User with name " + employee.getName() + " already exists!";
        }
        repository.save(employee);
        return "User saved successfully!";
    }

    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }

    public Employee getEmployeeById(Long id) {
        return repository.findById(id).orElse(null);
    }
}