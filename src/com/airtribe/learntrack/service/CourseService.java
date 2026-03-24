package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.util.IdGenerator;

import java.util.ArrayList;

public class CourseService   {
    private ArrayList<Course> courseList = new ArrayList<>();

    public void addCourse(String courseName, String description, int durationInWeeks, boolean active){
        int id = IdGenerator.getNextCourseId();
        Course courseDetails =new Course(id, courseName, description, durationInWeeks,active);
        courseList.add(courseDetails);
        System.out.println("Course added successfully with ID: "+id);
    }

    public void listCourses() throws EntityNotFoundException {
        if(courseList.isEmpty()){
            throw new EntityNotFoundException("Course not found");
        }
        for(Course courseDetail : courseList){
            System.out.println(
                courseDetail.getId() + " | " +
                        courseDetail.getCourseName() + " | " +
                        courseDetail.getDescription() + " | " +
                        courseDetail.getDurationInWeeks() + " | Active: " + courseDetail.isActive()
            );
        }
    }

    public Course findCourseById(int id) throws EntityNotFoundException{
        for(Course courseDetail : courseList){
            if(courseDetail.getId() == id){
                return courseDetail;
            }
        }
        throw new EntityNotFoundException("Course not found with ID: "+id);    }

    public void deactivateCourse(int id) throws EntityNotFoundException {
        Course courseDetail = findCourseById(id);
        courseDetail.setActive(false);
    }

    public void removeCourse(int id) throws EntityNotFoundException {
        Course courseDetail = findCourseById(id);
        courseList.remove(courseDetail);
        System.out.println("Course is removed!");
    }

}
