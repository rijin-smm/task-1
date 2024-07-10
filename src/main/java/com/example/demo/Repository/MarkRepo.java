package com.example.demo.Repository;

import com.example.demo.Model.Mark;
import com.example.demo.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarkRepo extends JpaRepository<Mark,Long> {
    List<Mark> findByStudentId(Long id);

    List<Mark> findByStudent(Student student);
}
