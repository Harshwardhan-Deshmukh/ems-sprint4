package com.sprint.service;

import com.sprint.entity.Employee;
import com.sprint.error.EmployeeNotFoundException;
import com.sprint.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> fetchEmployeeList() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee fetchEmployeeById(Long id) throws EmployeeNotFoundException {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isEmpty()) {
            throw new EmployeeNotFoundException("Employee Not found");
        }
        return employee.get();
    }

    @Override
    public Employee fetchEmployeeByName(String employeeName) {
        return employeeRepository.findByEmpNameIgnoreCase(employeeName);
    }

    @Override
    public void deleteEmployeeById(Long empId) throws EmployeeNotFoundException {
        Optional<Employee> employee = employeeRepository.findById(empId);
        if (employee.isEmpty()) {
            throw new EmployeeNotFoundException("Employee Not found");
        }
        employeeRepository.deleteById(empId);
    }

    @Override
    public Employee updateEmployeeRecordById(Long employeeId, Employee employee) {
        Employee employeeFromDb = employeeRepository.findById(employeeId).get();
        employeeFromDb.setEmpName(employee.getEmpName());
        employeeFromDb.setEmpContact(employee.getEmpContact());
        employeeFromDb.setEmpDepartment(employee.getEmpDepartment());
        employeeFromDb.setEmpRole(employee.getEmpRole());
        employeeFromDb.setEmpEmail(employee.getEmpEmail());

        return employeeRepository.save(employee);
    }
}
