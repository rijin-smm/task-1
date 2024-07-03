package com.Task_4.studentManagement.Service.Implements;

import com.Task_4.studentManagement.Model.StudentClass;
import com.Task_4.studentManagement.Repository.studentClassRepo;
import com.Task_4.studentManagement.Service.Interface.studentClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class studentClassServiceImpl implements studentClassService {
    @Autowired
    private studentClassRepo sc_repo;

    @Autowired
    private com.Task_4.studentManagement.Service.Interface.sequenceGeneratorService sequenceGeneratorService;

    @Override
    public List<StudentClass> getAllStudentClass() {
        return sc_repo.findAll();
    }

    List<StudentClass> studentClasses = new ArrayList<>();

    @Override
    public void createNewStudentClass(StudentClass newStudentClass) {
        newStudentClass.setClassId(sequenceGeneratorService.generateSequence(newStudentClass.SEQUENCE_NAME));
        sc_repo.save(newStudentClass);
        sc_repo.save(newStudentClass);
    }

    @Override
    public void deleteStudentClass(long classId) {
        sc_repo.deleteById(classId);
    }

    @Override
    public void updateStudentClass(StudentClass updatedStudentClass, long classId) {
        sc_repo.findById(classId).map(studentClass -> {
            studentClass.setTeacherId(updatedStudentClass.getTeacherId());
            studentClass.setClassName(updatedStudentClass.getClassName());
            return sc_repo.save(updatedStudentClass);
        }).orElseThrow(() -> new RuntimeException("StudentClass not found with id "+ classId));
    }

//    @Override
//    public StudentClass getStudentClassById(String student_class_id) {
//        return sc_repo.findByStudentClassId(student_class_id);
//    }
}
