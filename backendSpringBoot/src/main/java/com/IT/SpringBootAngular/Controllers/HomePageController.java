package com.IT.SpringBootAngular.Controllers;

import com.IT.SpringBootAngular.Entitys.HRadmin;
import com.IT.SpringBootAngular.Repo.HRadminRepo;
import com.IT.SpringBootAngular.Service.HRadminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/singup")
public class HomePageController {
    @Autowired
    private HRadminService hrAdminService;
    @PostMapping("/saveadmin")
    public HRadmin saveHRAdmin (@RequestBody HRadmin hradmin){
        return hrAdminService.saveHRAdmin(hradmin);
    }
    @DeleteMapping("/clear")
    public String clear(){
        return "everything is clear";
    }
}
