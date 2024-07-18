package com.Task_4.studentManagement.Service.Interface;

import com.Task_4.studentManagement.Model.Subject;
import jakarta.validation.Valid;

import java.util.List;

public interface subjectService {
    List<Subject> getAllSubject();
    void createNewSubject(@Valid Subject newSubject);
    void deleteSubject(@Valid long subjectId);
    Subject updateSubject(@Valid Subject subjectDetails, long subjectId );
}
