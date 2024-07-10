package com.example.demo.Service.Implements;

import com.example.demo.Model.Subject;
import com.example.demo.Repository.SubjectRepo;
import com.example.demo.Service.Interface.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepo subjectRepo;

    @Override
    public List<Subject> getAllSubject() {
        return subjectRepo.findAll();
    }

    @Override
    public void createNewSubject(Subject newSubject) {
        subjectRepo.save(newSubject);
    }

    @Override
    public void deleteSubject(long subjectId) {
        subjectRepo.deleteById(subjectId);
    }

    @Override
    public Subject updateSubject(Subject subjectDetails, long subjectId ) {
        Subject subject = subjectRepo.findById(subjectId).orElseThrow();
        subject.setSubjectName(subjectDetails.getSubjectName());
        return subjectRepo.save(subject);
    }
}
