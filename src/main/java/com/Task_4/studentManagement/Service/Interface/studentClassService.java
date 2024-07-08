package com.Task_4.studentManagement.Service.Interface;
import com.Task_4.studentManagement.Model.studentClass;
import com.Task_4.studentManagement.Repository.studentClassRepo;

import java.util.List;

public interface studentClassService {
    List<studentClass> getAllStudentClass();
    void createNewStudentClass(studentClass newStudentClass);
    void deleteStudentClass(long classId);
    void updateStudentClass(studentClass updatedStudentClass, long id);
//    StudentClass getStudentClassById(String student_class_id);
}
