package com.Task_4.studentManagement.Service.Interface;

import com.Task_4.studentManagement.Model.Subject;

import java.util.List;

public interface subjectService {
    List<Subject> getAllSubject();
    void createNewSubject(Subject newSubject);
    void deleteSubject(String subjectId);
    Subject updateSubject(Subject subjectDetails, String id );
}
