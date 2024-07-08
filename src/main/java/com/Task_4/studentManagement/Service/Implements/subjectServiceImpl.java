package com.Task_4.studentManagement.Service.Implements;

import com.Task_4.studentManagement.Model.Subject;
import com.Task_4.studentManagement.Repository.subjectRepo;
import com.Task_4.studentManagement.Service.Interface.subjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class subjectServiceImpl implements subjectService {

    @Autowired
    private subjectRepo subj_rep;

    @Autowired
    private com.Task_4.studentManagement.Service.Interface.sequenceGeneratorService sequenceGeneratorService;

    List<Subject> subjects = new ArrayList<>();

    @Override
    public List<Subject> getAllSubject() {
        return subj_rep.findAll();
    }

    @Override
    public void createNewSubject(Subject newSubject) {
        newSubject.setId(sequenceGeneratorService.generateSequence(newSubject.SEQUENCE_NAME));
        subj_rep.save(newSubject);
    }

    @Override
    public void deleteSubject(long subjectId) {
        subj_rep.deleteById(subjectId);
    }

    @Override
    public Subject updateSubject(Subject subjectDetails, long subjectId ) {
        Subject subject = subj_rep.findById(subjectId).orElseThrow();
        subject.setSubjectName(subjectDetails.getSubjectName());
        return subj_rep.save(subject);
    }
}
