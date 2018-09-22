package com.step.course.servlet;

import com.step.course.dao.CourseDaoImpl;
import com.step.course.model.Course;
import com.step.course.service.CourseService;
import com.step.course.service.CourseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CourseServlet", urlPatterns = "/cs")
public class CourseServlet extends HttpServlet {
    private CourseService courseService = new CourseServiceImpl(new CourseDaoImpl());

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequsest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequsest(request, response);
    }

    protected void processRequsest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = null;

        if (request.getParameter("action") != null) {
            action = request.getParameter("action");
        }

        if (action.equals("getAllCourse")) {
            List<Course> list = courseService.getAllCourse();
            request.setAttribute("courseList", list);
            request.getRequestDispatcher("/WEB-INF/fragments/course-table.jsp").forward(request, response);

        }else if (action.equals("deleteCourse")){
            int id = Integer.parseInt(request.getParameter("id"));

            boolean result = courseService.deleteCourse(id);

            if (!result){
                throw new ServletException();
            }
        }

    }
}
