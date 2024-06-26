package com.Task_4.studentManagement.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "teacher")
public class Teacher {
    @Id
    private String teacher_id;
    private String teacher_name;
    private String teacherSubject;


    public Teacher() {
    }

    public Teacher(String teacher_id, String teacher_name, String teacherSubject) {
        super();
        this.teacher_id = teacher_id;
        this.teacher_name = teacher_name;
        this.teacherSubject = teacherSubject;
    }


    public String getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(String teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public String getTeacherSubject() {
        return teacherSubject;
    }

    public void setTeacherSubject(String teacherSubject) {
        this.teacherSubject = teacherSubject;
    }
}
