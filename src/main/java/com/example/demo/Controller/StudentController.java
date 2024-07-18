package com.example.demo.Controller;


import com.example.demo.ExceptionHandler.ResourceNotFoundException;
import com.example.demo.Model.Student;
import com.example.demo.Service.Interface.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

//import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@Validated
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping(path = "/student")
    public ResponseEntity<String> addStudent(@Valid @RequestBody Student student){
        studentService.addStudent(student);
        return ResponseEntity.ok("Student added successfully");
    }

    @GetMapping(path = "/students")
    public List<Student> getAllStudent(){
        return studentService.getAllStudent();
    }
//
    @PutMapping(path = "/student/{id}")
    public void updateStudent(@RequestBody @Valid Student updatedStudent, @PathVariable long id){
        studentService.updateStudent(updatedStudent,id);
    }

    @DeleteMapping(path = "/student/{id}")
    public void deleteStudent(@PathVariable long id){
        studentService.deleteStudent(id);
    }
//
////    @GetMapping(path = "/students/top3")
////    public List<Student> getTop3Student(){
////        return ss.getTop3Student();
////    }

    @GetMapping(path = "/student/{studentName}")
    public ResponseEntity<Student> getStudentByName(@PathVariable String studentName){
        Student student = studentService.getStudentByname(studentName);
        return ResponseEntity.ok().body(student);

    }
////
////    @GetMapping("/students/firstRanked")
////    public List<HighestScoreStudentDTO> getStudentsWithFirstRank() {
////        return ss.getStudentsWithFirstRank();
////    }

//
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public Map<String ,String> handleValidationException(MethodArgumentNotValidException ex){
//        Map<String,String> errors = new HashMap<>();
//
//        ex.getBindingResult().getAllErrors().forEach((error) ->{
//            String fieldName = ((FieldError) error).getField();
//            String errorMessage = error.getDefaultMessage();
//            errors.put(fieldName, errorMessage);
//
//        });
//        return errors;
//    }





}
