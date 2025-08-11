package com.example.registration.servlet;

import com.example.registration.dao.CourseDAO;
import com.example.registration.dao.RegistrationDAO;
import com.example.registration.dao.StudentDAO;
import com.example.registration.model.Course;
import com.example.registration.model.Registration;
import com.example.registration.model.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class RegisterStudentServlet extends HttpServlet {
    private final StudentDAO studentDAO = new StudentDAO();
    private final CourseDAO courseDAO = new CourseDAO();
    private final RegistrationDAO registrationDAO = new RegistrationDAO();

    // Show registration form
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("courses", courseDAO.getAllCourses());
        RequestDispatcher dispatcher = req.getRequestDispatcher("register.jsp");
        dispatcher.forward(req, resp);
    }

    // Handle registration submission
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name  = req.getParameter("name");
        String email = req.getParameter("email");
        String courseIdStr = req.getParameter("courseId");

        // ✅ Basic validation
        if (name == null || email == null || courseIdStr == null ||
            name.isEmpty() || email.isEmpty()) {
            resp.sendRedirect("register?error=Missing+fields");
            return;
        }

        Long courseId = Long.parseLong(courseIdStr);

        // ✅ Find existing student by email, or create a new one
        Student student = studentDAO.findByEmail(email);
        if (student == null) {
            student = new Student(name, email);
            studentDAO.saveStudent(student);
        }

        // ✅ Get the selected course by ID
        Course course = courseDAO.getCourseById(courseId);
        if (course == null) {
            resp.sendRedirect("register?error=Invalid+course");
            return;
        }

        // ✅ Prevent same course registration twice
        if (registrationDAO.existsRegistration(student.getId(), courseId)) {
            resp.sendRedirect("schedule?studentId=" + student.getId() + "&error=Already+registered");
            return;
        }

        // ✅ Save registration
        Registration registration = new Registration(student, course);
        registrationDAO.saveRegistration(registration);

        // ✅ Redirect to schedule page
        resp.sendRedirect("schedule?studentId=" + student.getId());
    }
}
