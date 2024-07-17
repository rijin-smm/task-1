package com.example.demo.Service.Interface;

import com.example.demo.Model.Teacher;

import java.util.List;

public interface TeacherService {

    List<Teacher> getAllTeacher();
    void createTeacher(Teacher newTeacher);
    void deleteTeacher(long teacherId);
    void updateTeacher(Teacher updatedTeacher, long teacherId);
    List<Teacher> getTeachersBySubjectName(String subjectName);
}
