package com.sprint.repository;

import com.sprint.entity.Employee;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class JpaRepositoryTest {
    @Autowired
    EmployeeRepository empRepo;
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
    public void testEmpCreateReadDelete() {

        empRepo.save(employee);
        Iterable<Employee> employees = empRepo.findAll();
        Assertions.assertThat(employees).extracting(Employee::getEmpName).contains("Harshwardhan");

        empRepo.deleteAll();
        Assertions.assertThat(empRepo.findAll()).isEmpty();
    }
}
