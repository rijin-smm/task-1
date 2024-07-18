package com.example.demo.Service.Implements;

import com.example.demo.Model.Subject;
import com.example.demo.Model.Teacher;
import com.example.demo.Repository.SubjectRepo;
import com.example.demo.Repository.TeacherRepo;
import com.example.demo.Service.Interface.TeacherService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepo teacherRepo;

    @Autowired
    private SubjectRepo subjectRepo;

    @Override
    public List<Teacher> getAllTeacher() {
        return teacherRepo.findAll();
    }

    @Override
    public void createTeacher(@Valid Teacher newTeacher) {
        teacherRepo.save(newTeacher);
    }

    @Override
    public void deleteTeacher(long teacherId) {
        teacherRepo.deleteById(teacherId);
    }
    //
    @Override
    public void updateTeacher(@Valid Teacher updatedTeacher, long teacherId) {
        teacherRepo.findById(teacherId).map(teacher -> {
            teacher.setTeacherName(updatedTeacher.getTeacherName());
            teacher.setTeacherSubject(updatedTeacher.getTeacherSubject());
            return teacherRepo.save(teacher);
        }).orElseThrow(() -> new RuntimeException("Teacher not found with id " + teacherId));
    }

    @Override
    public List<Teacher> getTeachersBySubjectName(String subjectName) {
        List<Teacher> teachers = teacherRepo.findTeachersBySubjectName(subjectName);
        return teachers;
//        Optional<Subject> subjectOpt = subjectRepo.findBySubjectName(subjectName);
//        if (subjectOpt.isPresent()) {
//            long subjectId = subjectOpt.get().getId();
//            return teacherRepo.findByTeacherSubjectContaining(subjectId);
//        }
//        return List.of(); // Return an empty list if subject is not found
    }
}
