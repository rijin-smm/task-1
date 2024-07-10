package com.example.demo.Service.Interface;

import com.example.demo.DTO.AllStudentsMarksDTO;
import com.example.demo.DTO.StudentMarksDTO;
import com.example.demo.Model.Mark;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface MarkService {
    List<Mark> getAllMark();
    void addMark(Mark mark);
    void deleteMark(long markId);
    void updateMark(Mark newMark, long markId);
    StudentMarksDTO getMarksByStudentName(String studentName);

    Optional<Mark> getMarkById(long id);
    List<AllStudentsMarksDTO> getAllStudentMarks();

    List<Mark> getMarksByStudentClassId(long id);
}
