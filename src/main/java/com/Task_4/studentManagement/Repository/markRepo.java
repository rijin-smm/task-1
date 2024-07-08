package com.Task_4.studentManagement.Repository;

import com.Task_4.studentManagement.Model.Mark;
import com.Task_4.studentManagement.Model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface markRepo extends MongoRepository<Mark, Long> {
    List<Mark> findAll();
    List<Mark> findByStudent(Student student);

    List<Mark> findByStudentId(long id);
}
