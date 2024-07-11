package com.Task_4.studentManagement.Service.Implements;

import com.Task_4.studentManagement.DTO.classMarkDTO;
import com.Task_4.studentManagement.DTO.studentMarksDTO;
import com.Task_4.studentManagement.Model.Mark;
import com.Task_4.studentManagement.Model.Student;
import com.Task_4.studentManagement.Repository.StudentRepo;
import com.Task_4.studentManagement.Repository.markRepo;
import com.Task_4.studentManagement.Repository.subjectRepo;
import com.Task_4.studentManagement.Service.Interface.markService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.ls.LSInput;

import java.util.*;

@Service
public class markServiceImpl implements markService {

    @Autowired
    private markRepo mr;

    @Autowired
    private StudentRepo sr;

    @Autowired
    private subjectRepo subjectRepo;

    @Autowired
    private com.Task_4.studentManagement.Service.Interface.sequenceGeneratorService sequenceGeneratorService;

    @Override
    public List<Mark> getAllMark() {
        return mr.findAll();
    }

    @Override
    public void addMark(Mark mark) {
        mark.setId(sequenceGeneratorService.generateSequence(mark.SEQUENCE_NAME));
        mr.save(mark);
    }

    @Override
    public void deleteMark(long markId) {
        mr.deleteById(markId);
    }

    @Override
    public void updateMark(Mark newMark, long markId) {
        Optional<Mark> mark = mr.findById(markId);
        if (mark.isPresent()){
            Mark existingMark = mark.get();
            existingMark.setMarks(newMark.getMarks());
            existingMark.setStudent(newMark.getStudent());
            existingMark.setSubject(newMark.getSubject());
            mr.save(existingMark);
        }
    }

    @Override
    public List<Mark> getMarksByStudentName(String studentName) {
        Student student= sr.findByStudentName(studentName);
        if (student == null) {
            throw new IllegalArgumentException("Student with name " + studentName + " not found");
        }
        return mr.findByStudentId(student.getId());
    }


    @Override
    public Optional<Mark> getMarkById(long id) {
        Optional<Mark> mark= mr.findById(id);
        if (mark == null) {
            throw new IllegalArgumentException("Student with id " + id + " not found");
        }
        return mark;
    }

    @Override
    public List<studentMarksDTO> getAllStudentMarks(){
        List<Student> students = sr.findAll();
        List<studentMarksDTO> studentMarksDTOList = new ArrayList<>();

        for (Student student : students){
            studentMarksDTO studentMarksDTOs = new studentMarksDTO();
            studentMarksDTOs.setStudentId(student.getId());
            studentMarksDTOs.setStudentName(student.getStudentName());
            studentMarksDTOs.setAge(student.getAge());

            Map<String , Double> marks = new HashMap<>();
            List<Mark> studentMarksList = mr.findByStudent(student);

            for (Mark mark : studentMarksList) {
                marks.put(mark.getSubject().getSubjectName(), mark.getMarks());
            }
            studentMarksDTOs.setMarks(marks);

            studentMarksDTOList.add(studentMarksDTOs);
        }
        return studentMarksDTOList;
    }


    public  List<Mark> getMarksByStudentClassId(long id){
        Optional<Student> optionalStudent = sr.findById(id);

        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            return mr.findByStudent(student);
        } else {
            // Handle scenario where student with given id is not found
            return Collections.emptyList(); // or throw an exception
        }
    }


}
