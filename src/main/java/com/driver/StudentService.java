package com.driver;

import java.util.List;

public class StudentService {

    StudentRepository studentRepository=new StudentRepository();
    public void addStudent(Student student) {
        studentRepository.addstudent(student);
    }
    

    public void addTeacher(Teacher teacher) {
        studentRepository.addteacher(teacher);
    }

    public void addStudentTeacher(String student, String teacher) {
        studentRepository.addstudentTeacher(student,teacher);
    }

    public Student studentByName(String name) {
        Student student=studentRepository.studentByName(name);
        return student;
    }

    public Teacher teacherByName(String name) {
        Teacher teacher=studentRepository.teacherByName(name);
        return teacher;
    }

    public List<String> getStudentByTeacherName(String teacher) {
        return studentRepository.getStudentByTeacherName(teacher);

    }

    public List<String> getAllStudent() {
        return studentRepository.getAllStudent();
    }

    public void deleteTeacherByName(String teacher) {
        studentRepository.deleteTeacherByName(teacher);
    }

    public void deleteAllTeacher() {
     studentRepository.deleteAllTeacher();
    }
}
