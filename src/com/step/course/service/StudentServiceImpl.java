package com.step.course.service;

import com.step.course.dao.StudentDao;
import com.step.course.model.Student;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao;

    public StudentServiceImpl(StudentDao studentDao){
        this.studentDao = studentDao;
    }


    @Override
    public List<Student> getAllStudent() {
        return studentDao.getAllStudent();
    }

    @Override
    public boolean deleteStudent(int idStudent) {
        return studentDao.deleteStudent(idStudent);
    }
}
