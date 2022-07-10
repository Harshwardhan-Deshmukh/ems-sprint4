package com.sprint.service;

import com.sprint.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);

    List<Employee> fetchEmployeeList();

    Employee fetchEmployeeById(Long employeeId);

    Employee fetchEmployeeByName(String employeeName);

    void deleteEmployeeById(Long empId);

    Employee updateEmployeeRecordById(Long employeeId, Employee employee);
}
