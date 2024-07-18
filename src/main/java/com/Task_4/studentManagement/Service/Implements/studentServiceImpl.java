package com.Task_4.studentManagement.Service.Implements;

import com.Task_4.studentManagement.Model.BaseClass;
import com.Task_4.studentManagement.Model.HighestScoreStudentDTO;
import com.Task_4.studentManagement.Model.Student;
import com.Task_4.studentManagement.Repository.StudentRepo;
import com.Task_4.studentManagement.Repository.baseClassRepo;
import com.Task_4.studentManagement.Repository.markRepo;
import com.Task_4.studentManagement.Repository.studentClassRepo;
import com.Task_4.studentManagement.Service.Interface.studentService;
import com.example.demo.ExceptionHandler.ResourceNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Validated
public class studentServiceImpl implements studentService {


    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private StudentRepo sr;

    @Autowired
    private markRepo mr;

    @Autowired
    private baseClassRepo br;

    @Autowired
    private studentClassRepo scr;

    @Autowired
    private com.Task_4.studentManagement.Service.Interface.sequenceGeneratorService sequenceGeneratorService;

    @Override
    public List<Student> getAllStudent() {
        return sr.findAll();
    }

    @Override
    public void addStudent(@Valid Student newStudent){
        newStudent.setId(sequenceGeneratorService.generateSequence(newStudent.SEQUENCE_NAME));
        sr.save(newStudent);
    }

    @Override
    public void updateStudent(@Valid Student updatedStudent, long id) {
        Optional<Student> student = sr.findById(id);
        if(student.isPresent()){
            Student existingStudent = student.get();
            existingStudent.setStudentName(updatedStudent.getStudentName());
            sr.save(existingStudent);
        }
        else{
            ResponseEntity.notFound().build();
        }
    }

    @Override
    public void deleteStudent(long id) {
        sr.deleteById(id);
    }

    @Override
    public Student getStudentByname(String studentName) {
        Student student = sr.findByStudentName(studentName);
        if (student == null){
            throw new ResourceNotFoundException("student name "+ studentName +" is not found");
        }
        return student;
    }

//    @Override
//    public List<HighestScoreStudentDTO> getStudentsWithFirstRank() {
//        Aggregation aggregation = Aggregation.newAggregation(
//                Aggregation.group("studentId")
//                        .avg("marks").as("averageMarks"),
//                Aggregation.sort(Sort.Direction.DESC, "averageMarks"),
//                Aggregation.lookup("student", "_id", "_id", "studentDetails"),
//                Aggregation.unwind("studentDetails"),
//                Aggregation.project()
//                        .and("studentDetails").as("highestScoredStudent")
//                        .and("averageMarks").as("averageMarks"),
//                Aggregation.group()
//                        .first("highestScoredStudent").as("highestScoredStudent")
//                        .first("averageMarks").as("averageMarks")
//        );
//
//        AggregationResults<HighestScoreStudentDTO> results = mongoTemplate.aggregate(
//                aggregation, "marks", HighestScoreStudentDTO.class);
//
//        // Adjust the structure to nest averageMarks inside highestScoredStudent
//        results.getMappedResults().forEach(dto -> {
//            dto.getHighestScoredStudent().setAverageMarks(dto.getAverageMarks());
//        });
//
//        return results.getMappedResults();
//    }
//
//    @Override
//    public List<HighestScoreStudentDTO> getStudentsWithFirstRank() {
//        Aggregation aggregation = Aggregation.newAggregation(
//                Aggregation.group("studentId")
//                        .avg("marks").as("averageMarks"),
//                Aggregation.sort(Sort.Direction.DESC, "averageMarks"),
//                Aggregation.lookup("student", "_id", "_id", "studentDetails"),
//                Aggregation.unwind("studentDetails"),
//                Aggregation.project()
//                        .andExpression("studentDetails.classId").as("classId")
//                        .and("studentDetails").as("highestScoredStudent"),
//                Aggregation.group("classId")
//                        .first("highestScoredStudent").as("highestScoredStudent")
//        );
//
//        AggregationResults<HighestScoreStudentDTO> results = mongoTemplate.aggregate(
//                aggregation, "marks", HighestScoreStudentDTO.class);
//
//        return results.getMappedResults();
//    }

    }

