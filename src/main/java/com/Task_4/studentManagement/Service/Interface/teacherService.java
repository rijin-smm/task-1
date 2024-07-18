package com.Task_4.studentManagement.Service.Interface;

import com.Task_4.studentManagement.Model.Teacher;
import jakarta.validation.Valid;

import java.util.List;

public interface teacherService {
    List<Teacher> getAllTeacher();
    void createTeacher(@Valid Teacher newTeacher);
    void deleteTeacher(long teacherId);
    void updateTeacher(@Valid Teacher updatedTeacher, long teacherId);
    List<Teacher> getTeachersBySubjectName(String subjectName);
}
