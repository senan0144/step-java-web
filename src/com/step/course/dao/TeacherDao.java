package com.step.course.dao;

import com.step.course.model.Teacher;

import java.util.List;

public interface TeacherDao {

    List<Teacher> getAllTeacher();
    boolean deleteTeacher(int idTeacher);

}
