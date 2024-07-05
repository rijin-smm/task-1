package com.Task_4.studentManagement.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "marks")
public class Mark {

    @Transient
    public static final String SEQUENCE_NAME = "mark_sequence";

    @Id
    private long markId;
    private double marks;


    private long studentId;

    private long subjectId;



    public Mark() {
    }

    public Mark(long subjectId, double marks, long studentId) {
        this.subjectId = subjectId;
        this.marks = marks;
        this.studentId = studentId;
    }

    public long getMarkId() {
        return markId;
    }

    public void setMarkId(long markId) {
        this.markId = markId;
    }

    public long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(long subjectId) {
        this.subjectId = subjectId;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    }

