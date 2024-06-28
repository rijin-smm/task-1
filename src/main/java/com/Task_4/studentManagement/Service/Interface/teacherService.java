package com.Task_4.studentManagement.Service.Interface;

import com.Task_4.studentManagement.Model.Teacher;

import java.util.List;

public interface teacherService {
    List<Teacher> getAllTeacher();
    void createTeacher(Teacher newTeacher);
    void deleteTeacher(String teacher_id);
    void updateTeacher(Teacher updatedTeacher, String teacher_id);
    List<Teacher> getTeacherBySubjectName(String teacherSubject);
}
