package com.airtribe.learntrack;

import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.service.CourseService;
import com.airtribe.learntrack.service.StudentService;
import com.airtribe.learntrack.util.IdGenerator;

public class Main {

    public static void main(String[]  agr) throws EntityNotFoundException {
        StudentService first = new StudentService();
        CourseService second = new CourseService();
//        first.addStudent("Lokesh", "J", "lokesh@gmail.com", "Batch-A");
//        first.addStudent("Lokesh", "J", "lokesh@gmail.com", "Batch-A");
//        first.addStudent("Lokesh", "J", "Batch-A");
//        first.listStudents();
//        first.deactivateStudent(2);
//        first.updateStudent(2,"Akchaya","Lokesh","loki@gamil.com","Batch-B");
//        first.removeStudent(2);
//        first.listStudents();
//        second.addCourse("Java", "Core Java Basics", 8, true);
//        second.addCourse("Python", "Beginner to Advanced", 10, true);
//        second.deactivateCourse(2);
//        second.listCourses();
//        second.removeCourse(2);
//        second.listCourses();


    }
}
