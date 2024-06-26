package com.Task_4.studentManagement.Controller;

import com.Task_4.studentManagement.Model.Mark;
import com.Task_4.studentManagement.Service.markService;
import com.Task_4.studentManagement.Service.studentClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class markController {

    @Autowired
    private markService ms;

    @Autowired
    private com.Task_4.studentManagement.Service.studentClassService studentClassService;

    @GetMapping(path = "/marks")
    public List<Mark> getAllMark(){
        return ms.getAllMark();
    }

    @PostMapping(path = "/marks")
    public void addMark(@RequestBody Mark mark){
        ms.addMark(mark);

    }

    @DeleteMapping(path = "/marks/{markId}")
    public void deleteMark(@PathVariable String markId){
        ms.deleteMark(markId);
    }

    @PutMapping(path = "/marks/{markId}")
    public void updateMark(@RequestBody Mark mark, @PathVariable String markId){
        ms.updateMark(mark,markId);
    }


    @GetMapping("/student/{studentName}")
    public List<Mark> getMarksByStudentName(
            @PathVariable String studentName) {
        return ms.getMarksByStudentName(studentName);
    }
}
