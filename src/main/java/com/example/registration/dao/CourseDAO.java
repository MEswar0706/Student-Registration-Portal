package com.example.registration.dao;

import com.example.registration.model.Course;
import com.example.registration.util.HibernateUtil;
import org.hibernate.Session;
import java.util.List;

public class CourseDAO {

    // ✅ Get a list of all courses
    public List<Course> getAllCourses() {
        List<Course> courses;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            courses = session.createQuery("FROM Course", Course.class).list();
        }
        return courses;
    }

    // ✅ Get one course by ID
    public Course getCourseById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Course.class, id);
        }
    }
}
