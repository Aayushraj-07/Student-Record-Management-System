
import service.StudentService;
import util.LoggerUtil;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = LoggerUtil.getLogger(Main.class);
    private static final StudentService studentService = new StudentService();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        logger.info("Student Record Management System started.");

        while (running) {
            System.out.println("\n=== Student Record Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        studentService.addStudent();
                        break;
                    case 2:
                        studentService.viewStudents();
                        break;
                    case 3:
                        studentService.updateStudent();
                        break;
                    case 4:
                        studentService.deleteStudent();
                        break;
                    case 5:
                        running = false;
                        System.out.println("Exiting system. Goodbye!");
                        logger.info("System exited by user.");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                logger.log(Level.WARNING, "Invalid menu input detected.", e);
                scanner.nextLine();
            }
        }
        scanner.close();
    }
}
