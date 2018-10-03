package com.step.course.servlet;

import com.step.course.dao.StudentDaoImpl;
import com.step.course.model.Student;
import com.step.course.model.Teacher;
import com.step.course.service.StudentService;
import com.step.course.service.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
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
        }else if (action.equals("getStudentForm")){
            request.getRequestDispatcher("/WEB-INF/fragments/student-form.jsp").forward(request, response);

        } else if (action.equals("addStudent")) {
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            LocalDate dateOfBirth = LocalDate.parse(request.getParameter("dateOfBirth"));
            int idTeacher = Integer.parseInt(request.getParameter("idTeacher"));

            Student student = new Student();
            student.setFirstName(firstName);
            student.setLastName(lastName);
            student.setDateOfBirth(dateOfBirth);

            Teacher teacher = new Teacher();
            teacher.setId(idTeacher);
            student.setTeacher(teacher);

            boolean result = studentService.addStudent(student);

            if (!result) {
                throw new ServletException();
            }

        } else if(action.equals("updateStudent")) {
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            LocalDate dateOfBirth = LocalDate.parse(request.getParameter("dateOfBirth"));
            int idTeacher = Integer.parseInt(request.getParameter("idTeacher"));
            int idStudent = Integer.parseInt(request.getParameter("id"));

            Student student = new Student();
            student.setId(idStudent);
            student.setFirstName(firstName);
            student.setLastName(lastName);
            student.setDateOfBirth(dateOfBirth);
            Teacher teacher = new Teacher();
            teacher.setId(idTeacher);
            student.setTeacher(teacher);

            boolean result = studentService.updateStudent(student);

            if (!result) {
                throw new ServletException();
            }

        }


    }
}
