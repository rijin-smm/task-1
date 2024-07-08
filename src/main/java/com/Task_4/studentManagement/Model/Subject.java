package com.Task_4.studentManagement.Model;


import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "subject")
public class Subject {

    @Transient
    public static final String SEQUENCE_NAME = "subject_sequence";

    @Id
    private long id;
    private String subjectName;

    public Subject(long id, String subjectName) {
        this.id = id;
        this.subjectName = subjectName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
}
