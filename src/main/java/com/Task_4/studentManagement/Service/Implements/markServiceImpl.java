package com.Task_4.studentManagement.Service.Implements;

import com.Task_4.studentManagement.Model.Mark;
import com.Task_4.studentManagement.Model.Student;
import com.Task_4.studentManagement.Repository.StudentRepo;
import com.Task_4.studentManagement.Repository.markRepo;
import com.Task_4.studentManagement.Service.Interface.markService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class markServiceImpl implements markService {

    @Autowired
    private markRepo mr;
    @Autowired
    private StudentRepo studentRepository;

    @Autowired
    private com.Task_4.studentManagement.Service.Interface.sequenceGeneratorService sequenceGeneratorService;

    @Override
    public List<Mark> getAllMark() {
        return mr.findAll();
    }

    @Override
    public void addMark(Mark mark) {
        mark.setMarkId(sequenceGeneratorService.generateSequence(mark.SEQUENCE_NAME));
        mr.save(mark);
    }

    @Override
    public void deleteMark(long markId) {
        mr.deleteById(markId);
    }

    @Override
    public void updateMark(Mark newMark, long markId) {
        mr.findById(markId).map(marks -> {
            marks.setStudentId(newMark.getStudentId());
            marks.setSubjectId(newMark.getSubjectId());
            marks.setMarks(newMark.getMarks());
            return mr.save(marks);
        }).orElseThrow(() -> new RuntimeException("mark not found with id " + markId));

    }

//    @Override
//    public List<Mark> getMarksByStudentName(String studentName) {
//        List<Student> students = studentRepository.findByStudentName(studentName);
//        if (students.isEmpty()) {
//            throw new RuntimeException("Student not found with name " + studentName);
//        }
//
//        List<Mark> marks = new ArrayList<>();
//        for (Student student : students) {
//            List<Mark> studentMarks = mr.findByStudentName(student.getStudentName());
//            marks.addAll(studentMarks);
//        }
//        return marks;
//    }

}
