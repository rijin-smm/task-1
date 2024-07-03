package com.Task_4.studentManagement.Controller;

import com.Task_4.studentManagement.Model.Mark;
import com.Task_4.studentManagement.Service.Interface.markService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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
    public void addMark(@RequestBody Mark mark){
        ms.addMark(mark);

    }

    @DeleteMapping(path = "/mark/{markId}")
    public void deleteMark(@PathVariable long markId){
        ms.deleteMark(markId);
    }
//
    @PutMapping(path = "/mark/{markId}")
    public void updateMark(@RequestBody Mark newMark, @PathVariable long markId){
        ms.updateMark(newMark, markId);
    }


//    @GetMapping("/student/{studentName}")
//    public List<Mark> getMarksByStudentName(
//            @PathVariable String studentName) {
//        return ms.getMarksByStudentName(studentName);
//    }
}
