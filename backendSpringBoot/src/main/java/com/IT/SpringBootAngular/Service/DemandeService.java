package com.IT.SpringBootAngular.Service;

import com.IT.SpringBootAngular.Entitys.Demande;
import com.IT.SpringBootAngular.Entitys.Salaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.IT.SpringBootAngular.Repo.DemandeRepo;
@Service
public class DemandeService {
    @Autowired
    private DemandeRepo demandeRepo;
    public void save_demane(Demande demande){demandeRepo.save(demande);}
    public Iterable<Demande> getAll(){
        return this.demandeRepo.findAll();
    }
    public void delete(String id){
        demandeRepo.deleteById(id);
    }
    public Demande getById(String id){
        return demandeRepo.findById(id).get();
    }
}