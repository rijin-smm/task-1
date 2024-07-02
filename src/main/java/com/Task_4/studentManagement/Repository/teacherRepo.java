package com.Task_4.studentManagement.Repository;

import com.Task_4.studentManagement.Model.Teacher;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface teacherRepo extends MongoRepository<Teacher,Long> {

//    List<Teacher> findByTeacherSubject(String teacherSubject);
}
