package com.example.lab7;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/header")
public class HeaderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1>Header Tùy Chi ̉nh</h1>");
        out.println("<p>X-Custom-Header: " + req.getHeader("X-Custom-Header") + "</p>");
        out.println("<a href='index.html'>Quay lại</a>");
        out.println("</body></html>");
    }
}
