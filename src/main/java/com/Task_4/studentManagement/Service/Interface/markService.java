package com.Task_4.studentManagement.Service.Interface;

import com.Task_4.studentManagement.Model.Mark;

import java.util.List;

public interface markService {
    List<Mark> getAllMark();
    void addMark(Mark mark);
    void deleteMark(long markId);
    void updateMark(Mark newMark, long markId);
//    List<Mark> getMarksByStudentName(String studentName);
}
