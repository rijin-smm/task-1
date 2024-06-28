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


    @Override
    public List<Student> getAllStudent() {
        return sr.findAll();
    }

    @Override
    public void addStudent(Student newStudent){
        sr.save(newStudent);
    }

    @Override
    public void updateStudent(Student updatedStudent,int roll_no) {
        sr.findById(roll_no).map(student -> {
            student.setRollNo(updatedStudent.getRollNo());
            student.setStudentName(updatedStudent.getStudentName());
            student.setRank(updatedStudent.getRank());
            return sr.save(student);
        }).orElseThrow(() -> new RuntimeException("Employee not found with id " + roll_no));
    }

    @Override
    public void deleteStudent(int roll_no) {
        sr.deleteById(roll_no);
    }

    @Override
    public List<Student> getTop3Student() {
        return sr.findTop3ByOrderByRankAsc();
    }
    @Override
    public List<Student> getStudentByname(String studentName) {
        return sr.findByStudentName(studentName);
    }

    @Override
    public List<Student> getStudentsWithFirstRank() {
        return sr.findByRank("1");
    }
}
