package com.Task_4.studentManagement.Service.Interface;
import com.Task_4.studentManagement.DTO.StudentDetailsDTO;
import com.Task_4.studentManagement.Model.BaseClass;
import com.Task_4.studentManagement.Model.studentClass;
import com.Task_4.studentManagement.Repository.studentClassRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.List;

public interface studentClassService {
    List<studentClass> getAllStudentClass();
    void createNewStudentClass(studentClass newStudentClass);
    void deleteStudentClass(long classId);
    void updateStudentClass(studentClass updatedStudentClass, long id);

    void moveStudentToNewClass(long studentId, BaseClass baseClass, int rollNumber, int rank, Date joiningDate);
    StudentDetailsDTO getCurrentStudentDetails(long studentId);
    //    StudentClass getStudentClassById(String student_class_id);
//    void updateNewStudentClass(long studentId, long newClassId, int rollNumber, int rank, Date classJoiningDate);

//    StudentDetailsDTO getStudentDetails(long studentId);
}
