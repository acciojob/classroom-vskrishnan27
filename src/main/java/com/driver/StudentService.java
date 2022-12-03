package com.driver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class StudentService {

    @Autowired
    StudentRepository studentRepo;

    public void addStudentService(Student st) {
        studentRepo.addStudent(st);
    }

    public void addTeacherService(Teacher st) {
        studentRepo.addTeacher(st);
    }

    public void makePairService(String teacher, String student) {
        studentRepo.pair(teacher, student);
    }

    public Student fiStudent(String st) {
        return studentRepo.findStudentByName(st);
    }

    public Teacher fiTeacher(String st) {
        return studentRepo.findTeacherByName(st);
    }

    public List<String> getAllStudentsService() {
        return studentRepo.getAllStudents();
    }

    public List<String> getStudentByTeacher(String trName) {
        return studentRepo.getListOfStudentUnderATeacher(trName);
    }

    public void delTeacherAndStudentPairs(String trName) {
        studentRepo.delTeacherAndStudents(trName);
    }

    public void delAllRecordsService() {
        studentRepo.deleteAllRecords();
    }

}
