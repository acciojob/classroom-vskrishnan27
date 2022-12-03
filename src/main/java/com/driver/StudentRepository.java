package com.driver;

import java.util.*;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public class StudentRepository {

    Map<String, List<String>> TeacherStudent = new HashMap<>();
    List<Teacher> teachers = new ArrayList<>();
    List<Student> students = new ArrayList<>();

    public void addStudent(Student st) {
        students.add(st);

    }

    public void addTeacher(Teacher tr) {
        teachers.add(tr);
        TeacherStudent.put(tr.getName(), new ArrayList<>());
    }

    public void pair(String tr, String st) {
        TeacherStudent.get(tr).add(st);
    }

    public Student findStudentByName(String name) {
        for (Student st : students) {
            if (st.getName().equals(name))
                return st;
        }
        return null;
    }

    public Teacher findTeacherByName(String name) {
        for (Teacher st : teachers) {
            if (st.getName().equals(name))
                return st;
        }
        return null;
    }

    public List<String> getListOfStudentUnderATeacher(String tr) {
        return TeacherStudent.get(tr);
    }

    public List<String> getAllStudents() {
        List<String> studentsList = new ArrayList<>();
        for (Student st : students) {
            studentsList.add(st.getName());
        }
        return studentsList;
    }

    public void delTeacherAndStudents(String tr) {

        Set<String> set = new HashSet<>(TeacherStudent.get(tr));

        for (Student st : new ArrayList<>(students)) {
            if (set.contains(st.getName())) {
                TeacherStudent.get(tr).remove(st);
            }
        }

        for (Teacher tc : new ArrayList<>(teachers)) {
            if (tc.getName().equals(tr)) {
                teachers.remove(tc);
            }
        }

        TeacherStudent.remove(tr);
        return;

    }

    public void deleteAllRecords() {
        TeacherStudent.clear();
        students.clear();
        teachers.clear();
        return;
    }

}
