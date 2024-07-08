package com.Task_4.studentManagement.Service.Interface;

import com.Task_4.studentManagement.DTO.classMarkDTO;
import com.Task_4.studentManagement.DTO.studentMarksDTO;
import com.Task_4.studentManagement.Model.Mark;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface markService {
    List<Mark> getAllMark();
    void addMark(Mark mark);
    void deleteMark(long markId);
    void updateMark(Mark newMark, long markId);
    List<Mark> getMarksByStudentName(String studentName);

    Optional<Mark> getMarkById(long id);
    List<studentMarksDTO> getAllStudentMarks();

    List<Mark> getMarksByStudentClassId(long id);
}
