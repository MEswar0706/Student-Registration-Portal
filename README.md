# 🎓 Student Registration Portal

A Java EE web application (Servlets + JSP + JSTL + Hibernate + MySQL) that allows students to:
- View available courses
- Register for a course
- View their schedule
- Search their registered courses using name & email by Login
- View grades 

---

## 📌 Overview

The **Student Registration Portal** streamlines course enrollment by integrating:
- A presentation layer (JSP + CSS + JSTL)
- A control layer (Servlets)
- A persistence layer (Hibernate ORM)
- A MySQL database

It follows the MVC architecture.

### Core Features
- List all available courses
- Register for a course (prevents duplicates)
- View your course schedule by **studentId** (normal flow)
- Login and Find your registered courses by **name & email** (search flow directly leads to schedule page)
- Show grades if available (read-only)

---

## 🛠 Technologies Used

- **Java 21**
- **Apache Tomcat 9**
- **Hibernate ORM 5.4**
- **MySQL 8.x**
- **JSTL 1.2**
- **HTML5 / CSS3**
- **Maven** for build/dependency management

---

## 🗄 Database Schema

CREATE TABLE students (
id BIGINT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(100) NOT NULL,
email VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE courses (
id BIGINT PRIMARY KEY AUTO_INCREMENT,
code VARCHAR(20) NOT NULL,
name VARCHAR(100) NOT NULL,
schedule VARCHAR(50) NOT NULL
);

CREATE TABLE registrations (
id BIGINT PRIMARY KEY AUTO_INCREMENT,
student_id BIGINT NOT NULL,
course_id BIGINT NOT NULL,
grade VARCHAR(10),
UNIQUE (student_id, course_id),
FOREIGN KEY (student_id) REFERENCES students(id) ON DELETE CASCADE,
FOREIGN KEY (course_id) REFERENCES courses(id) ON DELETE CASCADE
);


---

## 🔄 Application Flow

### **Homepage (`/courses`) → `CourseListServlet`**
- Lists all courses from DB via `CourseDAO.getAllCourses()`.
- Navigation links:
  - Register for a Course → `/register`
  - Login → `/search-registrations.jsp`

### **Registration Flow (`/register`)**
- Loads a form with all courses (dropdown) from `CourseDAO`.
- User enters **name** + **email** and selects a course.
- `RegisterStudentServlet`:
  - Checks if student exists by email; if not, creates one.
  - Fetches selected course by ID.
  - Verifies student not already registered for the same course.
  - Saves registration.
  - Redirects to `/schedule?studentId={id}`.

### **Schedule Page (`/schedule`)**
- Uses `ScheduleServlet`:
  - **Case 1:** `studentId` in request (direct from registration flow).
  - **Case 2:** `name` + `email` from `search-registrations.jsp`.
    - Looks up student, validates name.
    - Loads registrations by `studentId`.
- Forwards to `schedule.jsp` to show registered courses (+ grades if available).

### **Login**
- `search-registrations.jsp` asks for **name** + **email**.
- Submits directly to `/schedule`.
- ScheduleServlet shows results in the same schedule page.

---

## ⚙ Setup Instructions

1. **Install MySQL** and create the database:
CREATE DATABASE studentdb;
USE studentdb;
-- Run schema above
   
2. **Configure Hibernate (hibernate.cfg.xml)**  
Update DB connection details:

3. **Build & Deploy**
Deploy WAR to Tomcat `/webapps/`.

4. **Start Tomcat** & visit:
http://localhost:8080/student-registration-portal/courses

---

## 👨‍🎓 Usage

### Student
- Browse available courses from homepage.
- Click "Register for a Course".
- Fill out name, email, pick a course → view your schedule.
- Or click "Login", enter name & email → view schedule followed by results.

### Grades
- Display-only in Results/Schedule pages.
- Must be updated directly in DB or via an admin panel (not implemented).

---

## ⚠ Important Notes

- **Avoid duplicate students**: `email` must be unique.
- **Avoid duplicate registrations**: `(student_id, course_id)` combination is unique.
- **Grades**: Stored in `registrations.grade`; not added via UI in current build.
- **Memory leak warnings on undeploy**: Close `SessionFactory` on `contextDestroyed` via `ServletContextListener` if needed.

---

## 🔮 Future Enhancements

- Admin login & grade entry UI.
- Bulk registration.
- Pagination on course list.
- Email confirmations.
- Role-based access (student vs admin).

---


## 👨‍💻 Author
Your Name — *Java Web Developer*

