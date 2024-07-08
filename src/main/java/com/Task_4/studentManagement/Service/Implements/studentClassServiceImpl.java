package com.Task_4.studentManagement.Service.Implements;
import com.Task_4.studentManagement.Model.studentClass;
import com.Task_4.studentManagement.Repository.studentClassRepo;
import com.Task_4.studentManagement.Service.Interface.studentClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class studentClassServiceImpl implements studentClassService {

    @Autowired
    private studentClassRepo sc_repo;

    @Autowired
    private com.Task_4.studentManagement.Service.Interface.sequenceGeneratorService sequenceGeneratorService;

    @Override
    public List<studentClass> getAllStudentClass() {
        return sc_repo.findAll();
    }

    @Override
    public void createNewStudentClass(studentClass newStudentClass) {
        newStudentClass.setId(sequenceGeneratorService.generateSequence(newStudentClass.SEQUENCE_NAME));
        sc_repo.save(newStudentClass);

    }

    @Override
    public void deleteStudentClass(long classId) {
        sc_repo.deleteById(classId);
    }

    @Override
    public void updateStudentClass(studentClass updatedStudentClass, long id) {
        Optional <studentClass> studentclass = sc_repo.findById(id);
        if(studentclass.isPresent()){
            studentClass existingStudentClass = studentclass.get();
            existingStudentClass.setStudent(updatedStudentClass.getStudent());
            existingStudentClass.setRank(updatedStudentClass.getRank());
            existingStudentClass.setRollNumber(updatedStudentClass.getRollNumber());
            sc_repo.save(existingStudentClass);
        }
    }

//    @Override
//    public StudentClass getStudentClassById(String student_class_id) {
//        return sc_repo.findByStudentClassId(student_class_id);
//    }
}
