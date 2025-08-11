package com.example.registration.servlet;

import com.example.registration.dao.RegistrationDAO;
import com.example.registration.dao.StudentDAO;
import com.example.registration.model.Registration;
import com.example.registration.model.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class ScheduleServlet extends HttpServlet {

    private final RegistrationDAO registrationDAO = new RegistrationDAO();
    private final StudentDAO studentDAO = new StudentDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String studentIdStr = req.getParameter("studentId");
        String email = req.getParameter("email");
        String name  = req.getParameter("name");

        Long studentId = null;

        try {
            if (studentIdStr != null && !studentIdStr.isEmpty()) {
                // Case 1: Access via studentId (e.g., after registration)
                studentId = Long.parseLong(studentIdStr);
            } 
            else if (email != null && name != null && !email.isEmpty() && !name.isEmpty()) {
                // Case 2: Access via name + email (from search form)
                Student student = studentDAO.findByEmail(email);
                if (student == null || !student.getName().equalsIgnoreCase(name)) {
                    req.setAttribute("error", "No student found with the provided name and email.");
                    req.getRequestDispatcher("search-registrations.jsp").forward(req, resp);
                    return;
                }
                studentId = student.getId();
            } 
            else {
                // No valid params
                resp.sendRedirect("courses");
                return;
            }

            // Fetch registrations for this student
            List<Registration> registrations = registrationDAO.getByStudentId(studentId);
            req.setAttribute("registrations", registrations);
            req.setAttribute("studentId", studentId);

            // Forward to schedule.jsp
            RequestDispatcher dispatcher = req.getRequestDispatcher("schedule.jsp");
            dispatcher.forward(req, resp);

        } catch (NumberFormatException e) {
            resp.sendRedirect("courses?error=Invalid+Student+ID");
        }
    }
}
