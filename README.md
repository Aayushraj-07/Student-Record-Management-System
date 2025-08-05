**Student Record Management System**
A Java CLI-based CRUD application to manage student records. This project allows adding, viewing, updating, and deleting student data, designed with a modular package structure following Java best practices.

**Features**

-> Add, View, Update, Delete (CRUD) student records

-> Logger Utility for tracking system activities

-> Package-based architecture (model, service, util) for scalability

-> Input validation for robust error handling

**Project Structure**

StudentManagementSystem/
 └── src/
      ├── Main.java
      ├── model/
      │     └── Student.java
      ├── service/
      │     └── StudentService.java
      └── util/
            └── LoggerUtil.java


-> Main.java: Entry point with menu-driven CLI.

-> Student.java: Data model representing a student.

-> StudentService.java: Business logic for CRUD operations.

-> LoggerUtil.java: Utility for centralized logging.


**Tools & Technologies**

-> Language: Java (JDK 8+)

-> IDE: IntelliJ IDEA

-> Logger: Java Util Logging

-> ollections: ArrayList for storing records
