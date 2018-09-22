package com.step.course.dao;

import com.step.course.model.Course;
import com.step.course.model.Student;
import com.step.course.model.Teacher;
import com.step.course.util.DbUtil;

import javax.servlet.ServletException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    private final String GET_ALL_STUDENT_SQL = "select s.id_student, s.first_name as s_first_name, s.last_name as s_last_name, s.date_of_birth, c.id_course, c.name as course_name, c.desc, c.duration, t.id_teacher, t.first_name as t_first_name, t.last_name as t_last_name from student s inner join teacher t on s.id_teacher=t.id_teacher inner join course c on t.id_course=c.id_course";
    private final String DELETE_STUDENT = "delete from student where id_student=?";


    @Override
    public List<Student> getAllStudent() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Student> list = new ArrayList<>();
        try{
            con = DbUtil.getConnection();
            ps = con.prepareStatement(GET_ALL_STUDENT_SQL);
            rs = ps.executeQuery();

            while (rs.next()){
                Student student = new Student();
                student.setId(rs.getInt("id_student"));
                student.setFirstName(rs.getString("s_first_name"));
                student.setLastName(rs.getString("s_last_name"));
                student.setDateOfBirth(rs.getDate("date_of_birth").toLocalDate());

                Course course = new Course();
                course.setId(rs.getInt("id_course"));
                course.setName(rs.getString("course_name"));
                course.setDesc(rs.getString("desc"));
                course.setDuration(rs.getInt("duration"));

                Teacher teacher = new Teacher();
                teacher.setId(rs.getInt("id_teacher"));
                teacher.setFirstName(rs.getString("t_first_name"));
                teacher.setLastName(rs.getString("t_last_name"));

                teacher.setCourse(course);
                student.setTeacher(teacher);

                list.add(student);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DbUtil.closeAll(con,rs,ps);
        }

        return list;
    }

    @Override
    public boolean deleteStudent(int idStudent) {
        Connection con = null;
        PreparedStatement ps = null;
        boolean result = false;

        try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(DELETE_STUDENT);
            ps.setInt(1, idStudent);
            ps.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbUtil.closeAll(con,ps);
        }

        return result;
    }
}
