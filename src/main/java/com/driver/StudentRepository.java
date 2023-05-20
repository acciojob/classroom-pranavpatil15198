package com.driver;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentRepository {
    private final Map<String, Student> students = new HashMap<>();

    public void addStudent(Student student) {
        students.put(student.getName(), student);
    }

    public Student getStudentByName(String name) {
        return students.get(name);
    }

    public void deleteStudentByName(String name) {
        students.remove(name);
    }
}
