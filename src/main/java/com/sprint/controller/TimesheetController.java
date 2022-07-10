package com.sprint.controller;

import com.sprint.entity.Employee;
import com.sprint.entity.Timesheet;
import com.sprint.repository.EmployeeRepository;
import com.sprint.service.EmployeeService;
import com.sprint.service.TimesheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.util.List;

@RestController
public class TimesheetController {

    @Autowired
    private TimesheetService timesheetService;

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("timesheet")
    public Timesheet addTimesheet(@RequestParam(value = "empId") Long empId, @RequestBody Timesheet timesheet) {
        timesheet.setEmployee(employeeRepository.findById(empId).get());
        return timesheetService.addTimesheet(timesheet);
    }

    @GetMapping("/timesheet")
    public List<Timesheet> listAllTimesheet() {
        return timesheetService.listTimesheet();
    }

    @GetMapping("/timesheet/{id}")
    public Timesheet fetchTimesheetById(@PathVariable("id") Long timesheetId) {
        return timesheetService.fetchTimesheetById(timesheetId);
    }

    @PutMapping("/timsheet/update")
    Timesheet updateTimesheet(@RequestParam(value = "empID") Long empId,@RequestBody Timesheet timesheet)  {
        timesheet.setEmployee(employeeRepository.findById(empId).get());
        return timesheetService.updateTimesheet(timesheet);
    }

}
