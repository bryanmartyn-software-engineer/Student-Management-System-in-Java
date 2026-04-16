# Student Management System in Java

A simple Student Management System built with Java and MySQL. Allows users to perform CRUD operations on student data.

**Project Link:** https://github.com/bryanmartyn-software-engineer/Student-Management-System-in-Java

---

## Team Members

| No | Student Name | Student ID |
|----|--------------|------------|
| 1 | Bryan Martyn | [2205957] |
| 2 | Aimaan | [Your ID] |
| 3 | Dinesh | [Your ID] |
| 4 | Annthony | [2100728] |

---

## Tech Stack

- Java (JDK 8+)
- MySQL (XAMPP)
- Maven (Build Automation)
- JUnit (Testing)
- GitHub Actions (CI/CD)
- Docker (Deployment)

---

## Setup Instructions

### 1. Clone Repository
```bash
git clone https://github.com/bryanmartyn-software-engineer/Student-Management-System-in-Java.git
```

### 2. Setup Database
- Start XAMPP and run MySQL
- Create database: `student_data`
- Import `student_data.sql`

### 3. Build Project
```bash
mvn clean install
```

### 4. Run Tests
```bash
mvn test
```

### 5. Run Application
```bash
mvn exec:java -Dexec.mainClass="com.studentmanagement.Main"
```

### 6. Run with Docker
```bash
docker build -t student-management-system .
docker run -it --rm student-management-system
```

---

## Features

- Add new student
- View all students
- Search student by ID
- Update student information
- Delete student
- Sort students by name/major

---

## Database Schema

| Column | Type |
|--------|------|
| Student_ID | INT (Primary Key) |
| first_name | VARCHAR(50) |
| last_name | VARCHAR(50) |
| major | VARCHAR(100) |
| Phone | VARCHAR(15) |
| GPA | DECIMAL(3,2) |
| DOB | DATE |

---

**Course:** UECS2363 Software Construction and Configuration  
**Assignment:** Assignment 2  
**University:** UTAR