package com.airtribe.learntrack;

import com.airtribe.learntrack.enums.EnrollmentStatus;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.service.CourseService;
import com.airtribe.learntrack.service.EnrollementService;
import com.airtribe.learntrack.service.StudentService;

import java.util.Scanner;

public class Main {

    public static void main(String[] agr) throws EntityNotFoundException {

        Scanner scanner = new Scanner(System.in);
        StudentService studentService = new StudentService();
        CourseService courseService = new CourseService();
        EnrollementService enrollmentService = new EnrollementService(studentService, courseService);

        while (true) {
            System.out.println("\n==== MAIN MENU ====");
            System.out.println("1. Student");
            System.out.println("2. Course");
            System.out.println("3. Enrollments");
            System.out.println("0. Exit");
            try {
                int mainChoice = Integer.parseInt(scanner.nextLine());
                switch (mainChoice) {
                    case 1:
                        System.out.println("\n==== STUDENT MENU ====");
                        studentMenu(scanner,studentService);
                        break;
                    case 2:
                        System.out.println("\n==== COURSE MENU ====");
                        courseMenu(scanner,courseService);
                        break;
                    case 3:
                        System.out.println("\n==== ENROLLEMENT MENU ====");
                        enrollmentMenu(scanner,enrollmentService);
                        break;
                    case 0:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid option! Try again");
                }
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter number");
            }

        }
    }

    private static void enrollmentMenu(Scanner scanner, EnrollementService enrollmentService) {
        while (true) {
            System.out.println("1. Enroll Student");
            System.out.println("2. View Enrollments");
            System.out.println("3. Update Enrollment Status");
            System.out.println("0. Back to Main Menu");
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        System.out.print("Student ID: ");
                        int sid = Integer.parseInt(scanner.nextLine());

                        System.out.print("Course ID: ");
                        int cid = Integer.parseInt(scanner.nextLine());

                        enrollmentService.enrollStudent(sid, cid);
                        break;

                    case 2:
                        System.out.print("Student ID: ");
                        int sId = Integer.parseInt(scanner.nextLine());
                        enrollmentService.viewEnrollmentByStudent(sId);
                        break;

                    case 3:
                        System.out.print("Enrollment ID: ");
                        int eid = Integer.parseInt(scanner.nextLine());
                        System.out.print("Status: ");
                        String status1 = scanner.nextLine();
                        enrollmentService.updateEnrollment(eid, EnrollmentStatus.valueOf(status1));
                        break;
                    case 0:
                        System.out.println("Back to Main Menu...");
                        return;
                    default:
                        System.out.println("Invalid option! Try again.");
                }
            } catch (Exception s) {
                System.out.println("Error: " + s.getMessage());
            }
        }
    }

    private static void courseMenu(Scanner scanner, CourseService courseService) {
       while (true) {
           System.out.println("1. Add Course");
           System.out.println("2. View Courses");
           System.out.println("0. Back to Main Menu");

           try {
               int choice = Integer.parseInt(scanner.nextLine());
               switch (choice) {
                   case 1:
                       System.out.print("Course Name: ");
                       String name = scanner.nextLine();
                       System.out.print("Description: ");
                       String desc = scanner.nextLine();
                       System.out.print("Duration: ");
                       int dur = Integer.parseInt(scanner.nextLine());
                       System.out.print("Status: ");
                       boolean status = scanner.nextBoolean();
                       courseService.addCourse(name, desc, dur, status);
                       break;
                   case 2:
                       courseService.listCourses();
                       break;
                   case 0:
                       System.out.println("Back to Main Menu...");
                       return;
                   default:
                       System.out.println("Invalid option! Try again.");
               }
           } catch (Exception s) {
               System.out.println("Error: " + s.getMessage());
           }
       }
    }


    public static void studentMenu(Scanner scanner, StudentService studentService) {
        while(true) {
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("0. Back to Main Menu");
            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        System.out.print("First Name: ");
                        String fn = scanner.nextLine();
                        System.out.print("Last Name: ");
                        String ln = scanner.nextLine();
                        System.out.print("Email: ");
                        String email = scanner.nextLine();
                        System.out.print("Batch: ");
                        String batch = scanner.nextLine();
                        if (email.isEmpty()) {
                            studentService.addStudent(fn, ln, batch);
                        } else {
                            studentService.addStudent(fn, ln, email, batch);
                        }
                        break;
                    case 2:
                        studentService.listStudents();
                        break;
                    case 0:
                        System.out.println("Back to Main Menu...");
                        return;
                    default:
                        System.out.println("Invalid option! Try again.");
                }
            } catch (Exception s) {
                System.out.println("Error: " + s.getMessage());
            }
        }









    }
}
