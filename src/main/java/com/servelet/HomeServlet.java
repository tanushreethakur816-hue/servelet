package com.servelet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        String username = (String) session.getAttribute("username");

        response.setContentType("text/html");

        response.getWriter().println("<h1>Welcome, " + username + "</h1>");
        response.getWriter().println("<p>This is a protected page.</p>");
        response.getWriter().println("<a href='logout'>Logout</a>");
    }
}