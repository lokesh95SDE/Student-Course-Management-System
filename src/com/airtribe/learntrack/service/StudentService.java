package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.util.IdGenerator;

import java.util.ArrayList;

public class StudentService {
    public static ArrayList<Student> studentList = new ArrayList();

    public void addStudent(String firstName, String lastName, String email, String batch){
        int id = IdGenerator.getNextStudentId();
        Student studentDetails = new Student(id,firstName,lastName,email,batch);
        studentList.add(studentDetails);
        System.out.println("Student added successfully with ID: "+id);
    }

    public void listStudents(){
        if(studentList.isEmpty()){
            System.out.println("No students found.");
            return;
        }
        for(Student studentDetail : studentList){
            System.out.println(
                    studentDetail.getId() + " | " +
                            studentDetail.getDisplayName() + " | " +
                            studentDetail.getEmail() + " | " +
                            studentDetail.getBatch() + " | Active: " + studentDetail.isActive()
            );

        }
    }

    public Student findStudentById(int id) {

        for (Student studentDetail : studentList) {
            if (studentDetail.getId() == id) {
                return studentDetail;
            }
        }
        return null;
    }

    public void removeStudent(int id){
        Student studentDetail = findStudentById(id);
        if(studentDetail==null){
            System.out.println("Student not found!");
            return;
        }
        studentList.remove(studentDetail);
        System.out.println("Student is removed!");
    }



    public void updateStudent(int id){

    }

    public void deactivateStudent(int id){
    Student studentDetail = findStudentById(id);
    if(studentDetail==null){
        System.out.println("Student not found!");
        return;
    }
    studentDetail.setActive(false);
    System.out.println("Student is deactivated!");
    }
}
