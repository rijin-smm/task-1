package com.Task_4.studentManagement.Model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @NotNull(message = "Marks must not be null")
    private double marks;

    @DBRef
    @NotNull(message = "Student must not be null")
    @Valid
    private Student student;

    @DBRef
    @NotNull(message = "Subject must not be null")
    @Valid
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

