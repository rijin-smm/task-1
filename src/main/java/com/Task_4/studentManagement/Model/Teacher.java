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
    private long teacherId;
    private String teacherName;
    private List<Integer> teacherSubject;


    public Teacher() {
    }

    public Teacher(long teacherId, String teacherName, List<Integer> teacherSubject) {
        super();
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.teacherSubject = teacherSubject;
    }


    public long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public List<Integer> getTeacherSubject() {
        return teacherSubject;
    }

    public void setTeacherSubject(List<Integer> teacherSubject) {
        this.teacherSubject = teacherSubject;
    }
}
