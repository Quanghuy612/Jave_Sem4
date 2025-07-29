package com.example.lab8;

import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
@WebListener
public class SessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        ServletContext context = se.getSession().getServletContext();
        Integer activeSessions = (Integer)
                context.getAttribute("activeSessions");
        if (activeSessions == null) {
            activeSessions = 0;
        }
        activeSessions++;
        context.setAttribute("activeSessions", activeSessions);
        System.out.println("Phiên mới được tạo: " + se.getSession().getId());
    }
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        ServletContext context = se.getSession().getServletContext();
        Integer activeSessions = (Integer)
                context.getAttribute("activeSessions");
        if (activeSessions != null) {
            activeSessions--;
            context.setAttribute("activeSessions", activeSessions);
        }
        System.out.println("Phiên bị hủy: " + se.getSession().getId());
    }
}