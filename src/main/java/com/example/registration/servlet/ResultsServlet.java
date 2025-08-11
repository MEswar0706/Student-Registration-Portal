package com.example.registration.servlet;

import com.example.registration.dao.RegistrationDAO;
import com.example.registration.model.Registration;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class ResultsServlet extends HttpServlet {

    private final RegistrationDAO registrationDAO = new RegistrationDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String studentIdStr = req.getParameter("studentId");

        // ✅ Redirect if no student ID
        if (studentIdStr == null || studentIdStr.isEmpty()) {
            resp.sendRedirect("courses");
            return;
        }

        try {
            Long studentId = Long.parseLong(studentIdStr);

            // ✅ Fetch registrations for this student
            List<Registration> registrations = registrationDAO.getByStudentId(studentId);

            req.setAttribute("registrations", registrations);
            req.setAttribute("studentId", studentId);

            RequestDispatcher dispatcher = req.getRequestDispatcher("results.jsp");
            dispatcher.forward(req, resp);

        } catch (NumberFormatException e) {
            resp.sendRedirect("courses?error=Invalid+Student+ID");
        }
    }
}
