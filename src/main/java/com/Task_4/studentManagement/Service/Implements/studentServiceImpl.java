package com.Task_4.studentManagement.Service.Implements;

import com.Task_4.studentManagement.Model.HighestScoreStudentDTO;
import com.Task_4.studentManagement.Model.Mark;
import com.Task_4.studentManagement.Model.Student;
import com.Task_4.studentManagement.Model.StudentClass;
import com.Task_4.studentManagement.Repository.StudentRepo;
import com.Task_4.studentManagement.Repository.markRepo;
import com.Task_4.studentManagement.Repository.studentClassRepo;
import com.Task_4.studentManagement.Service.Interface.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class studentServiceImpl implements studentService {


    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private StudentRepo sr;
    private List<Student> students = new ArrayList<>();

    @Autowired
    private markRepo mr;

    @Autowired
    private studentClassRepo scr;

    @Autowired
    private com.Task_4.studentManagement.Service.Interface.sequenceGeneratorService sequenceGeneratorService;

    @Override
    public List<Student> getAllStudent() {
        return sr.findAll();
    }

    @Override
    public void addStudent(Student newStudent){
        newStudent.setId(sequenceGeneratorService.generateSequence(newStudent.SEQUENCE_NAME));
        sr.save(newStudent);
    }

    @Override
    public void updateStudent(Student updatedStudent, long id) {
        sr.findById(id).map(student -> {
            student.setStudentName(updatedStudent.getStudentName());
            student.setClassId(updatedStudent.getClassId());
            return sr.save(student);
        }).orElseThrow(() -> new RuntimeException("Student not found with id " + id));
    }


    @Override
    public void deleteStudent(long id) {
        sr.deleteById(id);
    }

    @Override
    public Student getStudentByname(String studentName) {
        return sr.findByStudentName(studentName);
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

    @Override
    public List<HighestScoreStudentDTO> getStudentsWithFirstRank() {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.group("studentId")
                        .avg("marks").as("averageMarks"),
                Aggregation.sort(Sort.Direction.DESC, "averageMarks"),
                Aggregation.lookup("student", "_id", "_id", "studentDetails"),
                Aggregation.unwind("studentDetails"),
                Aggregation.project()
                        .andExpression("studentDetails.classId").as("classId")
                        .and("studentDetails").as("highestScoredStudent"),
                Aggregation.group("classId")
                        .first("highestScoredStudent").as("highestScoredStudent")
        );

        AggregationResults<HighestScoreStudentDTO> results = mongoTemplate.aggregate(
                aggregation, "marks", HighestScoreStudentDTO.class);

        return results.getMappedResults();
    }

    }

