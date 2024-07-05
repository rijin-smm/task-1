package com.Task_4.studentManagement.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "BaseClass")
public class BaseClass {

    private long studentId;
    private long classId;
    private int rollNumber;
    private int rank;

    public BaseClass(long classId, long studentId, int rollNumber, int rank) {
        this.classId = classId;
        this.studentId = studentId;
        this.rollNumber = rollNumber;
        this.rank = rank;
    }

    public long getClassId() {
        return classId;
    }

    public void setClassId(long classId) {
        this.classId = classId;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
