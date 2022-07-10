package com.sprint.service;

import com.sprint.entity.Employee;
import com.sprint.error.EmployeeNotFoundException;

import java.util.List;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);

    List<Employee> fetchEmployeeList();

    Employee fetchEmployeeById(Long employeeId) throws EmployeeNotFoundException;

    Employee fetchEmployeeByName(String employeeName);

    void deleteEmployeeById(Long empId) throws EmployeeNotFoundException;

    Employee updateEmployeeRecordById(Long employeeId, Employee employee);
}
