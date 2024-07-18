package com.Task_4.studentManagement.Service.Implements;

import com.Task_4.studentManagement.DTO.classMarkDTO;
import com.Task_4.studentManagement.DTO.studentMarksDTO;
import com.Task_4.studentManagement.Model.BaseClass;
import com.Task_4.studentManagement.Model.Mark;
import com.Task_4.studentManagement.Model.Student;
import com.Task_4.studentManagement.Model.studentClass;
import com.Task_4.studentManagement.Repository.*;
import com.Task_4.studentManagement.Service.Interface.markService;
import com.example.demo.ExceptionHandler.ResourceNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.w3c.dom.ls.LSInput;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Validated
public class markServiceImpl implements markService {

    @Autowired
    private markRepo mr;

    @Autowired
    private StudentRepo sr;

    @Autowired
    private baseClassRepo br;

    @Autowired
    private studentClassRepo sc_repo;

    @Autowired
    private subjectRepo subjectRepo;

    @Autowired
    private com.Task_4.studentManagement.Service.Interface.sequenceGeneratorService sequenceGeneratorService;

    @Override
    public List<Mark> getAllMark() {
        return mr.findAll();
    }

    @Override
    public void addMark(@Valid Mark mark) {
        mark.setId(sequenceGeneratorService.generateSequence(mark.SEQUENCE_NAME));
        mr.save(mark);
    }

    @Override
    public void deleteMark(long markId) {
        mr.deleteById(markId);
    }

    @Override
    public void updateMark(@Valid Mark newMark, long id) {
        Optional<Mark> mark = mr.findById(id);
        if (mark.isPresent()){
            Mark existingMark = mark.get();
            existingMark.setMarks(newMark.getMarks());
            existingMark.setStudent(newMark.getStudent());
            existingMark.setSubject(newMark.getSubject());
            mr.save(existingMark);
        }
    }

    @Override
    public studentMarksDTO getMarksByStudentName(String studentName) {
        if (!studentName.matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException("Student name must be in string format");
        }
        Student student= sr.findByStudentName(studentName);
        if (student == null) {
            throw new ResourceNotFoundException("Student with name " + studentName + " not found");
        }

        studentMarksDTO studentMarksDTOs = new studentMarksDTO();
        studentMarksDTOs.setStudentId(student.getId());
        studentMarksDTOs.setStudentName(student.getStudentName());
        studentMarksDTOs.setAge(student.getAge());

        studentClass studentClassEntity = sc_repo.findByStudent(student);
        if (studentClassEntity != null) {
            // Fetch BaseClass using studentClass
            BaseClass baseClass = studentClassEntity.getBaseClass();
            if (baseClass != null) {
                studentMarksDTOs.setClassName(baseClass.getClassName());
            } else {
                studentMarksDTOs.setClassName("Class not found");
            }
        } else {
            studentMarksDTOs.setClassName("StudentClass not found");
        }

        Map<String, Double> marks = new HashMap<>();
        List<Mark> studentMarksList = mr.findByStudent(student);
        double totalMarks = 0;
        int numberOfSubjects = studentMarksList.size();

        for (Mark mark : studentMarksList) {
            marks.put(mark.getSubject().getSubjectName(), mark.getMarks());
            totalMarks += mark.getMarks();
        }

        double avgMark = numberOfSubjects > 0 ? totalMarks / numberOfSubjects : 0.0;
        studentMarksDTOs.setAvgMark(avgMark);
        studentMarksDTOs.setMarks(marks);

        return studentMarksDTOs;

    }

    @Override
    public Optional<Mark> getMarkById(long id) {
        Optional<Mark> mark= mr.findById(id);
        if (!mark.isPresent()) {
            throw new ResourceNotFoundException("Student with id " + id + " not found");
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

            studentClass studentClassEntity = sc_repo.findByStudent(student);
            if (studentClassEntity != null) {
                // Fetch BaseClass using studentClass
                BaseClass baseClass = studentClassEntity.getBaseClass();
                if (baseClass != null) {
                    studentMarksDTOs.setClassName(baseClass.getClassName());
                } else {
                    studentMarksDTOs.setClassName("Class not found");
                }
            } else {
                studentMarksDTOs.setClassName("StudentClass not found");
            }


            Map<String , Double> marks = new HashMap<>();
            List<Mark> studentMarksList = mr.findByStudent(student);

            double totalMarks = 0;
            int numberOfSubjects = studentMarksList.size();

            for (Mark mark : studentMarksList) {
                marks.put(mark.getSubject().getSubjectName(), mark.getMarks());
                totalMarks += mark.getMarks();

            }
            double avgMark = numberOfSubjects > 0 ?totalMarks/numberOfSubjects : 0.0;
            studentMarksDTOs.setAvgMark(avgMark);
            studentMarksDTOs.setMarks(marks);

            studentMarksDTOList.add(studentMarksDTOs);
        }
        return studentMarksDTOList;
    }

    public  List<studentMarksDTO> getMarksByStudentClassId(long id){
        Optional<BaseClass> baseClassOptional = br.findById(id);
        System.out.println(baseClassOptional);

        if (!baseClassOptional.isPresent()) {

            throw new ResourceNotFoundException("class id : " + id + " is not available");
        }

        BaseClass baseClass = baseClassOptional.get();
        List<studentClass> studentClasses = sc_repo.findByBaseClass(baseClass);
        List<Long> studentIds = new ArrayList<>();

        for (studentClass studentClass : studentClasses) {
            studentIds.add(studentClass.getStudent().getId());
        }

        List<Student> students = sr.findByIdIn(studentIds);

        List<studentMarksDTO> studentMarksDTOList = new ArrayList<>();

        for (Student student : students) {
            studentMarksDTO studentMarksDTOs = new studentMarksDTO();
            studentMarksDTOs.setStudentId(student.getId());
            studentMarksDTOs.setStudentName(student.getStudentName());
            studentMarksDTOs.setAge(student.getAge());

            studentClass studentClassEntity = sc_repo.findByStudent(student);
            if (studentClassEntity != null) {
                // Fetch BaseClass using studentClass
                BaseClass baseClassEntity = studentClassEntity.getBaseClass();
                if (baseClassEntity != null) {
                    studentMarksDTOs.setClassName(baseClassEntity.getClassName());
                } else {
                    studentMarksDTOs.setClassName("Class not found");
                }
            } else {
                studentMarksDTOs.setClassName("StudentClass not found");
            }

            Map<String, Double> marks = new HashMap<>();
            List<Mark> studentMarksList = mr.findByStudent(student);

            double totalMarks = 0;
            int numberOfSubjects = studentMarksList.size();

            for (Mark mark : studentMarksList) {
                marks.put(mark.getSubject().getSubjectName(), mark.getMarks());
                totalMarks += mark.getMarks();

            }
            double avgMark = numberOfSubjects > 0 ? totalMarks / numberOfSubjects : 0.0;
            studentMarksDTOs.setAvgMark(avgMark);
            studentMarksDTOs.setMarks(marks);

            studentMarksDTOList.add(studentMarksDTOs);
        }
            return studentMarksDTOList;

    }


}
