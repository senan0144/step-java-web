package com.step.course.dao;

import com.step.course.model.Course;
import com.step.course.model.Teacher;
import com.step.course.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TeacherDaoImpl implements TeacherDao {

    private final String GET_ALL_TEACHER_SQL = "select t.id_teacher, t.first_name, t.last_name, c.id_course, c.name, c.desc, c.duration from teacher t inner join course c on t.id_course=c.id_course";
    private final String DELETE_TEACHER = "delete from teacher where id_teacher=?";
    private final String GET_ALL_TEACHERS_BY_COURSE_ID_SQL = "select * from teacher where id_course = ?";

    @Override
    public List<Teacher> getAllTeacher() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Teacher> list = new ArrayList<>();
        try{
            con = DbUtil.getConnection();
            ps = con.prepareStatement(GET_ALL_TEACHER_SQL);
            rs = ps.executeQuery();

            while (rs.next()){
                Course course = new Course();
                course.setId(rs.getInt("id_course"));
                course.setName(rs.getString("name"));
                course.setDesc(rs.getString("desc"));
                course.setDuration(rs.getInt("duration"));

                Teacher teacher = new Teacher();
                teacher.setId(rs.getInt("id_teacher"));
                teacher.setFirstName(rs.getString("first_name"));
                teacher.setLastName(rs.getString("last_name"));
                teacher.setCourse(course);

                list.add(teacher);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DbUtil.closeAll(con,rs,ps);
        }

        return list;
    }

    @Override
    public boolean deleteTeacher(int idTeacher) {
        Connection con = null;
        PreparedStatement ps = null;
        boolean result = false;

        try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(DELETE_TEACHER);
            ps.setInt(1, idTeacher);
            ps.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbUtil.closeAll(con,ps);
        }

        return result;
    }

    @Override
    public List<Teacher> getTeachersByCourseId(int courseId) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Teacher> list = new ArrayList<>();
        try{
            con = DbUtil.getConnection();
            ps = con.prepareStatement(GET_ALL_TEACHERS_BY_COURSE_ID_SQL);
            ps.setInt(1, courseId);
            rs = ps.executeQuery();

            while (rs.next()){
                Teacher teacher = new Teacher();
                teacher.setId(rs.getInt("id_teacher"));
                teacher.setFirstName(rs.getString("first_name"));
                teacher.setLastName(rs.getString("last_name"));

                list.add(teacher);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DbUtil.closeAll(con,rs,ps);
        }

        return list;
    }

}
