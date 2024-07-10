package com.example.demo.Service.Implements;

import com.example.demo.Model.BaseClass;
import com.example.demo.Repository.BaseClassRepo;
import com.example.demo.Service.Interface.BaseClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BaseClassServiceImpl implements BaseClassService {

    @Autowired
    private BaseClassRepo baseClassRepo;

    @Override
    public void addBaseClassStudent(BaseClass baseClass){
        baseClassRepo.save(baseClass);
    }

    @Override
    public List<BaseClass> getAllBaseClass(){
        return baseClassRepo.findAll();
    }

    public void updateBaseClass(long id, BaseClass updatedBaseClass) {
        Optional<BaseClass> baseClass= baseClassRepo.findById(id);
        if(baseClass.isPresent()){
            BaseClass existingBaseClass = baseClass.get();
            existingBaseClass.setClassName(updatedBaseClass.getClassName());
            existingBaseClass.setTeacher(updatedBaseClass.getTeacher());
            baseClassRepo.save(existingBaseClass);
        }
        else{
            ResponseEntity.notFound().build();
        }
    }
}
