package com.Task_4.studentManagement.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "teacher")
public class Teacher {

    @Transient
    public static final String SEQUENCE_NAME = "teacher_sequence";

    @Id
    private long id;
    private String teacherName;
    private List<Long> teacherSubject;

    public Teacher() {
    }

    public Teacher(long id, String teacherName, List<Long> teacherSubject) {
        super();
        this.id = id;
        this.teacherName = teacherName;
        this.teacherSubject = teacherSubject;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public List<Long> getTeacherSubject() {
        return teacherSubject;
    }

    public void setTeacherSubject(List<Long> teacherSubject) {
        this.teacherSubject = teacherSubject;
    }
}
