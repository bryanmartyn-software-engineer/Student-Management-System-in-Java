# Student Management System in Java

A comprehensive Student Management System built with Java and MySQL, featuring full CI/CD automation, containerized deployment, and team collaboration workflows.

**Project Repository:** https://github.com/bryanmartyn-software-engineer/Student-Management-System-in-Java

---

## Table of Contents

1. [Project Overview](#project-overview)
2. [Team Collaboration Workflow](#team-collaboration-workflow)
3. [Tech Stack](#tech-stack)
4. [Requirements](#requirements)
5. [Installation & Setup](#installation--setup)
6. [Build Automation with Maven](#build-automation-with-maven)
7. [Test Automation with JUnit](#test-automation-with-junit)
8. [Docker Deployment](#docker-deployment)
9. [Continuous Integration (CI) Setup](#continuous-integration-ci-setup)
10. [Project Structure](#project-structure)
11. [Database Schema](#database-schema)
12. [Usage](#usage)
13. [Future Enhancements](#future-enhancements)
14. [Contributors](#contributors)

---

## Project Overview

This application is designed for school staff and administrators to efficiently manage student records through a simple console interface. The system supports full CRUD (Create, Read, Update, Delete) operations on student data such as ID, first name, last name, major, phone number, GPA, and date of birth.

**Key Features:**
- Add new student records
- View and search student data
- Update existing student information
- Delete student records
- Sort students by major, last name, or first name
- MySQL database persistence via JDBC

---

## Team Collaboration Workflow

This project was developed using Git and GitHub with a **User-Based Branching Strategy**:
- Each team member works on their own branch (named after their username)
- Independent development without branch conflicts
- Regular integration into the `main` branch
- All changes reviewed and merged systematically

### Step 1: Forking and Cloning

Each team member forked the repository and cloned it locally:

```bash
git clone https://github.com/[username]/Student-Management-System-in-Java.git
```

### Step 2: Creating Branches

Branches were created for each developer:

```bash
git checkout -b bryan
git checkout -b aimaan
git checkout -b dinesh
git checkout -b annthony
```

### Step 3: Making Changes and Commits

Each developer made their changes with clear commit messages:

```bash
git add .
git commit -m "Description of changes made"
git push origin [branch-name]
```

### Step 4: Integrating Changes

Changes were merged into the main branch:

```bash
git checkout main
git pull origin main
git merge [branch-name]
git push origin main
```

---

## Tech Stack

| Component | Technology |
|-----------|------------|
| Language | Java (JDK 8+) |
| Database | MySQL (via XAMPP) |
| Build Automation | Apache Maven |
| Testing Framework | JUnit 5 |
| Version Control | Git & GitHub |
| CI/CD Pipeline | GitHub Actions |
| Containerization | Docker |

---

## Requirements

- Java 8 or higher (JDK)
- MySQL Server (XAMPP Control Panel recommended)
- Apache Maven
- Docker Desktop (for containerized deployment)
- Git

---

## Installation & Setup

### 1. Clone the Repository

```bash
git clone https://github.com/your_username/student-management-system.git
cd student-management-system
```

### 2. Database Setup with XAMPP

1. Download and install XAMPP from https://www.apachefriends.org/
2. Run XAMPP Control Panel as Administrator
3. Install Apache and MySQL services
4. Start both services
5. Click "Admin" under MySQL to open phpMyAdmin
6. Create a database named `student_data`
7. Click on the database and go to the Import tab
8. Import the `student_data.sql` file from the project
9. Click Go to complete the import

### 3. Update Database Connection

Update the MySQL connection details in `dbConnect.java` if needed:

```java
String url = "jdbc:mysql://localhost:3306/student_data";
String username = "root";
String password = "";
```

---

## Build Automation with Maven

### Step 1: Setup Maven

1. Download Maven from https://maven.apache.org/download.cgi
2. Extract the binary zip archive file
3. Setup environment variables:
   - `MAVEN_HOME` pointing to Maven directory
   - Add `%MAVEN_HOME%\bin` to `PATH`
4. Verify installation: `mvn -version`

### Step 2: Configure pom.xml

The `pom.xml` includes:
- Project dependencies (MySQL Connector, JUnit)
- Build plugins (Maven Compiler Plugin)
- Build configurations

Key dependencies added:
```xml
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.33</version>
</dependency>
```

### Step 3: Build the Project

```bash
# Clean and build the project
mvn clean install

# Generate build reports
mvn clean install site
```

### Step 4: Verify Build Output

After successful build, you should see:
```
[INFO] BUILD SUCCESS
[INFO] Total time: X.XXX s
```

The build produces:
- Compiled classes in `/target/classes/`
- Packaged JAR file in `/target/`
- Build reports in `/target/site/`

---

## Test Automation with JUnit

### Step 1: Add JUnit Dependencies

The following dependencies were added to `pom.xml`:

```xml
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-api</artifactId>
    <version>5.9.2</version>
    <scope>test</scope>
</dependency>
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-engine</artifactId>
    <version>5.9.2</version>
    <scope>test</scope>
</dependency>
```

### Step 2: Configure Maven Surefire Plugin

```xml
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-surefire-plugin</artifactId>
    <version>3.0.0-M9</version>
</plugin>
```

### Step 3: Test Cases Implemented

| Test Method | Description |
|-------------|-------------|
| testAddStudent() | Tests inserting a new student into the database |
| testSearchStudent() | Tests retrieving a student record by ID |
| testUpdateStudent() | Tests updating existing student information |
| testSortStudentsByName() | Tests sorting students by first name |

### Step 4: Run Tests

```bash
# Execute all unit tests
mvn test

# Run specific test class
mvn test -Dtest=StudentManagementTest
```

### Step 5: Generate Test Reports

```bash
mvn surefire-report:report
```

**Report Locations:**
- `/target/surefire-reports/` - Raw test output
- `/target/site/surefire-report.html` - HTML formatted report

---

## Docker Deployment

### Step 1: Install Required Software

- **Docker Desktop:** https://www.docker.com/products/docker-desktop/
- **Eclipse Temurin (OpenJDK):** https://adoptium.net/
- **VcXsrv (for Windows GUI support):** https://vcxsrv.com/

### Step 2: Create Dockerfile

Create a file named `Dockerfile` in the project root:

```dockerfile
FROM eclipse-temurin:11-jdk

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN apt-get update && apt-get install -y maven

RUN mvn clean package

CMD ["java", "-jar", "target/student-management-system-1.0-SNAPSHOT.jar"]
```

### Step 3: Build Docker Image

```bash
docker build -t student-management-system .
```

### Step 4: Run Container

```bash
# On Linux/Mac
docker run -it --rm student-management-system

# On Windows (with VcXsrv for GUI support)
docker run -it --rm -e DISPLAY=host.docker.internal:0 student-management-system
```

### Step 5: Create Deployment Script

Create `deploy.sh` (Linux/Mac) or `deploy.bat` (Windows):

```bash
#!/bin/bash
echo "Building Docker image..."
docker build -t student-management-system .

echo "Running container..."
docker run -it --rm student-management-system
```

---

## Continuous Integration (CI) Setup

### Step 1: Create CI Configuration Directory

```bash
mkdir -p .github/workflows
```

### Step 2: Create GitHub Actions Workflow

Create file: `.github/workflows/ci.yml`

```yaml
name: CI Pipeline

on:
  push:
    branches: [ main, develop ]
  pull_request:
    branches: [ main ]

jobs:
  build:
    runs-on: ubuntu-latest

    steps:
    - uses: actions/checkout@v3

    - name: Set up JDK 11
      uses: actions/setup-java@v3
      with:
        java-version: '11'
        distribution: 'temurin'

    - name: Build with Maven
      run: mvn clean compile

    - name: Run tests
      run: mvn test

    - name: Generate test report
      run: mvn surefire-report:report

    - name: Upload test reports
      uses: actions/upload-artifact@v3
      with:
        name: test-reports
        path: target/surefire-reports/
```

### Step 3: Push CI Configuration to Repository

```bash
git add .github/workflows/ci.yml
git commit -m "Add GitHub Actions CI pipeline"
git push origin main
```

### Step 4: Verify CI Pipeline

1. Go to GitHub repository
2. Click on "Actions" tab
3. Verify the workflow runs on each push
4. Check build and test results

---

## Project Structure

```
student-management-system/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/studentmanagement/
│   │           ├── Main.java           # Application entry point
│   │           ├── dbConnect.java      # Database connection handler
│   │           ├── AppGUI.java         # Console interface
│   │           └── Table.java          # Table for database
│   └── test/
│       └── java/
│           └── com/studentmanagement/
│               └── StudentDatabaseTest.java
├── .github/
│   └── workflows/
│       └── ci.yml                      # GitHub Actions CI pipeline
├── pom.xml                              # Maven configuration
├── Dockerfile                           # Docker container definition
├── student_data.sql                     # Database schema
├── deploy.sh                            # Deployment script
└── README.md                            # Project documentation
```

---

## Database Schema

The database table used in this project has the following columns:

| Column | Type | Description |
|--------|------|-------------|
| Student_ID | INT (Primary Key) | Unique student identifier |
| first_name | VARCHAR(50) | Student's first name |
| last_name | VARCHAR(50) | Student's last name |
| major | VARCHAR(100) | Academic major |
| Phone | VARCHAR(15) | Contact number |
| GPA | DECIMAL(3,2) | Grade point average |
| DOB | DATE | Date of birth |

### Import Database from Command Line

```bash
mysql -u username -p database_name < student_data.sql
```

- **username** refers to your MySQL username
- **database_name** refers to the database you want to import
- You will be prompted to enter your password

---

## Usage

1. Launch the application
2. Select the desired operation from the main menu
3. Follow the prompts to enter or update student data

**Menu Options:**
- Add a new student
- View all students
- Search for a student
- Update student information
- Delete a student
- Sort students
- Exit

---

## Contributors

| No | Student Name | Student ID |
|----|--------------|------------|
| 1 | Bryan Martyn aka. SABAH HIDUP | [2205957] |
| 2 | Aimaan aka. MAT MELAYU| [Your ID] |
| 3 | Dinesh aka. LAST SEM BOSS | [Your ID] |
| 4 | Annthony aka. ANTMAN | [2100728] |

---

## Acknowledgments

- Original project inspiration from [OpenGenus](https://iq.opengenus.org/student-management-system-in-java/)
- UTAR Faculty of Information and Communication Technology
- UECS2363 Software Construction and Configuration course instructors

---

**Course:** UECS2363 Software Construction and Configuration  
**Assignment:** Assignment 2 - Continuous Integration and Automation Scripts  
**University:** Universiti Tunku Abdul Rahman