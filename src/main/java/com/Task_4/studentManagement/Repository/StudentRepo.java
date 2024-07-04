package com.Task_4.studentManagement.Repository;

import com.Task_4.studentManagement.Model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends MongoRepository<Student,Long> {

//    List<Student> findTop3ByOrderByRankAsc();
    Student findByStudentName(String studentName);
    List<Student> findByClassId(long classId);
    List<Student> findAll();
}
