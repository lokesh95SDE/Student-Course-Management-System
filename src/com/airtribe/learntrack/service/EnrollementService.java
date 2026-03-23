package com.airtribe.learntrack.service;


import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.enums.EnrollmentStatus;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.util.IdGenerator;

import java.util.ArrayList;

public class EnrollementService {

    private ArrayList<Enrollment> enrollmentDetails = new  ArrayList<>();
    private StudentService  studentService;
    private CourseService   courseService;

    public EnrollementService(StudentService studentService, CourseService courseService) {
        this.studentService = studentService;
        this.courseService = courseService;
    }


    public void enrollStudent(int studentId, int courseId) throws EntityNotFoundException {
        int id = IdGenerator.getNextEnrollmentId();
        Student student =studentService.findStudentById(studentId);
        Course course = courseService.findCourseById(courseId);
        Enrollment enrollDetails = new Enrollment(id, studentId,courseId,null,EnrollmentStatus.COMPLETED);
        enrollmentDetails.add(enrollDetails);
        System.out.println("Enrollment added successfully with ID: "+id);
    }
public void viewEnrollment(){
        for(Enrollment enrollDetail : enrollmentDetails){
            System.out.println(
                    enrollDetail.getId() + " | " +
                            enrollDetail.getStudentId() + " | " +
                            enrollDetail.getCourseId() + " | " +
                            enrollDetail.getEnrollmentDate() + " | " +
                            enrollDetail.getStatus()
            );
        }
}

    public void viewEnrollmentByStudent(int id) throws EntityNotFoundException {
        Enrollment enrollDetail = findEnrollmentById(id);
        System.out.println(
                enrollDetail.getId() + " | " +
                        enrollDetail.getStudentId() + " | " +
                        enrollDetail.getCourseId() + " | " +
                        enrollDetail.getEnrollmentDate() + " | " +
                        enrollDetail.getStatus()
        );
    }

public Enrollment findEnrollmentById(int id) throws EntityNotFoundException {
        for(Enrollment enrollDetail : enrollmentDetails){
            if(enrollDetail.getId() == id){
                return enrollDetail;
            }
        }
    throw new EntityNotFoundException("Enrollment not found with ID: "+id);    }


public void updateEnrollment(int id, EnrollmentStatus status) throws EntityNotFoundException {
    Enrollment enrollment = findEnrollmentById(id);
    enrollment.setStatus(status);
    System.out.println("Enrollment updated successfully!");
    }

}
