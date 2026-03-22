package com.airtribe.learntrack;

import com.airtribe.learntrack.service.StudentService;
import com.airtribe.learntrack.util.IdGenerator;

public class Main {

    public static void main(String[]  agr){
        StudentService first = new StudentService();
        first.addStudent("Lokesh", "J", "lokesh@gmail.com", "Batch-A");
        first.addStudent("Lokesh", "J", "lokesh@gmail.com", "Batch-A");
        first.addStudent("Lokesh", "J", "lokesh@gmail.com", "Batch-A");

        first.listStudents();
        first.deactivateStudent(2);
        first.listStudents();
        first.removeStudent(2);
        first.listStudents();

    }
}
