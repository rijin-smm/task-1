package com.Task_4.studentManagement.Service.Interface;

import com.Task_4.studentManagement.DTO.classMarkDTO;
import com.Task_4.studentManagement.DTO.studentMarksDTO;
import com.Task_4.studentManagement.Model.Mark;
import com.Task_4.studentManagement.Model.Student;
import jakarta.validation.Valid;

import java.util.*;

public interface markService {
    List<Mark> getAllMark();
    void addMark(@Valid Mark mark);
    void deleteMark(long markId);
    void updateMark(@Valid Mark newMark, long markId);
    studentMarksDTO getMarksByStudentName(String studentName);

    Optional<Mark> getMarkById(long id);
    List<studentMarksDTO> getAllStudentMarks();

    List<studentMarksDTO> getMarksByStudentClassId(long id);
}





