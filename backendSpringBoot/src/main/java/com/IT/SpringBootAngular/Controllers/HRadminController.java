package com.IT.SpringBootAngular.Controllers;

import com.IT.SpringBootAngular.Entitys.Employee;
import com.IT.SpringBootAngular.Entitys.HRadmin;
import com.IT.SpringBootAngular.Service.EmpService;
import com.IT.SpringBootAngular.Service.HRadminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class HRadminController {

    @Autowired
    private HRadminService hrAdminService;
    @Autowired
    private EmpService employeeService;
    @GetMapping
    public List<HRadmin> getAllHRAdmins() {
        return hrAdminService.getAllHRAdmins();
    }

    @GetMapping("/getAll{id}")
    public Optional<HRadmin> getHRAdminById(@PathVariable String id) {
        return hrAdminService.getHRAdminById(id);
    }

    @PostMapping("/saveAdmin")
    public HRadmin saveHRAdmin(@RequestBody HRadmin hradmin) {
        return hrAdminService.saveHRAdmin(hradmin);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteHRAdmin(@PathVariable String id) {
        hrAdminService.deleteHRAdmin(id);
    }



    //employee manage

    @PostMapping(value = "/employee/save")
    public String saveEmployee(@RequestBody Employee emp){
        employeeService.save_update(emp);
        return emp.get_id();
    }

    @GetMapping(value="/employee/getAll")
    public Iterable<Employee> getEmployee(){
        return employeeService.getAll();
    }


    @PutMapping(value ="/employee/edit/{id}")
    private Employee updateEmployee(@RequestBody Employee employee ,  @PathVariable(name="id")String _id){
        employee.set_id(_id);
        employeeService.save_update(employee);return employee;
    }


    @DeleteMapping("/employee/delete/{id}")
    private void deleteEmployee(@PathVariable(name="id")String _id){
        employeeService.delete(_id);
    }
    @RequestMapping("/employee/getOne/{id}")
    private Employee getEmployeeById(@PathVariable(name="id")String _id){
        return employeeService.getById(_id);
    }


    //reclamations Part :

}

