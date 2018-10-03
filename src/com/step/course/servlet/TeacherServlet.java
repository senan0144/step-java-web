package com.step.course.servlet;

import com.step.course.dao.TeacherDaoImpl;
import com.step.course.model.Teacher;
import com.step.course.service.TeacherService;
import com.step.course.service.TeacherServiceImpl;
import org.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "TeacherServlet", urlPatterns = "/ts")
public class TeacherServlet extends HttpServlet {
    private TeacherService teacherService = new TeacherServiceImpl(new TeacherDaoImpl());

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequsest(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequsest(request,response);
    }

    protected void processRequsest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = null;

        if (request.getParameter("action") != null) {
            action = request.getParameter("action");
        }

        if (action.equals("getAllTeacher")) {
            List<Teacher> list = teacherService.getAllTeacher();
            request.setAttribute("teacherList", list);

            request.getRequestDispatcher("/WEB-INF/fragments/teacher-table.jsp").forward(request, response);

        }else if (action.equals("deleteTeacher")){
            int id = Integer.parseInt(request.getParameter("id"));

            boolean result = teacherService.deleteTeacher(id);

            if (!result){
                throw new ServletException();
            }

        }else if (action.equals("getTeachersByCourseId")){
            int id = Integer.parseInt(request.getParameter("id"));

            List<Teacher> list = teacherService.getTeachersByCourseId(id);

            JSONArray jsonArray = new JSONArray(list);
            response.setContentType("application/json");
            response.getWriter().write(jsonArray.toString());

        }

    }


}
