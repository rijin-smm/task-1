package com.Task_4.studentManagement.Repository;

import com.Task_4.studentManagement.Model.BaseClass;
import com.Task_4.studentManagement.Model.Student;
import com.Task_4.studentManagement.Model.studentClass;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface studentClassRepo extends MongoRepository<studentClass,Long> {
    @Query("{ 'student.id' : ?0, 'classLeavingDate' : null }")
    studentClass findCurrentClassByStudentId(long studentId);

    studentClass findFirstByStudentIdAndClassLeavingDateIsNullOrderByClassJoiningDateDesc(long studentId);

    studentClass findFirstByStudentIdOrderByClassJoiningDateDesc(long studentId);

    List<studentClass> findByBaseClass(BaseClass baseClass);

    studentClass findByStudent(Student student);
}
