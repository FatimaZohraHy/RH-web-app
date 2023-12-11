package com.IT.SpringBootAngular.Controllers;

import com.IT.SpringBootAngular.Entitys.HRadmin;
import com.IT.SpringBootAngular.Service.HRadminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hradmins")
public class HRadminController {

    @Autowired
    private HRadminService hrAdminService;

    @GetMapping
    public List<HRadmin> getAllHRAdmins() {
        return hrAdminService.getAllHRAdmins();
    }

    @GetMapping("/{id}")
    public Optional<HRadmin> getHRAdminById(@PathVariable String id) {
        return hrAdminService.getHRAdminById(id);
    }

    @PostMapping
    public HRadmin saveHRAdmin(@RequestBody HRadmin hradmin) {
        return hrAdminService.saveHRAdmin(hradmin);
    }

    @DeleteMapping("/{id}")
    public void deleteHRAdmin(@PathVariable String id) {
        hrAdminService.deleteHRAdmin(id);
    }
}
