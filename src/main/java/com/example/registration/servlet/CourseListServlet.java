package com.example.registration.servlet;

import com.example.registration.dao.CourseDAO;
import com.example.registration.model.Course;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class CourseListServlet extends HttpServlet {
    private final CourseDAO courseDAO = new CourseDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // If a single course ID is requested: /courses?courseId=5
        String courseIdParam = req.getParameter("courseId");
        if (courseIdParam != null) {
            try {
                Long courseId = Long.parseLong(courseIdParam);
                Course course = courseDAO.getCourseById(courseId);
                req.setAttribute("course", course);
                RequestDispatcher rd = req.getRequestDispatcher("course-details.jsp");
                rd.forward(req, resp);
                return;
            } catch (NumberFormatException e) {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid course ID.");
                return;
            }
        }

        // Otherwise: show all courses
        List<Course> courseList = courseDAO.getAllCourses();
        req.setAttribute("courses", courseList);

        RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
        dispatcher.forward(req, resp);
    }
}
