package com.step.course.dao;

import com.step.course.model.Course;
import com.step.course.model.Student;
import com.step.course.model.Teacher;
import com.step.course.util.DbUtil;
import com.sun.xml.internal.ws.api.ha.StickyFeature;

import javax.servlet.ServletException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {

    private final String GET_ALL_STUDENT_SQL = "select s.id_student, s.first_name as s_first_name, s.last_name as s_last_name, s.date_of_birth, c.id_course, c.name as course_name, c.desc, c.duration, t.id_teacher, t.first_name as t_first_name, t.last_name as t_last_name from student s inner join teacher t on s.id_teacher=t.id_teacher inner join course c on t.id_course=c.id_course";
    private final String DELETE_STUDENT = "delete from student where id_student=?";
    private final String ADD_STUDENT_SQL = "insert into student(first_name, last_name, date_of_birth, id_teacher) values(?,?,?,?)";
    private final String GET_STUDENT_BY_ID_SQL = "select s.id_student, s.first_name as s_first_name, s.last_name as s_last_name, s.date_of_birth, c.id_course, c.name as course_name, c.desc, c.duration, t.id_teacher, t.first_name as t_first_name, t.last_name as t_last_name from student s inner join teacher t on s.id_teacher=t.id_teacher inner join course c on t.id_course=c.id_course where s.id_student = ?";
    private final String UPDATE_STUDENT_SQL = "update student set first_name = ?, last_name = ?, date_of_birth = ?, id_teacher = ? where id_student = ?";

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

    @Override
    public boolean addStudent(Student student) {
        Connection con = null;
        PreparedStatement ps = null;
        boolean result = false;

        try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(ADD_STUDENT_SQL);
            ps.setString(1, student.getFirstName());
            ps.setString(2, student.getLastName());
            ps.setString(3, student.getDateOfBirth().toString());
            ps.setInt(4, student.getTeacher().getId());
            ps.executeUpdate();

            result = true;

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            DbUtil.closeAll(con, ps);
        }

        return result;
    }

    @Override
    public Student getStudentById(int id) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Student student = null;

        try{
            con = DbUtil.getConnection();
            ps = con.prepareStatement(GET_STUDENT_BY_ID_SQL);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()){
                student = new Student();
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
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DbUtil.closeAll(con,rs,ps);
        }

        return student;
    }

    @Override
    public boolean updateStudent(Student student) {
        Connection con = null;
        PreparedStatement ps = null;
        boolean result = false;

        try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(UPDATE_STUDENT_SQL);
            ps.setString(1, student.getFirstName());
            ps.setString(2, student.getLastName());
            ps.setString(3, student.getDateOfBirth().toString());
            ps.setInt(4, student.getTeacher().getId());
            ps.setInt(5, student.getId());
            ps.executeUpdate();

            result = true;

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            DbUtil.closeAll(con, ps);
        }

        return result;
    }
}
