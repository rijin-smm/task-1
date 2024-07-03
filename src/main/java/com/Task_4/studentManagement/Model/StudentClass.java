package com.Task_4.studentManagement.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "student_class")
public class StudentClass {

    @Transient
    public static final String SEQUENCE_NAME = "studentClass_sequence";

    @Id
    private long classId;
    private String teacherId;
    private String className;

    public StudentClass() {
    }

    public StudentClass(long classId, String teacherId, String className) {
        this.classId = classId;
        this.teacherId = teacherId;
        this.className = className;
    }

    public long getClassId() {
        return classId;
    }

    public void setClassId(long classId) {
        this.classId = classId;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
