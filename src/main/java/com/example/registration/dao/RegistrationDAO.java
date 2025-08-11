package com.example.registration.dao;

import com.example.registration.model.Registration;
import com.example.registration.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class RegistrationDAO {

    // ✅ Check if this student is already registered for this course
    public boolean existsRegistration(Long studentId, Long courseId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT 1 FROM Registration r WHERE r.student.id = :sid AND r.course.id = :cid";
            return session.createQuery(hql)
                          .setParameter("sid", studentId)
                          .setParameter("cid", courseId)
                          .uniqueResult() != null;
        }
    }

    // ✅ Save registration
    public void saveRegistration(Registration registration) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.save(registration);
            tx.commit();
        }
    }

    // ✅ Get registrations for a student
    public List<Registration> getByStudentId(Long studentId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                    "FROM Registration r WHERE r.student.id = :sid", Registration.class)
                          .setParameter("sid", studentId)
                          .list();
        }
    }
}
