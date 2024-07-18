package com.Task_4.studentManagement.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
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

    @NotNull(message = "Roll number must not be null")
    @Min(value = 1, message = "Roll number must be greater than 0")
    private int rollNumber;

    @Min(value = 1, message = "rank number must be greater than 0")
    private int rank;

//    @DateTimeFormat(pattern = "dd-MM-yyyy")

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date classJoiningDate;

//    @DateTimeFormat(pattern = "dd-MM-yyyy")

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date classLeavingDate;

    @DBRef
    @NotNull(message = "Student must not be null")
    @Valid
    private Student student;

    @DBRef
    @NotNull(message = "BaseClass must not be null")
    @Valid
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
