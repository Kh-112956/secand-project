package com.example.demo.services;

import com.example.demo.entites.Employee;
import com.example.demo.repositories.EmoloyeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EmployeeService {
    private EmoloyeeRepository employeeRepository;
    @Autowired

    public EmployeeService(EmoloyeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }
    public Optional<Employee> getEmployee(Integer employeeId) {
        return employeeRepository.findById(employeeId);
    }
    public void addEmployee(Employee employee) {employeeRepository.save(employee);}
    public void deleteEmployee(Integer employeeId) {employeeRepository.deleteById(employeeId);}
}