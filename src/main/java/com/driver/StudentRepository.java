package com.driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StudentRepository {

    private List<Student> list1=new ArrayList<>();
    
    private List<Teacher> list2=new ArrayList<>();

    private HashMap<Teacher,List<Student>> teacherWithStudentMap=new HashMap<>();
    public void addstudent(Student student) {
        list1.add(student);
    }

    public void addteacher(Teacher teacher) {
        list2.add(teacher);
    }

    public void addstudentTeacher(String student, String teacher) {
        
    }

    public Student studentByName(String name) {
        for(Student student:list1){
            if(student.getName().equals(name)){
                return student;
            }
        }
        return new Student();
    }

    public Teacher teacherByName(String name) {
        for(Teacher teacher:list2){
            if(teacher.getName().equals(name)){
                return teacher;
            }
        }
        return new Teacher();
    }

    public List<String> getStudentByTeacherName(String teacher) {
        List<String> allstudentByTeacher=new ArrayList<>();
        Teacher teacher1=teacherByName(teacher);
        List<Student> studentList=teacherWithStudentMap.getOrDefault(teacher1,new ArrayList<>());
        for(Student student:studentList){
            allstudentByTeacher.add(student.getName());
        }
        return allstudentByTeacher;
    }

    public List<String> getAllStudent() {
        List<String> allStudent=new ArrayList<>();
        for(Student student:list1){
            allStudent.add(student.getName());
        }
        return allStudent;
    }

    public void deleteTeacherByName(String teacher) {
        Teacher teacher1=teacherByName(teacher);
        List<Student> listOfRemoveStudent=teacherWithStudentMap.getOrDefault(teacher1,new ArrayList<>());
        for(Student student:listOfRemoveStudent){
            list1.remove(student);
        }
        teacherWithStudentMap.remove(teacher1);
        list2.remove(teacher1);

    }

    public void deleteAllTeacher() {
        for(Teacher teacher: new ArrayList<>(list2)) deleteTeacherByName(teacher.getName());
        list2.clear();
        teacherWithStudentMap.clear();
    }
}
