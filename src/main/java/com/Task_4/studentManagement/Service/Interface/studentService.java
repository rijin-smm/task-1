package com.Task_4.studentManagement.Service.Interface;

import com.Task_4.studentManagement.Model.HighestScoreStudentDTO;
import com.Task_4.studentManagement.Model.Student;
import jakarta.validation.Valid;

import java.util.List;

public interface studentService {
    List<Student> getAllStudent();
    void addStudent(@Valid Student newStudent);
    void deleteStudent(long id);
    void updateStudent(@Valid Student updatedStudent, long id);
//    List<Student> getTop3Student();
    Student getStudentByname(String studentName);
//    List<HighestScoreStudentDTO> getStudentsWithFirstRank();

}
