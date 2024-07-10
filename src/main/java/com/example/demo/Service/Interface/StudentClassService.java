package com.example.demo.Service.Interface;

import com.example.demo.Model.StudentClass;

import java.util.List;

public interface StudentClassService {
    List<StudentClass> getAllStudentClass();
    void createNewStudentClass(StudentClass newStudentClass);
    void deleteStudentClass(long classId);
    void updateStudentClass(StudentClass updatedStudentClass, long id);
//    StudentClass getStudentClassById(String student_class_id);
}
