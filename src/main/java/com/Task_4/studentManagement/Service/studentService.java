package com.Task_4.studentManagement.Service;

import com.Task_4.studentManagement.Model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class studentService {

    private List<Student> students = new ArrayList<>();

    public List <Student> getAllStudent(){
        return students;
    }
    public void addStudent(Student student){
        students.add(student);

    }

    public void updateStudent(Student student,int roll_no) {
        for(int i =0 ; i<students.size() ; i++){
            Student s = students.get(i);
            if (s.getRoll_no()==roll_no){
                students.set(i, student);
                return;
            }
        }
    }

    public void deleteStudent(int roll_no) {
        students.removeIf(t -> t.getRoll_no()==roll_no);
    }

    public List<Student> top3Student() {
        return students.stream()
                .sorted(Comparator.comparing(Student::getRank))
                .limit(3)
                .collect(Collectors.toList());

    }


}
