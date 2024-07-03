package com.Task_4.studentManagement.Service.Interface;

import com.Task_4.studentManagement.Model.Teacher;

import java.util.List;

public interface teacherService {
    List<Teacher> getAllTeacher();
    void createTeacher(Teacher newTeacher);
    void deleteTeacher(long teacherId);
    void updateTeacher(Teacher updatedTeacher, long teacherId);
    List<Teacher> getTeachersBySubjectName(String subjectName);
}
