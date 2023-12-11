package com.IT.SpringBootAngular.Controllers;

import com.IT.SpringBootAngular.Entitys.Attendance;
import com.IT.SpringBootAngular.Service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/attendances")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @GetMapping
    public List<Attendance> getAllAttendances() {
        return attendanceService.getAllAttendances();
    }

    @GetMapping("/{id}")
    public Optional<Attendance> getAttendanceById(@PathVariable String id) {
        return attendanceService.getAttendanceById(id);
    }

    @GetMapping("/employee/{employeeId}")
    public List<Attendance> getAttendancesByEmployeeId(@PathVariable String employeeId) {
        return attendanceService.getAttendancesByEmployeeId(employeeId);
    }

    @PostMapping
    public Attendance saveAttendance(@RequestBody Attendance attendance) {
        return attendanceService.saveAttendance(attendance);
    }

    @DeleteMapping("/{id}")
    public void deleteAttendance(@PathVariable String id) {
        attendanceService.deleteAttendance(id);
    }
}
