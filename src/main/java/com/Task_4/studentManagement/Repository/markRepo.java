package com.Task_4.studentManagement.Repository;

import com.Task_4.studentManagement.Model.Mark;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface markRepo extends MongoRepository<Mark, Long> {
    List<Mark> findByStudentId(long studentId);
    List<Mark> findAll();
}
