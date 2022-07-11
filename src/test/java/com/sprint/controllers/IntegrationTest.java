package com.sprint.controllers;

import com.sprint.controller.EmployeeController;
import com.sprint.entity.Employee;
import com.sprint.error.EmployeeNotFoundException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
public class IntegrationTest {
    @Autowired
    EmployeeController empController;

    private Employee employee;

    @BeforeEach
    void setup() {
        employee = Employee.builder()
                .empName("Harshwardhan")
                .empContact("9856748356")
                .empDepartment("SNINIDA")
                .empEmail("harsh@gmail.com")
                .empRole("ASDE")
                .build();
    }

    @Test
    public void testEmpCreateReadDelete() throws EmployeeNotFoundException {
        List<Employee> employees = empController.fetchEmployeeList();
        int size = employees.size();
        Employee empResult = empController.saveEmployee(employee);
        employees = empController.fetchEmployeeList();

        Assertions.assertThat(employees).last().hasFieldOrPropertyWithValue("empName", "Harshwardhan");
        Assertions.assertThat(empController.fetchEmployeeList().size() == ++size);
        empController.deleteEmployee(empResult.getEmpId());
    }
}