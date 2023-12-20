package com.IT.SpringBootAngular.Service;

import com.IT.SpringBootAngular.Entitys.*;
import com.IT.SpringBootAngular.Repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HRadminService {
    @Autowired
    private HRadminRepo hrAdminRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ReclamationRepo reclamationRepo;
    @Autowired
    private SalaireRepo salairerepo;
    @Autowired
    private DepartementRepo departementRepo;
    @Autowired
    private EmployeeRepo employeeRepo;




    public HRadmin getAdminById(String id){
        return hrAdminRepo.findById(id).orElse(null);
    }
    public String deleteAdmin(String id){
        HRadmin hRadmin = hrAdminRepo.findById(id).orElse(null);
        if(hRadmin==null)
            return "admin not found";
        return null;
    }




    public HRadmin saveHRAdmin(HRadmin hradmin) {
        User saveUser = userRepo.save(hradmin.getUser());
        hradmin.setUser(saveUser);
        return hrAdminRepo.save(hradmin);
    }

    public void deleteHRAdmin(String id) {
        hrAdminRepo.deleteById(id);
    }

















    public String saveEmployee(String admin_id , Employee employee){
        HRadmin hRadmin = hrAdminRepo.findById(admin_id).orElse(null);
        Departement departement = employee.getDepartement();
        if(hRadmin != null) {
            User saveUser = userRepo.save(employee.getUser());
            Salaire saveSalire = salairerepo.save(employee.getSalaire());


            employee.setUser(saveUser);
            employee.setSalaire(saveSalire);
            employee.setDepartement(departement);
            employee.setAdmin(hRadmin);
            departement.addEmployee(employee);
            hRadmin.addEmployee(employee);
            departementRepo.save(departement);
            hrAdminRepo.save(hRadmin);
            employeeRepo.save(employee);

            return employee.get_id();
        }else{
            return "admin not found";
        }


    }
    public List<Employee> getAllEmployees(String id){
        HRadmin hRadmin = hrAdminRepo.findById(id).orElse(null);
        if(hRadmin==null)
            return null;
        return hRadmin.getEmployees();
    }

    public String editEmpoloyee(String Aid ,String Eid, Employee updatedemployee){
        Employee employee = employeeRepo.findById(Eid).orElse(null);
        if(employee==null)
            return "employee not found";
        HRadmin admin = hrAdminRepo.findById(Aid).orElse(null);
        if(admin==null)
            return "admin not found";

        updatedemployee.setAdmin(admin);
        updatedemployee.setSalaire(employee.getSalaire());
        updatedemployee.setUser(employee.getUser());
        updatedemployee.setReclamation(employee.getReclamation());
        updatedemployee.setDepartement(employee.getDepartement());

        employeeRepo.save(updatedemployee);
        return updatedemployee.get_id() + "updated";

    }

}

