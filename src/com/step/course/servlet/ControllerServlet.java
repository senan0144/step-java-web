package com.step.course.servlet;

import com.step.course.util.ValidationUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ControllerServlet", urlPatterns = "/cs")
public class ControllerServlet extends HttpServlet {

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
            System.out.println(action);
        }

        if (action.equals("register")) {

            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");

            if (!ValidationUtil.validate(firstName, lastName)) {
                request.setAttribute("message", "Zehmet olmasa butun xanalari doldurun");
                request.getRequestDispatcher("WEB-INF/view/index.jsp").forward(request, response);
                return;
            }


            System.out.println("firstName = " + firstName);
            System.out.println("lastName = " + lastName);

            request.setAttribute("message", "Qeydiyyat ugurla bitdi");
            request.getRequestDispatcher("WEB-INF/view/result.jsp").forward(request, response);

        } else if (action.equals("login")) {

            String username = request.getParameter("username");
            String password = request.getParameter("password");

            if (!ValidationUtil.validate(username, password)) {
                request.setAttribute("message", "Zehmet olmasa butun xanalari doldurun");
                request.getRequestDispatcher("WEB-INF/view/index.jsp").forward(request, response);
                return;
            }

            if (username.equals("user") && password.equals("123")) {
                request.setAttribute("message", "Salam " + username + "!");
                request.getRequestDispatcher("WEB-INF/view/result.jsp").forward(request, response);
            } else {
                request.setAttribute("message", "Username ve ya Parol sehvdir");
                request.getRequestDispatcher("WEB-INF/view/index.jsp").forward(request, response);

            }
        }


    }


}
