package com.step.course.servlet;

import com.step.course.dao.StudentDaoImpl;
import com.step.course.model.Student;
import com.step.course.service.StudentService;
import com.step.course.service.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentServlet", urlPatterns = "/ss")
public class StudentServlet extends HttpServlet {

    private StudentService studentService = new StudentServiceImpl(new StudentDaoImpl());

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

        if (action.equals("getAllStudent")) {
            List<Student> list = studentService.getAllStudent();
            request.setAttribute("studentList", list);

            request.getRequestDispatcher("/WEB-INF/fragments/student-table.jsp").forward(request, response);

        }else if (action.equals("deleteStudent")){
            int id = Integer.parseInt(request.getParameter("id"));

            boolean result = studentService.deleteStudent(id);

            if (!result){
                throw new ServletException();
            }


        }


    }
}
