package com.IT.SpringBootAngular.Service;

import com.IT.SpringBootAngular.Entitys.HRadmin;
import com.IT.SpringBootAngular.Repo.HRadminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HRadminService {
    @Autowired
    private HRadminRepo hrAdminRepo;


    public List<HRadmin> getAllHRAdmins() {
        return hrAdminRepo.findAll();
    }

    public Optional<HRadmin> getHRAdminById(String id) {
        return hrAdminRepo.findById(id);
    }

    public HRadmin saveHRAdmin(HRadmin hradmin) {
        return hrAdminRepo.save(hradmin);
    }

    public void deleteHRAdmin(String id) {
        hrAdminRepo.deleteById(id);
    }
}

