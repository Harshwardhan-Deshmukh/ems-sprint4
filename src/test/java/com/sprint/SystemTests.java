package com.sprint;

import com.sprint.entity.Employee;
import com.sprint.entity.Timesheet;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;

public class SystemTests {

    @Autowired
    private Employee employee;

    @Autowired
    private Timesheet timesheet;

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
    @DisplayName("Employee CRUD Test")
    public void testEmployeeCreateReadDeleteOperation() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8082/employees";



        ResponseEntity<Employee> entity = restTemplate.postForEntity(url, employee, Employee.class);

        Employee[] employees = restTemplate.getForObject(url, Employee[].class);
        Assertions.assertThat(employees).extracting(Employee::getEmpName).contains("Virat Kohli");
        int size = restTemplate.getForObject(url, Employee[].class).length;
        restTemplate.delete(url + "/" + entity.getBody().getEmpId());
        Assertions.assertThat(restTemplate.getForObject(url, Employee[].class).length == --size);
    }

}
