package service;


import model.Student;
import util.LoggerUtil;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentService {
    private static final Logger logger = LoggerUtil.getLogger(StudentService.class);
    private static final ArrayList<Student> students = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public void addStudent() {
        try {
            System.out.print("Enter Student ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            if (getStudentById(id) != null) {
                System.out.println("Student ID already exists. Try again.");
                return;
            }

            System.out.print("Enter Student Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Student Marks (0–100): ");
            double marks = scanner.nextDouble();
            if (marks < 0 || marks > 100) {
                System.out.println("Marks must be between 0 and 100.");
                return;
            }

            students.add(new Student(id, name, marks));
            System.out.println("Student added successfully!");
            logger.info("Added student with ID: " + id);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid data.");
            logger.log(Level.WARNING, "Invalid input while adding student.", e);
            scanner.nextLine();
        }
    }

    public void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records available.");
            return;
        }
        System.out.println("\n--- Student Records ---");
        for (Student student : students) {
            System.out.println(student);
        }
        logger.info("Viewed all students.");
    }

    public void updateStudent() {
        try {
            System.out.print("Enter Student ID to update: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            Student student = getStudentById(id);
            if (student == null) {
                System.out.println("Student not found.");
                return;
            }

            System.out.print("Enter new name: ");
            String name = scanner.nextLine();
            System.out.print("Enter new marks (0–100): ");
            double marks = scanner.nextDouble();

            if (marks < 0 || marks > 100) {
                System.out.println("Marks must be between 0 and 100.");
                return;
            }

            student.setName(name);
            student.setMarks(marks);
            System.out.println("Student updated successfully!");
            logger.info("Updated student with ID: " + id);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid data.");
            logger.log(Level.WARNING, "Invalid input while updating student.", e);
            scanner.nextLine();
        }
    }

    public void deleteStudent() {
        try {
            System.out.print("Enter Student ID to delete: ");
            int id = scanner.nextInt();

            Student student = getStudentById(id);
            if (student == null) {
                System.out.println("Student not found.");
                return;
            }

            students.remove(student);
            System.out.println("Student deleted successfully!");
            logger.info("Deleted student with ID: " + id);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid data.");
            logger.log(Level.WARNING, "Invalid input while deleting student.", e);
            scanner.nextLine();
        }
    }

    private Student getStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }
}

