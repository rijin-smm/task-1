package com.Task_4.studentManagement.Repository;

import com.Task_4.studentManagement.Model.Subject;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface subjectRepo extends MongoRepository<Subject, Long> {
    Optional<Subject> findBySubjectName(String subjectName);
}
