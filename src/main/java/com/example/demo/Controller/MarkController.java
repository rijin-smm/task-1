package com.example.demo.Controller;

import com.example.demo.DTO.AllStudentsMarksDTO;
import com.example.demo.DTO.MarkDTO;
import com.example.demo.DTO.StudentMarksDTO;
import com.example.demo.Model.Mark;
import com.example.demo.Service.Interface.MarkService;
import com.example.demo.Service.Interface.StudentClassService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

//import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@Validated
public class MarkController {
    @Autowired
    private MarkService markService;

    @Autowired
    private StudentClassService studentClassService;

    @GetMapping(path = "/marks")
    public List<Mark> getAllMark(){
        return markService.getAllMark();
    }

    @PostMapping(path = "/mark")
    public void addMark(@Valid @RequestBody Mark mark){
        markService.addMark(mark);

    }

    @DeleteMapping(path = "/mark/{id}")
    public void deleteMark(@PathVariable long id){
        markService.deleteMark(id);
    }
    //
    @PutMapping(path = "/mark/{id}")
    public void updateMark(@RequestBody Mark newMark, @PathVariable long id){
        markService.updateMark(newMark, id);
    }


//have to modify this below code
    @GetMapping("/marks/subject/{subjectId}/class/{classId}")
    public ResponseEntity<List<MarkDTO>> getMarksBySubjectAndClass(@PathVariable long subjectId, @PathVariable long classId) {
        List<MarkDTO> marks = markService.getMarksBySubjectAndClass(subjectId, classId);
        return ResponseEntity.ok(marks);

    }




    @GetMapping("/marks/student/{studentName}")
    public StudentMarksDTO getMarksByStudentName(
            @PathVariable String studentName) {
        return markService.getMarksByStudentName(studentName);
    }

    @GetMapping(path = "/allStudentsMarks")
    public List<AllStudentsMarksDTO> getAllStudentMarks(){
        return markService.getAllStudentMarks();

    }

    @GetMapping(path = "allStudentClassMarks/{id}")
    public List<AllStudentsMarksDTO> getMarksByStudentClassId(@PathVariable long id){
        return markService.getMarksByStudentClassId(id);

    }
}
