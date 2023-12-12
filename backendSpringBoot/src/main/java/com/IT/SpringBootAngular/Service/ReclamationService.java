package com.IT.SpringBootAngular.Service;

import com.IT.SpringBootAngular.Entitys.Reclamation;
import com.IT.SpringBootAngular.Repo.ReclamationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.concurrent.RecursiveAction;

@Service
public class ReclamationService {
    @Autowired
    private ReclamationRepo reclamationRepo;

    public List<Reclamation> getAllReclamations(){
        return reclamationRepo.findAll();
    }
    public Reclamation getReclamationById(String id){
        return reclamationRepo.findById(id).orElse(null);
    }
    public Reclamation saveReclamation(Reclamation reclamation){
        return reclamationRepo.save(reclamation);
    }
    public Reclamation updateReclamation(String id , RecursiveAction updatedReclamation ){
        return null;
    }
    public void deleteReclamation(String id){
        reclamationRepo.deleteById(id);
    }
}
