package com.Task_4.studentManagement.Service.Implements;
import com.Task_4.studentManagement.DTO.StudentDetailsDTO;
import com.Task_4.studentManagement.Model.BaseClass;
import com.Task_4.studentManagement.Model.Student;
import com.Task_4.studentManagement.Model.studentClass;
import com.Task_4.studentManagement.Repository.StudentRepo;
import com.Task_4.studentManagement.Repository.baseClassRepo;
import com.Task_4.studentManagement.Repository.studentClassRepo;
import com.Task_4.studentManagement.Service.Interface.studentClassService;
import com.example.demo.ExceptionHandler.ResourceNotFoundException;
import jakarta.validation.Valid;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Validated
public class studentClassServiceImpl implements studentClassService {

    @Autowired
    private studentClassRepo sc_repo;

    @Autowired
    private baseClassRepo br;

    @Autowired
    private StudentRepo sr;

    @Autowired
    private com.Task_4.studentManagement.Service.Interface.sequenceGeneratorService sequenceGeneratorService;

    @Override
    public List<studentClass> getAllStudentClass() {
        return sc_repo.findAll();
    }

    @Override
    public void createNewStudentClass(@Valid studentClass newStudentClass) {
        newStudentClass.setId(sequenceGeneratorService.generateSequence(newStudentClass.SEQUENCE_NAME));
        sc_repo.save(newStudentClass);

    }

    @Override
    public void deleteStudentClass(long classId) {
        sc_repo.deleteById(classId);
    }

    @Override
    public void updateStudentClass(@Valid studentClass updatedStudentClass, long id) {
        Optional <studentClass> studentclass = sc_repo.findById(id);
        if(studentclass.isPresent()){
            studentClass existingStudentClass = studentclass.get();
            existingStudentClass.setStudent(updatedStudentClass.getStudent());
            existingStudentClass.setRank(updatedStudentClass.getRank());
            existingStudentClass.setRollNumber(updatedStudentClass.getRollNumber());
            existingStudentClass.setBaseClass(updatedStudentClass.getBaseClass());
            sc_repo.save(existingStudentClass);
        }
    }

//    @Override
//    public StudentClass getStudentClassById(String student_class_id) {
//        return sc_repo.findByStudentClassId(student_class_id);
//    }


//
//    @Override
//    public void updateNewStudentClass(long studentId, long newClassId, int rollNumber, int rank, Date classJoiningDate) {
//        Optional<Student> optionalStudent = sr.findById(studentId);
//        if (!optionalStudent.isPresent()) {
//            throw new IllegalArgumentException("Student not found");
//        }
//        Student student = optionalStudent.get();
//
//        Optional<BaseClass> optionalBaseClass = br.findById(newClassId);
//        if (!optionalBaseClass.isPresent()) {
//            throw new IllegalArgumentException("Base class not found");
//        }
//        BaseClass newClass = optionalBaseClass.get();
//
//        // Find the current class of the student
//        studentClass currentClass = sc_repo.findCurrentClassByStudentId(studentId);
//        if (currentClass != null) {
//            // Update the leaving date for the current class
//            currentClass.setClassLeavingDate(new Date());
//            sc_repo.save(currentClass);
//        }
//
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        Date classJoiningDate = dateFormat.parse(request.getClassJoiningDate());
//        // Create a new StudentClass entry for the new class
//        studentClass newStudentClass = new studentClass();
//        newStudentClass.setId(sequenceGeneratorService.generateSequence(studentClass.SEQUENCE_NAME));
//        newStudentClass.setStudent(student);
//        newStudentClass.setBaseClass(newClass);
//        newStudentClass.setClassJoiningDate(classJoiningDate);
//        newStudentClass.setRollNumber(rollNumber);
//        newStudentClass.setRank(rank);
//
//        sc_repo.save(newStudentClass);
//    }
//
//    @Override
//    public StudentDetailsDTO getStudentDetails(long studentId) {
//        Optional<Student> optionalStudent = sr.findById(studentId);
//        if (!optionalStudent.isPresent()) {
//            throw new IllegalArgumentException("Student not found");
//        }
//        Student student = optionalStudent.get();
//
//        studentClass currentClass = sc_repo.findCurrentClassByStudentId(studentId);
//        if (currentClass == null) {
//            throw new IllegalArgumentException("No current class found for student");
//        }
//
//        StudentDetailsDTO studentDetails = new StudentDetailsDTO();
//        studentDetails.setStudentName(student.getStudentName());
//        studentDetails.setAge(student.getAge());
//        studentDetails.setRollNumber(currentClass.getRollNumber());
//        studentDetails.setRank(currentClass.getRank());
//        studentDetails.setClassName(currentClass.getBaseClass().getClassName());
//        studentDetails.setTeacherName(currentClass.getBaseClass().getTeacher().getTeacherName());
//        studentDetails.setClassJoiningDate(currentClass.getClassJoiningDate());
//
//        return studentDetails;
//    }




//
//    @Override
//    public void moveStudentToNewClass(long studentId, BaseClass baseClass, int rollNumber, int rank, Date joiningDate) {
//        // Find the current active class for the student
//        studentClass currentClass = sc_repo.findFirstByStudentIdAndClassLeavingDateIsNullOrderByClassJoiningDateDesc(studentId);
//
//        if (currentClass != null) {
//            // Update the leaving date of the current class
//            currentClass.setClassLeavingDate(new Date());
//            sc_repo.save(currentClass);
//        }
//
//        // Create a new StudentClass object for the new class
//        Student student = sr.findById(studentId).orElseThrow(() -> new RuntimeException("Student not found"));
//        BaseClass newBaseClass = br.findById(baseClass.getId()).orElseThrow(() -> new RuntimeException("BaseClass not found"));
//
//        studentClass newClass = new studentClass();
//        newClass.setStudent(student);
//        newClass.setBaseClass(newBaseClass);
//        newClass.setRollNumber(rollNumber);
//        newClass.setRank(rank);
//        newClass.setClassJoiningDate(joiningDate);
//        sc_repo.save(newClass);
//    }


    @Override
    public StudentDetailsDTO getCurrentStudentDetails(long studentId) {
        // Retrieve the latest StudentClass for the student
        studentClass latestClass = sc_repo.findFirstByStudentIdOrderByClassJoiningDateDesc(studentId);

        if (latestClass != null) {
            // Populate StudentDetailsDTO
            StudentDetailsDTO studentDetailsDTO = new StudentDetailsDTO();
            studentDetailsDTO.setStudentName(latestClass.getStudent().getStudentName());
            studentDetailsDTO.setAge(latestClass.getStudent().getAge());
            studentDetailsDTO.setRollNumber(latestClass.getRollNumber());
            studentDetailsDTO.setRank(latestClass.getRank());
            studentDetailsDTO.setClassName(latestClass.getBaseClass().getClassName());
            studentDetailsDTO.setTeacherName(latestClass.getBaseClass().getTeacher().getTeacherName());
            studentDetailsDTO.setClassJoiningDate(latestClass.getClassJoiningDate());

            return studentDetailsDTO;
        } else {
            throw new ResourceNotFoundException("the studentId : " + studentId + " is invalid");
        }
    }



}
