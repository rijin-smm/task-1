package com.Task_4.studentManagement.Service;

import com.Task_4.studentManagement.Model.Student;
import com.Task_4.studentManagement.Model.StudentClass;
import com.Task_4.studentManagement.Repository.studentClassRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class studentClassService {

    @Autowired
    private studentClassRepo sc_repo;
    private List<StudentClass> studentClasses = new ArrayList<>();

    public List<StudentClass> getAllStudentClass() {
        return sc_repo.findAll();
    }

    public void createNewStudentClass(StudentClass studentClass) {
        sc_repo.save(studentClass);
    }

    public void deleteStudentClass(String student_class_id) {
        sc_repo.deleteById(student_class_id);
    }

    public void updateStudentClass(StudentClass updatedStudentClass, String student_class_id) {
        sc_repo.findById(student_class_id).map(studentClass -> {
            studentClass.setStudent_class_id(updatedStudentClass.getStudent_class_id());
            studentClass.setStudent_class_name(updatedStudentClass.getStudent_class_name());
            return sc_repo.save(updatedStudentClass);
        }).orElseThrow(() -> new RuntimeException("StudentClass not found with id "+ student_class_id));
    }
}
