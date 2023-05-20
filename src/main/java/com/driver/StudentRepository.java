package com.driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentRepository {

    private List<Student> students=new ArrayList<>();
    private List<Teacher> teachers=new ArrayList<>();
    private Map<Teacher,List<Student>> studentTeacherMap=new HashMap<>();
    public void addStudent(Student student) {
        students.add(student);
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public void addStudentTeacherPair(String student, String teacher) {
        Teacher teacherName=getTeacherByName(teacher);
        Student studentName=getStudentByName(student);
        List<Student> studentsList=studentTeacherMap.getOrDefault(teacherName,new ArrayList<>());
        studentsList.add(studentName);
        studentTeacherMap.put(teacherName,studentsList);
    }

    public Student getStudentByName(String name) {
        for(Student s:students){
            if(s.getName().equals(name)){
                return s;
            }
        }
        return new Student();
    }

    public Teacher getTeacherByName(String name) {
        for(Teacher t:teachers){
            if(t.getName().equals(name)){
                return t;
            }
        }
        return new Teacher();
    }

    public List<String> getStudentsByTeacherName(String teacher) {
        Teacher teacherName=getTeacherByName(teacher);
        List<String> studentNames=new ArrayList<>();
        List<Student> list=studentTeacherMap.getOrDefault(teacherName,new ArrayList<>());
        for(Student s:list){
            studentNames.add(s.getName());
        }
        return studentNames;
    }

    public List<String> getAllStudents() {
        List<String> list=new ArrayList<>();
        for(Student s:students){
            list.add(s.getName());
        }
        return list;
    }

    public void deleteTeacherByName(String teacher) {
        Teacher teacherName=getTeacherByName(teacher);
        List<Student> list=studentTeacherMap.getOrDefault(teacherName,new ArrayList<>());
        for(Student s:list){
            students.remove(s);
        }
        studentTeacherMap.remove(teacherName);
        teachers.remove(teacherName);
    }

    public void deleteAllTeachers() {
        for(Teacher t:new ArrayList<>(teachers)){
            deleteTeacherByName(t.getName());
        }
        teachers.clear();;
        studentTeacherMap.clear();
    }
}
