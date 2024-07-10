package com.example.demo.Repository;

import com.example.demo.Model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubjectRepo extends JpaRepository<Subject,Long> {
    Optional<Subject> findBySubjectName(String subjectName);
}
