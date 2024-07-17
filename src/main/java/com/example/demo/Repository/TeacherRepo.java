package com.example.demo.Repository;

import com.example.demo.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepo extends JpaRepository<Teacher,Long> {
    @Query(value = "SELECT t.* FROM teacher t " +
            "JOIN teacher_subjects ts ON t.id = ts.teacher_id " +
            "JOIN subject s ON ts.subject_id = s.id " +
            "WHERE s.subject_name = :subjectName", nativeQuery = true)
    List<Teacher> findTeachersBySubjectName(@Param("subjectName") String subjectName);
//    @Query("SELECT t FROM Teacher t JOIN t.teacherSubject s WHERE s.subjectName = :subjectName")
//    List<Teacher> findBySubjectName(@Param("subjectName") String subjectName);
//    List<Teacher> findByTeacherSubjectContaining(long subjectId);
}
