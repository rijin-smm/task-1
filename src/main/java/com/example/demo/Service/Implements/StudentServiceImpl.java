package com.example.demo.Service.Implements;

import com.example.demo.Model.Student;
import com.example.demo.Repository.StudentRepo;
import com.example.demo.Service.Interface.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public List<Student> getAllStudent() {
        return studentRepo.findAll();
    }

    @Override
    public void addStudent(Student newStudent){
        studentRepo.save(newStudent);
    }

    @Override
    public void updateStudent(Student updatedStudent, long id) {
        Optional<Student> student = studentRepo.findById(id);
        if(student.isPresent()){
            Student existingStudent = student.get();
            existingStudent.setStudentName(updatedStudent.getStudentName());
            existingStudent.setAge(updatedStudent.getAge());
            studentRepo.save(existingStudent);
        }
        else{
            ResponseEntity.notFound().build();
        }
    }

    @Override
    public void deleteStudent(long id) {
        studentRepo.deleteById(id);
    }

    @Override
    public Student getStudentByname(String studentName) {
        return studentRepo.findByStudentName(studentName);
    }
}
