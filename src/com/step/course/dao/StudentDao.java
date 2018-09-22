package com.step.course.dao;

import com.step.course.model.Student;

import java.util.List;

public interface StudentDao {
    List<Student> getAllStudent();
    boolean deleteStudent(int idStudent);
}
