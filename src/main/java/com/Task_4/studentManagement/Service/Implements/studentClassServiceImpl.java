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

    @Override
    public List<StudentClass> getAllStudentClass() {
        return sc_repo.findAll();
    }

    List<StudentClass> studentClasses = new ArrayList<>();

    @Override
    public void createNewStudentClass(StudentClass newStudentClass) {
        sc_repo.save(newStudentClass);
    }

    @Override
    public void deleteStudentClass(String student_class_id) {
        sc_repo.deleteById(student_class_id);
    }

    @Override
    public void updateStudentClass(StudentClass updatedStudentClass, String studentClassId) {
        sc_repo.findById(studentClassId).map(studentClass -> {
            studentClass.setId(updatedStudentClass.getId());
            studentClass.setStudentName(updatedStudentClass.getStudentName());
            return sc_repo.save(updatedStudentClass);
        }).orElseThrow(() -> new RuntimeException("StudentClass not found with id "+ studentClassId));
    }

    @Override
    public StudentClass getStudentClassById(String student_class_id) {
        return sc_repo.findByStudentClassId(student_class_id);
    }
}
