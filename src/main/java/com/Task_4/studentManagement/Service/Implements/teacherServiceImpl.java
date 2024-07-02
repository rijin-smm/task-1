package com.Task_4.studentManagement.Service.Implements;

import com.Task_4.studentManagement.Model.Teacher;
import com.Task_4.studentManagement.Repository.teacherRepo;
import com.Task_4.studentManagement.Service.Interface.teacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class teacherServiceImpl implements teacherService {

    @Autowired
    private teacherRepo tr;
    private List<Teacher> teachers = new ArrayList<>();

    @Autowired
    private com.Task_4.studentManagement.Service.Interface.sequenceGeneratorService sequenceGeneratorService;

    @Override
    public List<Teacher> getAllTeacher() {
        return tr.findAll();
    }

    @Override
    public void createTeacher(Teacher newTeacher) {
        newTeacher.setTeacherId(sequenceGeneratorService.generateSequence(newTeacher.SEQUENCE_NAME));
        tr.save(newTeacher);
        tr.save(newTeacher);
    }

//    @Override
//    public void deleteTeacher(String teacher_id) {
//        tr.deleteById(teacher_id);
//    }
//
//    @Override
//    public void updateTeacher(Teacher updatedTeacher, String teacher_id) {
//        tr.findById(teacher_id).map(teacher -> {
//            teacher.setTeacher_id(updatedTeacher.getTeacher_id());
//            teacher.setTeacher_name(updatedTeacher.getTeacher_name());
//            teacher.setTeacherSubject(updatedTeacher.getTeacherSubject());
//            return tr.save(teacher);
//        }).orElseThrow(() -> new RuntimeException("Teacher not found with id " + teacher_id));
//    }

//    @Override
//    public List<Teacher> getTeacherBySubjectName(String teacherSubject) {
//        return tr.findByTeacherSubject(teacherSubject);
//    }
}
