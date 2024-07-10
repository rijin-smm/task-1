package com.example.demo.Service.Interface;

import com.example.demo.Model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudent();
    void addStudent(Student newStudent);
    void deleteStudent(long id);
    void updateStudent(Student updatedStudent, long id);
//    //    List<Student> getTop3Student();
    Student getStudentByname(String studentName);
////    List<HighestScoreStudentDTO> getStudentsWithFirstRank();

}
