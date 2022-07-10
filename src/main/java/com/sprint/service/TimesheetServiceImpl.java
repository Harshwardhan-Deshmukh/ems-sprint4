package com.sprint.service;

import com.sprint.entity.Timesheet;
import com.sprint.repository.TimesheetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimesheetServiceImpl implements TimesheetService {

    @Autowired
    private TimesheetRepository timesheetRepository;

    @Override
    public Timesheet addTimesheet(Timesheet timesheet) {
        return timesheetRepository.save(timesheet);
    }

    @Override
    public List<Timesheet> listTimesheet() {
        return timesheetRepository.findAll();
    }

    @Override
    public Timesheet fetchTimesheetById(Long timesheetId) {
        return timesheetRepository.findById(timesheetId).get();
    }

    @Override
    public Timesheet updateTimesheet(Timesheet timesheet) {
        Timesheet timesheetDb = timesheetRepository.findById(timesheet.getTimesheetId()).get();

        timesheetDb.setEmployee(timesheet.getEmployee());
        timesheetDb.setEmpName(timesheet.getEmpName());
        timesheetDb.setTimeDate(timesheet.getTimeDate());
        timesheetDb.setTimeDescription(timesheet.getTimeDescription());
        timesheetDb.setTimeTask(timesheet.getTimeTask());

        return timesheetRepository.save(timesheet);
    }


}
