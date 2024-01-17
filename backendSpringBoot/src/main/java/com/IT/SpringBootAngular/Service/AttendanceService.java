package com.IT.SpringBootAngular.Service;

import com.IT.SpringBootAngular.Entitys.Attendance;
import com.IT.SpringBootAngular.Entitys.Employee;
import com.IT.SpringBootAngular.Entitys.Response;
import com.IT.SpringBootAngular.Repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.IT.SpringBootAngular.Repo.AttendanceRepo;

import java.util.List;
import java.util.Optional;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepo attendanceRepo;
    @Autowired
    private EmployeeRepo employeeRepo;

    public Response checkin(String id , Attendance attendance){
        attendanceRepo.save(attendance);
        Employee emp = employeeRepo.findById(id).orElse(null);
        if(emp !=null){
            emp.setAttendance(attendance);
            emp.setActive(true);
            employeeRepo.save(emp);
            return new Response("you are in");
        }
        return new Response("no employee");
    }
    public Response checkout(String id , Attendance attendance){
        attendanceRepo.save(attendance);
        Employee emp = employeeRepo.findById(id).orElse(null);
        if(emp!=null){
            emp.setAttendance(attendance);
            emp.setActive(false);
            employeeRepo.save(emp);
            return new Response("you are out");
        }
        return new Response("no employee");
    }
}
