package com.Task_4.studentManagement.Controller;

import com.Task_4.studentManagement.DTO.classMarkDTO;
import com.Task_4.studentManagement.DTO.studentMarksDTO;
import com.Task_4.studentManagement.Model.Mark;
import com.Task_4.studentManagement.Model.Student;
import com.Task_4.studentManagement.Service.Interface.markService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@Validated
public class markController {

    @Autowired
    private markService ms;

    @Autowired
    private com.Task_4.studentManagement.Service.Interface.studentClassService studentClassService;

    @GetMapping(path = "/marks")
    public List<Mark> getAllMark(){
        return ms.getAllMark();
    }

    @PostMapping(path = "/mark")
    public void addMark(@Valid @RequestBody Mark mark){
        ms.addMark(mark);

    }

    @DeleteMapping(path = "/mark/{markId}")
    public void deleteMark(@Valid @PathVariable long markId){
        ms.deleteMark(markId);
    }
//
    @PutMapping(path = "/mark/{markId}")
    public void updateMark(@Valid  @RequestBody Mark newMark, @PathVariable long markId){
        ms.updateMark(newMark, markId);
    }

    @GetMapping("/getMark/{id}")
    public Optional<Mark> getMarkById(@PathVariable long id) {
        return ms.getMarkById(id);
    }

    @GetMapping("/marks/student/{studentName}")
    public studentMarksDTO getMarksByStudentName(
            @PathVariable String studentName) {
        return ms.getMarksByStudentName(studentName);
    }

    @GetMapping(path = "/studentsMarks")
    public List<studentMarksDTO> getAllStudentMarks(){
        return ms.getAllStudentMarks();

    }

    @GetMapping(path = "studentClass/{id}")
    public List<studentMarksDTO> getMarksByStudentClassId(@PathVariable long id){
        return ms.getMarksByStudentClassId(id);

    }
}





