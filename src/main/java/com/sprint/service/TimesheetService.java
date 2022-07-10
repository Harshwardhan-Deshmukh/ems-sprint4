package com.sprint.service;

import com.sprint.entity.Timesheet;

import java.util.List;

public interface TimesheetService {
    Timesheet addTimesheet(Timesheet timesheet);

    List<Timesheet> listTimesheet();

    Timesheet fetchTimesheetById(Long timesheetId);


    Timesheet updateTimesheet(Timesheet timesheet);
}
