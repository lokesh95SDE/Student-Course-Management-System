package com.airtribe.learntrack.entity;
import java.time.LocalDate;

public class Enrollment {

    private int id ;
    private int studentId;
    private int courseId;
    private LocalDate enrollmentDate;
    private status status;

    public enum status{
        ACTIVE,
        COMPLETED,
        CANCELLD
    }

    public Enrollment(int id, int studentId, int courseId, LocalDate enrollmentDate, Enrollment.status status) {
        this.id = id;
        this.studentId = studentId;
        this.courseId = courseId;
        this.enrollmentDate = enrollmentDate;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public status getStatus() {
        return status;
    }

    public void setStatus(status status) {
        this.status = status;
    }
}
