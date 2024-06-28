package com.Task_4.studentManagement.Service.Interface;

import com.Task_4.studentManagement.Model.Student;

import java.util.List;

public interface studentService {
    List<Student> getAllStudent();
    void addStudent(Student newStudent);
    void updateStudent(Student updatedStudent,int roll_no);
    void deleteStudent(int roll_no);
    List<Student> getTop3Student();
    List<Student> getStudentByname(String studentName);
    List<Student> getStudentsWithFirstRank();
}
