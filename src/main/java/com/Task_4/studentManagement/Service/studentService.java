package com.Task_4.studentManagement.Service;

import com.Task_4.studentManagement.Model.Student;
import com.Task_4.studentManagement.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class studentService {

    @Autowired
    private StudentRepo sr;
    private List<Student> students = new ArrayList<>();

    public List <Student> getAllStudent(){
        return sr.findAll();
    }
    public void addStudent(Student newStudent){
        sr.save(newStudent);

    }

    public void updateStudent(Student updatedStudent,int roll_no) {
        sr.findById(roll_no).map(student -> {
            student.setRollNo(updatedStudent.getRollNo());
            student.setStudentName(updatedStudent.getStudentName());
            student.setRank(updatedStudent.getRank());
            return sr.save(student);
        }).orElseThrow(() -> new RuntimeException("Employee not found with id " + roll_no));
    }

    public void deleteStudent(int roll_no) {
        sr.deleteById(roll_no);
    }

    public List<Student> getTop3Student() {
        return sr.findTop3ByOrderByRankAsc();

    }


    public List<Student> getStudentByname(String studentName) {
        return sr.findByStudentName(studentName);
    }



    public List<Student> getStudentsWithFirstRank() {
        return sr.findByRank("1");
    }
}
