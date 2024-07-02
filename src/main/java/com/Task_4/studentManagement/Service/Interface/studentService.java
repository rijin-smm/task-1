package com.Task_4.studentManagement.Service.Interface;

import com.Task_4.studentManagement.Model.Student;

import java.util.List;

public interface studentService {
    List<Student> getAllStudent();
    void addStudent(Student newStudent);
//    void deleteStudent(String studentId);
//    List<Student> getTop3Student();
//    List<Student> getStudentByname(String studentName);
//    List<Student> getStudentsWithFirstRank();
//    void updateStudent(Student updatedStudent, String studentId);
}
