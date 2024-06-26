package com.Task_4.studentManagement.Repository;

import com.Task_4.studentManagement.Model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends MongoRepository<Student,Integer> {

    List<Student> findTop3ByOrderByRankAsc();
    List<Student> findByStudentName(String studentName);
    List<Student> findByRank(String rank);
}
