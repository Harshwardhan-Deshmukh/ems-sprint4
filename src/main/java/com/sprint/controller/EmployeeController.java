package com.sprint.controller;

import com.sprint.entity.Employee;
import com.sprint.error.EmployeeNotFoundException;
import com.sprint.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employees")
    public Employee saveEmployee(@Valid @RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/employees")
    public List<Employee> fetchEmployeeList() {
        return employeeService.fetchEmployeeList();
    }

    @GetMapping("/employee/{id}")
    public Employee fetchEmployeeById(@PathVariable("id") Long employeeId) throws EmployeeNotFoundException {
        return employeeService.fetchEmployeeById(employeeId);
    }

    @GetMapping("/employee/name/{name}")
    public Employee fetchEmployeeByName(@PathVariable("name") String employeeName) {
        return employeeService.fetchEmployeeByName(employeeName);
    }

    @DeleteMapping("/employees/{id}")
     public String deleteEmployee(@PathVariable("id") Long empId) throws EmployeeNotFoundException {
        employeeService.deleteEmployeeById(empId);
        return "Employee deleted successfully!";
    }

    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@RequestBody Employee employee, @PathVariable("id") Long employeeId) {
        return employeeService.updateEmployeeRecordById(employeeId, employee);
    }


}
