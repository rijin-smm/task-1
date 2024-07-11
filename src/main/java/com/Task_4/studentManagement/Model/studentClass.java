package com.Task_4.studentManagement.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Document(collection = "studentClass")
public class studentClass {

    @Transient
    public static final String SEQUENCE_NAME = "student_class_sequence";

    @Id
    private long id;

    private int rollNumber;
    private int rank;

//    @DateTimeFormat(pattern = "dd-MM-yyyy")

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date classJoiningDate;

//    @DateTimeFormat(pattern = "dd-MM-yyyy")

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date classLeavingDate;

    @DBRef
    private Student student;

    @DBRef
    private BaseClass baseClass;

    public studentClass(int rollNumber, int rank, Date classJoiningDate, Date classLeavingDate, Student student, BaseClass baseClass) {
        this.rollNumber = rollNumber;
        this.rank = rank;
        this.classJoiningDate = classJoiningDate;
        this.classLeavingDate = classLeavingDate;
        this.student = student;
        this.baseClass = baseClass;
    }

    public studentClass() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public BaseClass getBaseClass() {
        return baseClass;
    }

    public void setBaseClass(BaseClass baseClass) {
        this.baseClass = baseClass;
    }

    public Date getClassJoiningDate() {
        return classJoiningDate;
    }

    public void setClassJoiningDate(Date classJoiningDate) {
        this.classJoiningDate = classJoiningDate;
    }

    public Date getClassLeavingDate() {
        return classLeavingDate;
    }

    public void setClassLeavingDate(Date classLeavingDate) {
        this.classLeavingDate = classLeavingDate;
    }

}
