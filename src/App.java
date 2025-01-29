import Controller.StudentController;
import Controller.TeacherController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    private final StudentController studentController;
    private final TeacherController teacherController;
    private final Scanner scanner;

    public App(StudentController studentController, TeacherController teacherController) {
        this.studentController = studentController;
        this.teacherController = teacherController;
        scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Welcome to the Management System");
        while (true) {
            System.out.println();
            System.out.println("Please enter your choice:");
            System.out.println("1. Add a new student");
            System.out.println("2. Update student");
            System.out.println("3. Delete student");
            System.out.println("4. Get all students");
            System.out.println("5. Get student by id");
            System.out.println("6. Add a new teacher");
            System.out.println("7. Update teacher");
            System.out.println("8. Delete teacher");
            System.out.println("9. Get all teachers");
            System.out.println("10. Get teacher by id");
            System.out.println("11. Exit");
            System.out.println();

            try {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1 -> createStudentMenu();
                    case 2 -> updateStudentMenu();
                    case 3 -> deleteStudentMenu();
                    case 4 -> getAllStudentsMenu();
                    case 5 -> getStudentMenu();
                    case 6 -> createTeacherMenu();
                    case 7 -> updateTeacherMenu();
                    case 8 -> deleteTeacherMenu();
                    case 9 -> getAllTeachersMenu();
                    case 10 -> getTeacherMenu();
                    default -> {
                        return;
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid choice");
                scanner.next();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void createStudentMenu() {
        System.out.println("Please enter the name of the student");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.println("Please enter the age of the student");
        int age = scanner.nextInt();
        System.out.println("Please enter the GPA of the student");
        double gpa = scanner.nextDouble();

        String response = studentController.createStudent(name, age, gpa);
        System.out.println(response);
    }

    public void getAllStudentsMenu() {
        String response = studentController.getAllStudents();
        System.out.println(response);
    }

    public void getStudentMenu() {
        System.out.println("Please enter the id of the student");
        int id = scanner.nextInt();
        String response = studentController.getStudent(id);
        System.out.println(response);
    }

    public void updateStudentMenu() {
        System.out.println("Please enter the id of the student, the new name, age, and GPA of the student");
        int id = scanner.nextInt();
        scanner.nextLine();
        String name = scanner.nextLine();
        int age = scanner.nextInt();
        double gpa = scanner.nextDouble();
        String response = studentController.updateStudent(id, name, age, gpa);
        System.out.println(response);
    }

    public void deleteStudentMenu() {
        System.out.println("Please enter the id of the student");
        int id = scanner.nextInt();
        String response = studentController.deleteStudent(id);
        System.out.println(response);
    }

    public void createTeacherMenu() {
        System.out.println("Please enter the name of the teacher");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.println("Please enter the subject of the teacher");
        String subject = scanner.nextLine();
        System.out.println("Please enter the experience of the teacher in years");
        int experience = scanner.nextInt();

        String response = teacherController.createTeacher(name, subject, experience);
        System.out.println(response);
    }

    public void getAllTeachersMenu() {
        String response = teacherController.getAllTeachers();
        System.out.println(response);
    }

    public void getTeacherMenu() {
        System.out.println("Please enter the id of the teacher");
        int id = scanner.nextInt();
        String response = teacherController.getTeacher(id);
        System.out.println(response);
    }

    public void updateTeacherMenu() {
        System.out.println("Please enter the id of the teacher, the new name, subject, and experience of the teacher");
        int id = scanner.nextInt();
        scanner.nextLine();
        String name = scanner.nextLine();
        String subject = scanner.nextLine();
        int experience = scanner.nextInt();
        String response = teacherController.updateTeacher(id, name, subject, experience);
        System.out.println(response);
    }

    public void deleteTeacherMenu() {
        System.out.println("Please enter the id of the teacher");
        int id = scanner.nextInt();
        String response = teacherController.deleteTeacher(id);
        System.out.println(response);
    }
}