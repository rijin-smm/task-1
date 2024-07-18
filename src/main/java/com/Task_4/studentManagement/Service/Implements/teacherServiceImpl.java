package com.Task_4.studentManagement.Service.Implements;

import com.Task_4.studentManagement.Model.Subject;
import com.Task_4.studentManagement.Model.Teacher;
import com.Task_4.studentManagement.Repository.subjectRepo;
import com.Task_4.studentManagement.Repository.teacherRepo;
import com.Task_4.studentManagement.Service.Interface.teacherService;
import com.example.demo.ExceptionHandler.ResourceNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Validated
public class teacherServiceImpl implements teacherService {

    @Autowired
    private teacherRepo tr;

    @Autowired
    private subjectRepo sr;

    @Autowired
    private com.Task_4.studentManagement.Service.Interface.sequenceGeneratorService sequenceGeneratorService;

    @Override
    public List<Teacher> getAllTeacher() {
        return tr.findAll();
    }

    @Override
    public void createTeacher(@Valid Teacher newTeacher) {
        newTeacher.setId(sequenceGeneratorService.generateSequence(newTeacher.SEQUENCE_NAME));
        tr.save(newTeacher);
    }

    @Override
    public void deleteTeacher(long teacherId) {
        tr.deleteById(teacherId);
    }
//
    @Override
    public void updateTeacher(@Valid Teacher updatedTeacher, long teacherId) {
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
            long subjectId = subjectOpt.get().getId();
            return tr.findByTeacherSubjectContaining(subjectId);
        }
        else{
            throw new ResourceNotFoundException("subject name "+ subjectName +" is not available");
        }
    }

}
