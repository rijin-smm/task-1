package com.example.demo.Service.Implements;

import com.example.demo.Model.StudentClass;
import com.example.demo.Repository.StudentClassRepo;
import com.example.demo.Service.Interface.StudentClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class StudentClassServiceImpl implements StudentClassService {


    @Autowired
    private StudentClassRepo studentClassRepo;

    @Override
    public List<StudentClass> getAllStudentClass() {
        return studentClassRepo.findAll();
    }

    @Override
    public void createNewStudentClass(@Valid StudentClass newStudentClass) {
        newStudentClass.setClassJoining(new Date());
        studentClassRepo.save(newStudentClass);

    }

    @Override
    public void deleteStudentClass(long classId) {
        studentClassRepo.deleteById(classId);
    }

    @Override
    public void updateStudentClass(@Valid StudentClass updatedStudentClass, long id) {
        Optional<StudentClass> optionalStudentClass = studentClassRepo.findById(id);
        if(optionalStudentClass.isPresent()){
            StudentClass existingStudentClass = optionalStudentClass.get();
            existingStudentClass.setStudent(updatedStudentClass.getStudent());
            existingStudentClass.setRank(updatedStudentClass.getRank());
            existingStudentClass.setRollNumber(updatedStudentClass.getRollNumber());
            existingStudentClass.setBaseClass(updatedStudentClass.getBaseClass());
            studentClassRepo.save(existingStudentClass);
        }
    }

//    @Override
//    public StudentClass getStudentClassById(String student_class_id) {
//        return sc_repo.findByStudentClassId(student_class_id);
//    }
}
