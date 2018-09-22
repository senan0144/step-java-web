package com.step.course.service;

import com.step.course.dao.TeacherDao;
import com.step.course.model.Teacher;

import java.util.List;

public class TeacherServiceImpl implements TeacherService{
    private TeacherDao teacherDao;

    public TeacherServiceImpl(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    @Override
    public List<Teacher> getAllTeacher() {
        return teacherDao.getAllTeacher();
    }

    @Override
    public boolean deleteTeacher(int idTeacher) {
        return teacherDao.deleteTeacher(idTeacher);
    }

}
