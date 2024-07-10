package com.example.demo.Service.Interface;

import com.example.demo.Model.Subject;

import java.util.List;

public interface SubjectService {

    List<Subject> getAllSubject();
    void createNewSubject(Subject newSubject);
    void deleteSubject(long subjectId);
    Subject updateSubject(Subject subjectDetails, long subjectId );
}
