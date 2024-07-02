package com.Task_4.studentManagement.Service.Interface;

import com.Task_4.studentManagement.Model.StudentClass;

import java.util.List;

public interface studentClassService {
    List<StudentClass> getAllStudentClass();
    void createNewStudentClass(StudentClass newStudentClass);
//    void deleteStudentClass(String student_class_id);
//    void updateStudentClass(StudentClass updatedStudentClass, String studentClassId);
//    StudentClass getStudentClassById(String student_class_id);
}
