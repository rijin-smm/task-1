package com.Task_4.studentManagement.Model;

public class HighestScoreStudentDTO {

    private Student highestScoredStudent;

    public HighestScoreStudentDTO(Student highestScoredStudent) {
        this.highestScoredStudent = highestScoredStudent;
//        this.averageMarks = averageMarks;
    }

    public Student getHighestScoredStudent() {
        return highestScoredStudent;
    }

    public void setHighestScoredStudent(Student highestScoredStudent) {
        this.highestScoredStudent = highestScoredStudent;
    }
}