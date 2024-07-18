package com.example.demo.Controller;

import com.example.demo.Model.BaseClass;
import com.example.demo.Service.Interface.BaseClassService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

//import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
public class BaseClassController {
    @Autowired
    private BaseClassService baseClassService;

    @PostMapping(path = "/baseClass")
    public ResponseEntity<String> addBaseClassStudent(@Valid @RequestBody BaseClass baseClass){
        baseClassService.addBaseClassStudent(baseClass);
        return ResponseEntity.ok("baseClass added successfully");
    }

    @GetMapping(path = "/baseClasses")
    public List<BaseClass> getAllBaseClass(){
        return baseClassService.getAllBaseClass();

    }

    @PutMapping(path = "/baseClass/update/{id}")
    public void updateBaseClass(@Valid @PathVariable long id, @RequestBody BaseClass updatedBaseClass) {
        baseClassService.updateBaseClass(id, updatedBaseClass);
    }
}
