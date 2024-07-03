package com.Task_4.studentManagement.Service.Implements;

import com.Task_4.studentManagement.Model.Student;
import com.Task_4.studentManagement.Repository.StudentRepo;
import com.Task_4.studentManagement.Service.Interface.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class studentServiceImpl implements studentService {

    @Autowired
    private StudentRepo sr;
    private List<Student> students = new ArrayList<>();


    @Autowired
    private com.Task_4.studentManagement.Service.Interface.sequenceGeneratorService sequenceGeneratorService;

    @Override
    public List<Student> getAllStudent() {
        return sr.findAll();
    }

    @Override
    public void addStudent(Student newStudent){
        newStudent.setId(sequenceGeneratorService.generateSequence(newStudent.SEQUENCE_NAME));
        sr.save(newStudent);
    }

    @Override
    public void updateStudent(Student updatedStudent, long id) {
        sr.findById(id).map(student -> {
            student.setStudentName(updatedStudent.getStudentName());
            student.setClassId(updatedStudent.getClassId());
            return sr.save(student);
        }).orElseThrow(() -> new RuntimeException("Student not found with id " + id));
    }


    @Override
    public void deleteStudent(long id) {
        sr.deleteById(id);
    }

//    @Override
//    public List<Student> getTop3Student() {
//        return sr.findTop3ByOrderByRankAsc();
//    }
    @Override
    public List<Student> getStudentByname(String studentName) {
        return sr.findByStudentName(studentName);
    }
//
//    @Override
//    public List<Student> getStudentsWithFirstRank() {
//        return sr.findByRank("1");
//    }
}
