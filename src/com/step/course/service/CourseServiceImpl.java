package com.step.course.service;

import com.step.course.dao.CourseDao;
import com.step.course.model.Course;

import java.util.List;

public class CourseServiceImpl implements CourseService {
    private CourseDao courseDao;

    public CourseServiceImpl(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    @Override
    public List<Course> getAllCourse() {
        return courseDao.getAllCourse();
    }

}
