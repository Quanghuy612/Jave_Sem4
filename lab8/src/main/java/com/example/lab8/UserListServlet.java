package com.example.lab8;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/users")
public class UserListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<User> users = new ArrayList<>();
        try (Connection conn =
                     DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root","123456")) {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users");
                    ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setAge(rs.getInt("age"));
                users.add(user);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        req.setAttribute("users", users);
        RequestDispatcher dispatcher =
                req.getRequestDispatcher("/users.jsp");
        dispatcher.forward(req, resp);
    }
}
