package com.Task_4.studentManagement.Model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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

    @NotEmpty(message = "Class name must not be empty")
    @NotNull(message = "Class name must not be empty")
    private String className;

    @DBRef
    @NotNull(message = "Teacher must not be null")
    @NotBlank(message = "Teacher must not be null")
    @Valid
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
