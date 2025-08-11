package com.example.registration.dao;

import com.example.registration.model.Student;
import com.example.registration.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class StudentDAO {

    // ✅ Save a new student
    public void saveStudent(Student student) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.save(student);
            tx.commit();
        }
    }

    // ✅ Lookup existing student by email
    public Student findByEmail(String email) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Student s WHERE s.email = :email";
            return session.createQuery(hql, Student.class)
                          .setParameter("email", email)
                          .uniqueResult();
        }
    }

    // ✅ Lookup student by ID (useful for schedule/results)
    public Student getStudentById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Student.class, id);
        }
    }

    // ✅ Update an existing student
    public void updateStudent(Student student) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.update(student);
            tx.commit();
        }
    }
}
