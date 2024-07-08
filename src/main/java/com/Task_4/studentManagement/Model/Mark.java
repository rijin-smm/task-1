package com.Task_4.studentManagement.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "marks")
public class Mark {

    @Transient
    public static final String SEQUENCE_NAME = "mark_sequence";

    @Id
    private long id;
    private double marks;

    @DBRef
    private Student student;

    @DBRef
    private Subject subject;

    public Mark() {
    }

    public Mark(Subject subject, double marks, Student student) {
        this.subject = subject;
        this.marks = marks;
        this.student = student;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}

