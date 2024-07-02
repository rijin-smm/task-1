package com.Task_4.studentManagement.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "student_class")
public class StudentClass {
    @Id
    private long classId;
    private String teacher;
    private String className;

    public StudentClass() {
    }

    public StudentClass(long classId, String teacher, String className) {
        this.classId = classId;
        this.teacher = teacher;
        this.className = className;
    }


    public long getClassId() {
        return classId;
    }

    public void setClassId(long classId) {
        this.classId = classId;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
