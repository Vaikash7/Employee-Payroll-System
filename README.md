# 💼 Employee Payroll Management System

> A **console-based Java application** for managing employee records and payroll calculations using **JDBC and MySQL**.

<p align="center">

![Java](https://img.shields.io/badge/Java-17+-orange?style=for-the-badge\&logo=openjdk)
![JDBC](https://img.shields.io/badge/JDBC-Database%20Connectivity-blue?style=for-the-badge)
![MySQL](https://img.shields.io/badge/MySQL-Database-4479A1?style=for-the-badge\&logo=mysql\&logoColor=white)
![SQL](https://img.shields.io/badge/SQL-Database%20Queries-lightgrey?style=for-the-badge)

</p>

---

## 📌 Table of Contents

<details>
<summary><b>Click to expand</b></summary>

* [Project Overview](#-project-overview)
* [Features](#-features)
* [Application Workflow](#-application-workflow)
* [Architecture](#-architecture)
* [Technologies Used](#-technologies-used)
* [Project Structure](#-project-structure)
* [Database Design](#-database-design)
* [Payroll Calculation](#-payroll-calculation)
* [Application Menu](#-application-menu)
* [How to Run](#-how-to-run)
* [Example](#-example)
* [Key Concepts](#-key-concepts)
* [Future Enhancements](#-future-enhancements)
* [Author](#-author)

</details>

---

# 📖 Project Overview

The **Employee Payroll Management System** is a Java-based console application designed to manage employee information and calculate payroll details.

The application uses **JDBC (Java Database Connectivity)** to communicate with a **MySQL database**.

It follows a simple layered architecture:

```text
User
  │
  ▼
Main / Console
  │
  ▼
Service Layer
  │
  ▼
DAO Layer
  │
  ▼
JDBC
  │
  ▼
MySQL Database
```

The system allows users to perform CRUD operations on employee records and calculate salary after applicable deductions.

---

# ✨ Features

### 👤 Employee Management

* ➕ Add new employees
* 🔍 Search employees
* ✏️ Update employee details
* 🗑️ Delete employees
* 📋 View employee records

### 💰 Payroll Management

* Calculate employee salary
* Calculate deductions
* Calculate net salary
* Display payroll information

### 🗄️ Database

* MySQL database integration
* JDBC connectivity
* SQL-based CRUD operations
* Prepared Statements for database queries

### 🏗️ Architecture

* Model layer
* DAO layer
* Service layer
* Main/Console layer

---

# 🔄 Application Workflow

```text
                ┌──────────────────┐
                │      User        │
                └────────┬─────────┘
                         │
                         ▼
                ┌──────────────────┐
                │ Console / Main   │
                └────────┬─────────┘
                         │
                         ▼
                ┌──────────────────┐
                │ Service Layer    │
                │                  │
                │ Business Logic   │
                └────────┬─────────┘
                         │
                         ▼
                ┌──────────────────┐
                │ DAO Layer        │
                │                  │
                │ SQL Operations   │
                └────────┬─────────┘
                         │
                         ▼
                ┌──────────────────┐
                │ JDBC             │
                │                  │
                │ DB Connection    │
                └────────┬─────────┘
                         │
                         ▼
                ┌──────────────────┐
                │ MySQL Database   │
                └──────────────────┘
```

---

# 🏗️ Architecture

The application follows a **layered architecture** to separate responsibilities.

| Layer       | Responsibility                       |
| ----------- | ------------------------------------ |
| **Model**   | Represents employee and payroll data |
| **DAO**     | Handles database operations          |
| **Service** | Contains business logic              |
| **Main**    | Handles console interaction          |

### Example

```text
Main.java
    │
    ▼
EmployeeService.java
    │
    ▼
EmployeeDAO.java
    │
    ▼
DBConnection.java
    │
    ▼
MySQL
```

This separation makes the application easier to maintain and extend.

---

# 🛠️ Technologies Used

| Technology                   | Purpose                   |
| ---------------------------- | ------------------------- |
| ☕ **Java**                   | Application development   |
| 🔌 **JDBC**                  | Java-MySQL connectivity   |
| 🐬 **MySQL**                 | Data storage              |
| 🗃️ **SQL**                  | CRUD and database queries |
| 🏗️ **Layered Architecture** | Code organization         |

---

# 📁 Project Structure

```text
Employee-Payroll-Management-System/
│
├── src/
│   │
│   ├── model/
│   │   ├── Employee.java
│   │   └── Payroll.java
│   │
│   ├── dao/
│   │   └── EmployeeDAO.java
│   │
│   ├── service/
│   │   └── EmployeeService.java
│   │
│   ├── util/
│   │   └── DBConnection.java
│   │
│   └── Main.java
│
├── sql/
│   └── employee_payroll.sql
│
└── README.md
```

---

# 🗄️ Database Design

The application uses MySQL to store employee information.

### Employee Table

```sql
CREATE TABLE employees (
    employee_id INT PRIMARY KEY AUTO_INCREMENT,
    employee_name VARCHAR(100) NOT NULL,
    department VARCHAR(100),
    designation VARCHAR(100),
    basic_salary DECIMAL(10,2),
    deductions DECIMAL(10,2)
);
```

### Example Data

| ID | Name  | Department | Designation  | Basic Salary | Deductions |
| -: | ----- | ---------- | ------------ | -----------: | ---------: |
|  1 | John  | IT         | Developer    |        50000 |       5000 |
|  2 | David | HR         | HR Executive |        45000 |       4000 |
|  3 | Sarah | Finance    | Analyst      |        55000 |       6000 |

---

# 💰 Payroll Calculation

The application calculates the employee's net salary based on the basic salary and deductions.

```text
Net Salary = Basic Salary - Deductions
```

### Example

```text
Basic Salary   = ₹50,000
Deductions     = ₹5,000
-------------------------
Net Salary     = ₹45,000
```

The payroll logic can be extended to include:

```text
Basic Salary
      +
Allowances
      -
Deductions
      =
Net Salary
```

---

# 🖥️ Application Menu

When the application starts, the user can interact with the system through a console menu.

```text
========================================
       EMPLOYEE PAYROLL SYSTEM
========================================

1. Add Employee
2. View Employees
3. Search Employee
4. Update Employee
5. Delete Employee
6. Calculate Payroll
7. Exit

Enter your choice:
```

---

# ➕ Add Employee

Example:

```text
Enter Employee Name: John
Enter Department: IT
Enter Designation: Software Developer
Enter Basic Salary: 50000
Enter Deductions: 5000

Employee added successfully!
```

---

# 🔍 Search Employee

```text
Enter Employee ID: 101

--------------------------------
Employee Details
--------------------------------
ID          : 101
Name        : John
Department  : IT
Designation : Software Developer
Salary      : ₹50,000
Deductions  : ₹5,000
Net Salary  : ₹45,000
--------------------------------
```

---

# ✏️ Update Employee

The application allows users to update employee information such as:

```text
Employee Name
Department
Designation
Basic Salary
Deductions
```

The updated information is stored directly in MySQL.

---

# 🗑️ Delete Employee

Users can delete an employee using the employee ID.

```text
Enter Employee ID: 101

Employee deleted successfully!
```

---

# 🔌 JDBC Database Connectivity

The application uses JDBC to establish a connection between Java and MySQL.

Example:

```java
Connection connection = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/payroll_db",
    "root",
    "your_password"
);
```

> ⚠️ Do not commit your actual database password to GitHub. Use environment variables or a configuration file excluded through `.gitignore`.

---

# 🚀 How to Run

## 1️⃣ Clone the Repository

```bash
git clone https://github.com/Vaikash7/Employee-Payroll-Management-System.git
```

```bash
cd Employee-Payroll-Management-System
```

---

## 2️⃣ Create MySQL Database

Open MySQL and execute:

```sql
CREATE DATABASE payroll_db;

USE payroll_db;
```

Then execute the SQL script provided in:

```text
sql/employee_payroll.sql
```

---

## 3️⃣ Configure Database Connection

Update the database configuration in:

```text
DBConnection.java
```

Example:

```java
String url = "jdbc:mysql://localhost:3306/payroll_db";
String username = "root";
String password = "your_password";
```

---

## 4️⃣ Add MySQL JDBC Driver

Make sure the **MySQL Connector/J** dependency is available in your project.

For Maven:

```xml
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <version>9.4.0</version>
</dependency>
```

---

## 5️⃣ Run the Application

Open the project in:

* IntelliJ IDEA
* Eclipse
* VS Code
* Any Java-supported IDE

Run:

```text
Main.java
```

---

# 🧪 Example Flow

```text
Application Started
        │
        ▼
Connect to MySQL
        │
        ▼
Display Menu
        │
        ▼
User Selects "Add Employee"
        │
        ▼
Enter Employee Details
        │
        ▼
EmployeeService
        │
        ▼
EmployeeDAO
        │
        ▼
JDBC INSERT
        │
        ▼
MySQL
        │
        ▼
Employee Added Successfully
```

---

# 🧠 Key Concepts Demonstrated

This project demonstrates practical knowledge of:

* Java OOP
* Classes and Objects
* Encapsulation
* Exception Handling
* JDBC
* MySQL
* SQL CRUD operations
* Prepared Statements
* Database Connectivity
* DAO Pattern
* Service Layer
* Layered Architecture
* Business Logic
* Console-based Application Development

---

# 💡 What I Learned

Through this project, I gained practical experience in:

* Connecting Java applications with MySQL using JDBC
* Designing database tables
* Performing CRUD operations using SQL
* Separating application logic using layered architecture
* Implementing payroll calculation logic
* Handling database exceptions
* Working with Prepared Statements
* Building a complete console-based Java application

---

# 🔮 Future Enhancements

Possible improvements:

* [ ] Add employee login/authentication
* [ ] Add admin and employee roles
* [ ] Generate monthly salary slips
* [ ] Export payroll reports to PDF
* [ ] Add attendance management
* [ ] Add tax calculation
* [ ] Add leave management
* [ ] Build a JavaFX/Spring Boot frontend
* [ ] Add unit testing with JUnit
* [ ] Add Docker support

---

# 📸 Screenshots

Add screenshots of your application here:

```text
screenshots/
│
├── main-menu.png
├── add-employee.png
├── employee-list.png
├── payroll-calculation.png
└── mysql-database.png
```

Example:

```markdown
## 📸 Application Preview

![Main Menu](screenshots/main-menu.png)

![Employee Details](screenshots/employee-list.png)

![Payroll Calculation](screenshots/payroll-calculation.png)
```

---

# 👨‍💻 Author

### Chatrathi Vaikash

**Computer Science & Engineering Graduate**

💻 Java | Python | SQL | Snowflake | Azure | PySpark

### 🔗 GitHub

[![GitHub](https://img.shields.io/badge/GitHub-Vaikash7-181717?style=for-the-badge\&logo=github)](https://github.com/Vaikash7)

---

⭐ **If you found this project useful, consider giving the repository a star!**
