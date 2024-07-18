package com.example.demo.Service.Implements;

import com.example.demo.DTO.AllStudentsMarksDTO;
import com.example.demo.DTO.MarkDTO;
import com.example.demo.DTO.StudentMarksDTO;
import com.example.demo.ExceptionHandler.ResourceNotFoundException;
import com.example.demo.Model.*;
import com.example.demo.Repository.*;
import com.example.demo.Service.Interface.MarkService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

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
    public void addMark(@Valid Mark mark) {
        markRepo.save(mark);
    }

    @Override
    public void deleteMark(long id) {
        Optional<Mark> mark = markRepo.findById(id);
        if(!mark.isPresent()){
            throw new ResourceNotFoundException("mark not found with id: " + id);
        }
        markRepo.deleteById(id);
    }

    @Override
    public void updateMark(@Valid Mark newMark, long id) {
        Optional<Mark> mark = markRepo.findById(id);
        if (mark.isPresent()){
            Mark existingMark = mark.get();
            existingMark.setMarks(newMark.getMarks());
            existingMark.setStudent(newMark.getStudent());
            existingMark.setSubject(newMark.getSubject());
            markRepo.save(existingMark);
        }
        else{
            throw new ResourceNotFoundException("mark not found with id: " + id);
        }
    }

    @Override
    public StudentMarksDTO getMarksByStudentName(String studentName) {
        Student student= studentRepo.findByStudentName(studentName);
        if (student == null) {
            throw new ResourceNotFoundException("Student with name " + studentName + " not found");
        }
        List<Mark> marks = markRepo.findByStudentId(student.getId());

        StudentClass studentClass = (StudentClass) studentClassRepo.findByStudentId(student.getId())
                .orElseThrow(() -> new IllegalArgumentException("Student class not found for student ID " + student.getId()));

        String baseClassName = studentClass.getBaseClass().getClassName();

        Map<String,Double> marksMap = new HashMap<>();

        double totalMarks = 0.0;
        for (Mark mark: marks){
            Subject subject = subjectRepo.findById(mark.getSubject().getId()).orElseThrow(() -> new IllegalArgumentException("subject not found for ID" + mark.getSubject().getId()));
            marksMap.put(subject.getSubjectName(),mark.getMarks());
            totalMarks += mark.getMarks();
        }

        double averageMark = marks.isEmpty() ? 0.0 : totalMarks / marks.size();

        return new StudentMarksDTO(student.getStudentName(), baseClassName,averageMark, marksMap);

    }



    public List<MarkDTO> getMarksBySubjectAndClass(long subjectId, long classId) {

        List<StudentClass> studentClasses = studentClassRepo.findByBaseClassId(classId);
        if(studentClasses.isEmpty()){
            throw new ResourceNotFoundException("studentClasses with name " + classId + " not found");
        }

            List<Long> studentIds = studentClasses.stream()
                    .map(StudentClass::getStudent)
                    .map(Student::getId)
                    .collect(Collectors.toList());
            List<Mark> marks = markRepo.findBySubjectIdAndStudentIdIn(subjectId, studentIds);

            // Step 3: Map Mark entities to MarkDTO objects
            List<MarkDTO> markDTOs = marks.stream()
//                .map(mark -> new MarkDTO(mark.getStudent().getStudentName(), mark.getMarks(), mark.getSubject().getSubjectName()))
//                .collect(Collectors.toList());
                    .map(mark -> {
                        String className = studentClasses.stream()
                                .filter(sc -> sc.getStudent().getId().equals(mark.getStudent().getId()))
                                .findFirst()
                                .map(sc -> sc.getBaseClass().getClassName())
                                .orElse("");
                        return new MarkDTO(mark.getSubject().getSubjectName(), mark.getStudent().getStudentName(), className, mark.getMarks());
                    })
                    .collect(Collectors.toList());

            return markDTOs;

    }

//    @Override
//    public Optional<Mark> getMarkById(long id) {
//        Optional<Mark> mark= markRepo.findById(id);
//        if (mark == null) {
//            throw new IllegalArgumentException("Student with id " + id + " not found");
//        }
//        return mark;
//    }

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


            List<Mark> studentMarksList = markRepo.findByStudentId(student.getId());
            double totalMarks = studentMarksList.stream()
                    .mapToDouble(Mark::getMarks)
                    .sum();
            double averageMark = studentMarksList.isEmpty() ? 0.0 : totalMarks / studentMarksList.size();
            allStudentsMarksDTO.setAvgMark(averageMark);


            Map<String , Double> marks = new HashMap<>();


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

    @Override
    public List<AllStudentsMarksDTO> getMarksByStudentClassId(long id){
        List<StudentClass> studentClassList = studentClassRepo.findByBaseClassId(id);
        if(studentClassList.isEmpty()){
            throw new ResourceNotFoundException("studentClass with name " + id + " not found");
        }
        List<AllStudentsMarksDTO> allStudentsMarksDTOList = new ArrayList<>();

        for (StudentClass studentClass : studentClassList){
            AllStudentsMarksDTO allStudentsMarksDTO = new AllStudentsMarksDTO();
            allStudentsMarksDTO.setStudentId(studentClass.getStudent().getId());
            allStudentsMarksDTO.setStudentName(studentClass.getStudent().getStudentName());
            allStudentsMarksDTO.setAge(studentClass.getStudent().getAge());
            allStudentsMarksDTO.setClassName(studentClass.getBaseClass().getClassName());

            Map<String, Double> marksMap = new HashMap<>();
            List<Mark> marks = markRepo.findByStudent(studentClass.getStudent());
            double totalMarks = 0.0;
            for (Mark mark : marks){
                marksMap.put(mark.getSubject().getSubjectName(),mark.getMarks());
                totalMarks += mark.getMarks();
            }
            allStudentsMarksDTO.setMarks(marksMap);
            if (!marks.isEmpty()) {
                double averageMarks = totalMarks / marks.size();
                allStudentsMarksDTO.setAvgMark(averageMarks);
            } else {
                allStudentsMarksDTO.setAvgMark(0.0); // Set default value if no marks
            }
            allStudentsMarksDTOList.add(allStudentsMarksDTO);
        }
        return allStudentsMarksDTOList;
    }

}
