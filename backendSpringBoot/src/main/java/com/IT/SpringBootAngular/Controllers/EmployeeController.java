package com.IT.SpringBootAngular.Controllers;

import com.IT.SpringBootAngular.Entitys.Employee;
import com.IT.SpringBootAngular.Service.EmpService;
import com.IT.SpringBootAngular.Service.SalireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*") //frontend connection
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmpService employeeService;


    @PostMapping(value = "/save")
    public String saveEmployee(@RequestBody Employee emp){
        employeeService.save_update(emp);
        return emp.get_id();
    }

    @GetMapping(value="/getAll")
    public Iterable<Employee> getEmployee(){
        return employeeService.getAll();
    }


    @PutMapping(value ="/edit/{id}")
    private Employee updateEmployee(@RequestBody Employee employee ,  @PathVariable(name="id")String _id){
        employee.set_id(_id);
        employeeService.save_update(employee);return employee;
    }


    @DeleteMapping("/delete/{id}")
    private void deleteEmployee(@PathVariable(name="id")String _id){
        employeeService.delete(_id);
    }
    @RequestMapping("/employee/{id}")
    private Employee getEmployeeById(@PathVariable(name="id")String _id){
        return employeeService.getById(_id);
    }

}
