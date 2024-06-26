package com.Task_4.studentManagement.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "student")
public class Student {
    @Id
    private String studentId;
    private int rollNo;
    private String studentName;
    private String rank;
    private String studentClass;


    public Student() {
    }

    public Student(String studentId, int rollNo, String studentName, String rank, String studentClass) {
        super();
        this.studentId = studentId;
        this.rollNo = rollNo;
        this.studentName = studentName;
        this.rank = rank;
        this.studentClass = studentClass;
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }
}
