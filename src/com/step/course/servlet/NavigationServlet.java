package com.step.course.servlet;

import com.step.course.dao.*;
import com.step.course.model.Course;
import com.step.course.model.Student;
import com.step.course.model.Teacher;
import com.step.course.service.*;
import com.step.course.util.ValidationUtil;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "NavigationServlet", urlPatterns = "/ns")
public class NavigationServlet extends HttpServlet {

    private StudentService studentService = new StudentServiceImpl(new StudentDaoImpl());
    private TeacherService teacherService = new TeacherServiceImpl(new TeacherDaoImpl());
    private CourseService courseService = new CourseServiceImpl(new CourseDaoImpl());

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }


    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = null;

        if (request.getParameter("action") != null) {
            action = request.getParameter("action");
        }

        if (action.equals("getNewStudentJsp")) {
            List<Course> list = courseService.getAllCourse();
            request.setAttribute("courseList", list);

            request.getRequestDispatcher("/WEB-INF/fragments/new-student-dialog.jsp").forward(request, response);

        } else if (action.equals("getStudentById")) {
            int idStudent = Integer.parseInt(request.getParameter("id"));
            Student student = studentService.getStudentById(idStudent);
            List<Course> courseList = courseService.getAllCourse();
            List<Teacher> teacherList = teacherService.getTeachersByCourseId(student.getTeacher().getCourse().getId());

            request.setAttribute("student", student);
            request.setAttribute("courseList", courseList);
            request.setAttribute("teacherList" ,teacherList);

            request.getRequestDispatcher("/WEB-INF/fragments/update-student-dialog.jsp").forward(request, response);

        }




    }
}
