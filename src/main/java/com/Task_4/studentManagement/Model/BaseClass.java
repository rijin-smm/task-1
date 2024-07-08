package com.Task_4.studentManagement.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "base_class")
public class BaseClass {

    @Transient
    public static final String SEQUENCE_NAME = "BaseClass_sequence";

    @Id
    private long id;
    private String className;

    @DBRef
    private Teacher teacher;

    public BaseClass() {
    }

    public BaseClass(long id, Teacher teacher, String className) {
        this.id = id;
        this.teacher = teacher;
        this.className = className;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
