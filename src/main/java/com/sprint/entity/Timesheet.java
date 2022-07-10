package com.sprint.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "timesheet")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Timesheet {
    @Id
    @SequenceGenerator(
            name = "timesheet_sequence",
            sequenceName = "timesheet_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "timesheet_sequence"
    )
    private Long timesheetId;
    @Column(name = "empName")
    private String empName;
    @Column(name = "hours")
    private int timeTotalHours;
    @Column(name = "date")
    private String timeDate;
    @Column(name = "task")
    private String timeTask;
    @Column(name = "description")
    private String timeDescription;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "employee_id",
            referencedColumnName = "empId"
    )
    private Employee employee;

}
