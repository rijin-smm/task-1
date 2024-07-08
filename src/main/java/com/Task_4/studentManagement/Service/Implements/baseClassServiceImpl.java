package com.Task_4.studentManagement.Service.Implements;

import com.Task_4.studentManagement.Model.BaseClass;
import com.Task_4.studentManagement.Repository.baseClassRepo;
import com.Task_4.studentManagement.Service.Interface.baseClassService;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class baseClassServiceImpl implements baseClassService {

    @Autowired
    private baseClassRepo br;

    @Autowired
    private com.Task_4.studentManagement.Service.Interface.sequenceGeneratorService sequenceGeneratorService;


    @Override
    public void addBaseClassStudent(BaseClass baseClass){
        baseClass.setId(sequenceGeneratorService.generateSequence(baseClass.SEQUENCE_NAME));
        br.save(baseClass);
    }

    @Override
    public List<BaseClass> getAllBaseClass(){
        return br.findAll();
    }

    public void updateBaseClass(long id, BaseClass updatedBaseClass) {
        Optional<BaseClass> baseClass= br.findById(id);
        if(baseClass.isPresent()){
            BaseClass existingBaseClass = baseClass.get();
            existingBaseClass.setClassName(updatedBaseClass.getClassName());
            existingBaseClass.setTeacher(updatedBaseClass.getTeacher());
            br.save(existingBaseClass);
        }
        else{
            ResponseEntity.notFound().build();
        }
    }

}
