package com.example.demo.Service.Implements;

import com.example.demo.DTO.AllStudentsMarksDTO;
import com.example.demo.DTO.StudentMarksDTO;
import com.example.demo.Model.*;
import com.example.demo.Repository.*;
import com.example.demo.Service.Interface.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MarkServiceImpl implements MarkService {
    @Autowired
    private MarkRepo markRepo;

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private SubjectRepo subjectRepo;

    @Autowired
    private StudentClassRepo studentClassRepo;

    @Override
    public List<Mark> getAllMark() {
        return markRepo.findAll();
    }

    @Override
    public void addMark(Mark mark) {
        markRepo.save(mark);
    }

    @Override
    public void deleteMark(long markId) {
        markRepo.deleteById(markId);
    }

    @Override
    public void updateMark(Mark newMark, long markId) {
        Optional<Mark> mark = markRepo.findById(markId);
        if (mark.isPresent()){
            Mark existingMark = mark.get();
            existingMark.setMarks(newMark.getMarks());
            existingMark.setStudent(newMark.getStudent());
            existingMark.setSubject(newMark.getSubject());
            markRepo.save(existingMark);
        }
    }

    @Override
    public StudentMarksDTO getMarksByStudentName(String studentName) {
        Student student= studentRepo.findByStudentName(studentName);
        if (student == null) {
            throw new IllegalArgumentException("Student with name " + studentName + " not found");
        }
        List<Mark> marks = markRepo.findByStudentId(student.getId());
        Map<String,Double> marksMap = new HashMap<>();

        for (Mark mark: marks){
            Subject subject = subjectRepo.findById(mark.getSubject().getId()).orElseThrow(() -> new IllegalArgumentException("subject not found for ID" + mark.getSubject().getId()));
            marksMap.put(subject.getSubjectName(),mark.getMarks());
        }
        StudentClass studentClass = (StudentClass) studentClassRepo.findByStudentId(student.getId())
                .orElseThrow(() -> new IllegalArgumentException("Student class not found for student ID " + student.getId()));

        String baseClassName = studentClass.getBaseClass().getClassName();
        return new StudentMarksDTO(student.getStudentName(), baseClassName, marksMap);

    }


    @Override
    public Optional<Mark> getMarkById(long id) {
        Optional<Mark> mark= markRepo.findById(id);
        if (mark == null) {
            throw new IllegalArgumentException("Student with id " + id + " not found");
        }
        return mark;
    }

    @Override
    public List<AllStudentsMarksDTO> getAllStudentMarks(){
        List<Student> students = studentRepo.findAll();
        List<AllStudentsMarksDTO> allStudentMarksDTOList = new ArrayList<>();

        for (Student student : students){
            AllStudentsMarksDTO allStudentsMarksDTO = new AllStudentsMarksDTO();
            allStudentsMarksDTO.setStudentId(student.getId());
            allStudentsMarksDTO.setStudentName(student.getStudentName());
            allStudentsMarksDTO.setAge(student.getAge());

            // Fetch student's class details from StudentClass entity
            StudentClass studentClass = (StudentClass) studentClassRepo.findByStudentId(student.getId())
                    .orElseThrow(() -> new IllegalArgumentException("Student class not found for student ID " + student.getId()));

            // Set class name from BaseClass entity
            String baseClassName = studentClass.getBaseClass().getClassName();
            allStudentsMarksDTO.setClassName(baseClassName);

            Map<String , Double> marks = new HashMap<>();
            List<Mark> studentMarksList = markRepo.findByStudentId(student.getId());

            for (Mark mark : studentMarksList) {
                Subject subject = subjectRepo.findById(mark.getSubject().getId())
                        .orElseThrow(() -> new IllegalArgumentException("Subject not found for ID " + mark.getSubject().getId()));
                marks.put(subject.getSubjectName(), mark.getMarks());
            }
            allStudentsMarksDTO.setMarks(marks);

            allStudentMarksDTOList .add(allStudentsMarksDTO);
        }
        return allStudentMarksDTOList;
    }

//    @Override
//    public  List<Mark> getMarksByStudentClassId(long id){
//        Optional<StudentClass> optionalStudentClass = studentClassRepo.findById(id);
//
//        if (!optionalStudentClass.isPresent()) {
//            // Handle scenario where student with given id is not found
//            return Collections.emptyList(); // or throw an exception
//        }
//        StudentClass List<StudentClass> = optionalStudentClass.get();
//        return markRepo.findByStudent(student);
//    }

}
