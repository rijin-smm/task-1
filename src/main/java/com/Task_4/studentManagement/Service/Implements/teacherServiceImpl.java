package com.Task_4.studentManagement.Service.Implements;

import com.Task_4.studentManagement.Model.Subject;
import com.Task_4.studentManagement.Model.Teacher;
import com.Task_4.studentManagement.Repository.subjectRepo;
import com.Task_4.studentManagement.Repository.teacherRepo;
import com.Task_4.studentManagement.Service.Interface.teacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class teacherServiceImpl implements teacherService {

    @Autowired
    private teacherRepo tr;

    @Autowired
    private subjectRepo sr;
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
    }

    @Override
    public void deleteTeacher(long teacherId) {
        tr.deleteById(teacherId);
    }
//
    @Override
    public void updateTeacher(Teacher updatedTeacher, long teacherId) {
        tr.findById(teacherId).map(teacher -> {
            teacher.setTeacherName(updatedTeacher.getTeacherName());
            teacher.setTeacherSubject(updatedTeacher.getTeacherSubject());
            return tr.save(teacher);
        }).orElseThrow(() -> new RuntimeException("Teacher not found with id " + teacherId));
    }

    @Override
    public List<Teacher> getTeachersBySubjectName(String subjectName) {
        Optional<Subject> subjectOpt = sr.findBySubjectName(subjectName);
        if (subjectOpt.isPresent()) {
            long subjectId = subjectOpt.get().getSubjectId();
            return tr.findByTeacherSubjectContaining(subjectId);
        }
        return List.of(); // Return an empty list if subject is not found
    }

}
