package com.step.course.dao;

import com.step.course.model.Student;

import java.util.List;

public interface StudentDao {

    List<Student> getAllStudent();

    boolean deleteStudent(int idStudent);

    boolean addStudent(Student student);

    Student getStudentById(int id);

    boolean updateStudent(Student student);
}
