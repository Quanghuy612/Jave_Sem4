package com.example.lab_5;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/user-bean")
public class UserBeanServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String name = req.getParameter("name");
        String ageStr = req.getParameter("age");
        int age = ageStr != null && !ageStr.isEmpty() ? Integer.parseInt(ageStr) : 0;

        User user = new User();
        user.setName(name);
        user.setAge(age);

        // Đưa JavaBean vào request scope
        req.setAttribute("user", user);

        // Forward tới user.jsp để hiển thị
        RequestDispatcher dispatcher = req.getRequestDispatcher("/user.jsp");
        dispatcher.forward(req, resp);
    }
}
