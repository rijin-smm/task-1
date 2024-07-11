package com.Task_4.studentManagement.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class StudentDetailsDTO {
    private String studentName;
    private int age;
    private int rollNumber;
    private int rank;
    private String className;
    private String teacherName;
//    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date classJoiningDate;

    public StudentDetailsDTO() {
    }

    public StudentDetailsDTO(String studentName, int age, int rollNumber, int rank, String className, String teacherName, Date classJoiningDate) {
        this.studentName = studentName;
        this.age = age;
        this.rollNumber = rollNumber;
        this.rank = rank;
        this.className = className;
        this.teacherName = teacherName;
        this.classJoiningDate = classJoiningDate;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Date getClassJoiningDate() {
        return classJoiningDate;
    }

    public void setClassJoiningDate(Date classJoiningDate) {
        this.classJoiningDate = classJoiningDate;
    }
}
