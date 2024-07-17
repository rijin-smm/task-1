package com.example.demo.Repository;

import com.example.demo.Model.Student;
import com.example.demo.Model.StudentClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentClassRepo extends JpaRepository<StudentClass,Long> {
    Optional<Object> findByStudentId(Long id);

    List<StudentClass> findByBaseClassId(long id);
}


