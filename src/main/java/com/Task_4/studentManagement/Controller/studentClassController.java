package com.Task_4.studentManagement.Controller;


import com.Task_4.studentManagement.DTO.StudentDetailsDTO;
import com.Task_4.studentManagement.Model.BaseClass;
import com.Task_4.studentManagement.Model.studentClass;
import com.Task_4.studentManagement.Service.Interface.studentClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class studentClassController {

    @Autowired
    private studentClassService stud_ser;

    @GetMapping(path = "/studentClasses")
    public List<studentClass>  getAllStudentClass(){
        return stud_ser.getAllStudentClass();
    }

    @PostMapping(path = "/studentClass")
    public void createNewStudentClass(@RequestBody studentClass newStudentClass){
        stud_ser.createNewStudentClass(newStudentClass);
    }

    @DeleteMapping(path = "/studentClass/{id}")
    public void deleteStudentClass(@PathVariable long id){
        stud_ser.deleteStudentClass(id);
    }

    @PutMapping(path = "/studentClass/{classId}")
    public void updateStudentClass(@RequestBody studentClass updatedStudentClass, @PathVariable long id){
        stud_ser.updateStudentClass(updatedStudentClass, id);
    }

    @PostMapping("/move-to-class/{studentId}")
    public ResponseEntity<String> moveStudentToNewClass(
            @PathVariable("studentId") long studentId,
            @RequestBody("baseClass") BaseClass baseClass,
            @RequestParam("rollNumber") int rollNumber,
            @RequestParam("rank") int rank,
            @RequestParam("joiningDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date joiningDate) {

        stud_ser.moveStudentToNewClass(studentId, baseClass, rollNumber, rank, joiningDate);
        return ResponseEntity.ok("Student moved to new class successfully.");
    }


    @GetMapping("/details/{studentId}")
    public ResponseEntity<StudentDetailsDTO> getCurrentStudentDetails(@PathVariable("studentId") long studentId) {
        StudentDetailsDTO studentDetailsDTO = stud_ser.getCurrentStudentDetails(studentId);
        if (studentDetailsDTO != null) {
            return ResponseEntity.ok(studentDetailsDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
