package com.step.course.dao;

import com.step.course.model.Course;

import java.util.List;

public interface CourseDao {

    List<Course> getAllCourse();
    boolean deleteCourse(int idCourse);

}
