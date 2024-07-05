package com.Task_4.studentManagement.Service.Implements;

import com.Task_4.studentManagement.Model.BaseClass;
import com.Task_4.studentManagement.Model.Student;
import com.Task_4.studentManagement.Repository.baseClassRepo;
import com.Task_4.studentManagement.Service.Interface.baseClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class baseClassServiceImpl implements baseClassService {

    @Autowired
    private baseClassRepo br;

    @Override
    public void addBaseClassStudent(BaseClass baseClass){
        br.save(baseClass);
    }

    @Override
    public List<BaseClass> getAllBaseClass(){
        return br.findAll();
    }

    public void updateBaseClass(long studentId, long classId, BaseClass updatedBaseClass) {
        BaseClass baseClass = br.findByStudentIdAndClassId(studentId, classId)
                .orElseThrow(() -> new RuntimeException("BaseClass not found with studentId " + studentId + " and classId " + classId));

        baseClass.setRollNumber(updatedBaseClass.getRollNumber());
        baseClass.setRank(updatedBaseClass.getRank());
        // Update other fields as necessary

        br.save(baseClass);
    }

}
