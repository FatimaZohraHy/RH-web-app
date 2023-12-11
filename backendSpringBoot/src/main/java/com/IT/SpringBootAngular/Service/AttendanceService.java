package com.IT.SpringBootAngular.Service;

import com.IT.SpringBootAngular.Entitys.Attendance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import  com.IT.SpringBootAngular.Repo.AttendanceRepo;

import java.util.List;
import java.util.Optional;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepo attendanceRepo;

    public List<Attendance> getAllAttendances() {
        return attendanceRepo.findAll();
    }

    public Optional<Attendance> getAttendanceById(String id) {
        return attendanceRepo.findById(id);
    }

    public List<Attendance> getAttendancesByEmployeeId(String employeeId) {
        return attendanceRepo.findByEmployeeId(employeeId);
    }

    public Attendance saveAttendance(Attendance attendance) {
        return attendanceRepo.save(attendance);
    }

    public void deleteAttendance(String id) {
        attendanceRepo.deleteById(id);
    }
}
