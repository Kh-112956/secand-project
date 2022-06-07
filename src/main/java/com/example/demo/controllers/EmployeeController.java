package com.example.demo.controllers;

import com.example.demo.entites.Employee;
import com.example.demo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/employee")
public class EmployeeController {
    private EmployeeService employeeService;
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService=employeeService;
    }
    @GetMapping
    public List<Employee> getEmployee() {
        return employeeService.getEmployees ();
    }
    @GetMapping(path = "{employeeId}")
    public Optional<Employee>getEmployees(@PathVariable(name="employeeId")Integer emloyeeId) {
        return employeeService.getEmployee(emloyeeId);
    }
    @PostMapping(path="add")
    public void
    registerNewEmployee(@RequestBody Employee employee) {
        System.out.println(employee.toString());
        employeeService.addEmployee(employee);
    }
    @DeleteMapping(path = "delete/{employeeId}")
    public void
    deleteEmployee(@PathVariable("employeeId")Integer employeeId){
        employeeService.deleteEmployee(employeeId);
    }
}
