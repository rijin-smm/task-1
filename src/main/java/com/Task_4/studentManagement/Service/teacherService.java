package com.Task_4.studentManagement.Service;

import com.Task_4.studentManagement.Model.Teacher;
import com.Task_4.studentManagement.Repository.teacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class teacherService {

    @Autowired
    private teacherRepo tr;
    private List<Teacher> teachers = new ArrayList<>();

    public List<Teacher> getAllStudent() {
        return tr.findAll();
    }

    public void createTeacher(Teacher newTeacher) {
        tr.save(newTeacher);
    }

    public void deleteTeacher(String teacher_id) {
        tr.deleteById(teacher_id);
    }

    public void updateTeacher(Teacher updatedTeacher, String teacher_id) {
        tr.findById(teacher_id).map(teacher -> {
            teacher.setTeacher_id(updatedTeacher.getTeacher_id());
            teacher.setTeacher_name(updatedTeacher.getTeacher_name());
            teacher.setTeacher_subject(updatedTeacher.getTeacher_subject());
            return tr.save(teacher);
        }).orElseThrow(() -> new RuntimeException("Teacher not found with id " + teacher_id));
    }

    public List<Teacher> getTeacherBySubjectName(String subject_name) {
        return tr.findByTeacher_subject(subject_name);
    }
}
