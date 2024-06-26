package com.Task_4.studentManagement.Service;

import com.Task_4.studentManagement.Model.Mark;
import com.Task_4.studentManagement.Model.Student;
import com.Task_4.studentManagement.Repository.StudentRepo;
import com.Task_4.studentManagement.Repository.markRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class markService {

    @Autowired
    private markRepo mr;
    @Autowired
    private StudentRepo studentRepository;

    public List<Mark> getAllMark() {
        return mr.findAll();
    }

    public void addMark(Mark mark) {
        mr.save(mark);
    }

    public void deleteMark(String mark_id) {
        mr.deleteById(mark_id);
    }

    public void updateMark(Mark updatedMark, String markId) {
        mr.findById(markId).map(marks -> {
            marks.setMarkId(updatedMark.getMarkId());
            marks.setStudentName(updatedMark.getStudentName());
            marks.setSubjectName(updatedMark.getSubjectName());
            marks.setMarks(updatedMark.getMarks());
            return mr.save(marks);
        }).orElseThrow(() -> new RuntimeException("mark not found with id " + markId));
    }

    public List<Mark> getMarksByStudentName(String studentName) {
        List<Student> students = studentRepository.findByStudentName(studentName);
        if (students.isEmpty()) {
            throw new RuntimeException("Student not found with name " + studentName);
        }

        List<Mark> marks = new ArrayList<>();
        for (Student student : students) {
            List<Mark> studentMarks = mr.findByStudentName(student.getStudentName());
            marks.addAll(studentMarks);
        }
        return marks;
    }
}
