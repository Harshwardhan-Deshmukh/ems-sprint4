package com.sprint.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {

    @Id
    @SequenceGenerator(
            name = "employee_sequence",
            sequenceName = "employee_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "employee_sequence"
    )
    private Long empId;

    @Column(name = "empName")
    @NotBlank(message = "Employee name can't be blank")
    private String empName;
    @Column(name = "empContact")
    private String empContact;
    @Column(name = "empDepartment")
    private String empDepartment;
    @Column(name = "empEmail")
    private String empEmail;
    @Column(name = "empRole")
    private String empRole;

}
