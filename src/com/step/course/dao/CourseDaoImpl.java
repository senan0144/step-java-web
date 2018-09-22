package com.step.course.dao;

import com.step.course.model.Course;
import com.step.course.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CourseDaoImpl implements CourseDao {

    private final String GET_ALL_COURSE_SQL = "select * from course";


    @Override
    public List<Course> getAllCourse() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Course> list = new ArrayList<>();
        try{
            con = DbUtil.getConnection();
            ps = con.prepareStatement(GET_ALL_COURSE_SQL);
            rs = ps.executeQuery();

            while (rs.next()){
                Course course = new Course();
                course.setId(rs.getInt("id_course"));
                course.setName(rs.getString("name"));
                course.setDesc(rs.getString("desc"));
                course.setDuration(rs.getInt("duration"));

                list.add(course);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DbUtil.closeAll(con,rs,ps);
        }

        return list;
    }

}
