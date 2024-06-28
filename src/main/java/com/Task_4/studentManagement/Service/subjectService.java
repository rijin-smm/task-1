//package com.Task_4.studentManagement.Service;
//
//import com.Task_4.studentManagement.Model.Subject;
//import com.Task_4.studentManagement.Repository.subjectRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class subjectService {
//
//    @Autowired
//    private subjectRepo subj_rep;
//
//    List<Subject> subjects = new ArrayList<>();
//
//    public List<Subject> getAllSubject() {
//        return subj_rep.findAll();
//    }
//
//    public void createNewSubject(Subject newSubject) {
//        subj_rep.save(newSubject);
//    }
//
//    public void deleteSubject(String subjectId) {
//        subj_rep.deleteById(subjectId);
//    }
//
////    public void updateSubject(Subject updatedSubject, String subject_id) {
////        subj_rep.findById(subject_id).map(subject -> {
////                    subject.setSubject_id(updatedSubject.getSubject_id());
////                    subject.setSubject_name(updatedSubject.getSubject_name());
////                    return subj_rep.save(subject);
////            }).orElseThrow(() -> new RuntimeException("Subject not found with id " +subject_id ));
////
////        }
//
//    public Subject updateSubject(Subject subjectDetails, String id ) {
//        Subject subject = subj_rep.findById(id).orElseThrow();
//        subject.setId(subjectDetails.getId());
//        subject.setSubjectName(subjectDetails.getSubjectName());
//        return subj_rep.save(subject);
//    }
//    }
//
