package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.util.IdGenerator;

import java.util.ArrayList;

public class StudentService {
    public static ArrayList<Student> studentList = new ArrayList<>();

    public void addStudent(String firstName, String lastName, String email, String batch){
        int id = IdGenerator.getNextStudentId();
        Student studentDetails = new Student(id,firstName,lastName,email,batch);
        studentList.add(studentDetails);
        System.out.println("Student added successfully with ID: "+id);
    }
    public void addStudent(String firstName, String lastName, String batch){
        int id = IdGenerator.getNextStudentId();
        Student studentDetails = new Student(id,firstName,lastName);
        studentDetails.setBatch(batch);
        studentList.add(studentDetails);
        System.out.println("Student added successfully with ID: "+id);
    }

    public void listStudents() throws EntityNotFoundException {
        if(studentList.isEmpty()){
            throw new EntityNotFoundException("Student not found");
        }
        for(Student studentDetail : studentList){
            String email = (studentDetail.getEmail() == null) ? "N/A" : studentDetail.getEmail();
            System.out.println(
                    studentDetail.getId() + " | " +
                            studentDetail.getDisplayName() + " | " +
                            email + " | " +
                            studentDetail.getBatch() + " | Active: " + studentDetail.isActive()
            );
        }
    }
    public Student findStudentById(int id) throws EntityNotFoundException {
        for (Student studentDetail : studentList) {
            if (studentDetail.getId() == id) {
                return studentDetail;
            }
        }
        throw new EntityNotFoundException("Student not found with ID: " + id);
    }

    public void removeStudent(int id) throws EntityNotFoundException {
        Student studentDetail = findStudentById(id);
        studentList.remove(studentDetail);
        System.out.println("Student is removed!");
    }

    public void deactivateStudent(int id) throws EntityNotFoundException {
        Student studentDetail = findStudentById(id);
        studentDetail.setActive(false);
        System.out.println("Student is deactivated!");
    }

    public void updateStudent(int id, String firstName, String lastName, String email, String batch) throws EntityNotFoundException {
        Student studentDetail = findStudentById(id);
        studentDetail.setFirstName(firstName);
        studentDetail.setLastName(lastName);
        studentDetail.setEmail(email);
        studentDetail.setBatch(batch);
        System.out.println("Student details updated successfully!");
    }

}
