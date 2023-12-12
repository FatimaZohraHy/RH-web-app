package com.IT.SpringBootAngular.Controllers;

import com.IT.SpringBootAngular.Entitys.Reclamation;
import com.IT.SpringBootAngular.Service.ReclamationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.RecursiveAction;

@RestController
@RequestMapping("reclamations")
public class ReclamationController {
    @Autowired
    private ReclamationService reclamationService;
    @GetMapping("/getAll")
    public List<Reclamation> getAllReclamations(){
        return reclamationService.getAllReclamations();
    }
    @GetMapping("/get/{id}")
    public Reclamation getReclamationByTd(@PathVariable String id){
        return reclamationService.getReclamationById(id);
    }
    @PostMapping("/add")
    public Reclamation saveReclamation(@RequestBody Reclamation reclamation){
        return reclamationService.saveReclamation(reclamation);
    }
    @PutMapping("/update/{id}")
    public Reclamation updateReclamation(@PathVariable String id , @RequestBody RecursiveAction updatedreclamation){
        return reclamationService.updateReclamation(id,updatedreclamation);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteReclamation(@PathVariable String id ){
        reclamationService.deleteReclamation(id);
    }
}
