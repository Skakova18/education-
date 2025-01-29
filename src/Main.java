import java.sql.*;
import java.math.BigDecimal;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "adepte_xiao00";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        System.out.print("How many students do you want to add? ");
        int studentCount = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < studentCount; i++) {
            System.out.println("\nEnter information for Student " + (i + 1) + ":");
            System.out.print("Enter student name: ");
            String studentName = scanner.nextLine();
            System.out.print("Enter student age: ");
            int studentAge = scanner.nextInt();

            double studentGpa;
            while (true) {
                System.out.print("Enter student GPA: ");
                if (scanner.hasNextDouble()) {
                    studentGpa = scanner.nextDouble();
                    scanner.nextLine();
                    break;
                } else {
                    System.out.println("Invalid input. Please enter a valid GPA (e.g., 3.5). ");
                    scanner.next();
                }
            }

            Student student = new Student(studentName, studentAge, studentGpa);
            try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
                insertStudent(conn, student);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        System.out.print("\nHow many teachers do you want to add? ");
        int teacherCount = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < teacherCount; i++) {
            System.out.println("\nEnter information for Teacher " + (i + 1) + ":");
            System.out.print("Enter teacher name: ");
            String teacherName = scanner.nextLine();
            System.out.print("Enter teacher subject: ");
            String teacherSubject = scanner.nextLine();
            System.out.print("Enter teacher years of experience: ");
            int teacherExperience = scanner.nextInt();
            scanner.nextLine();

            Teacher teacher = new Teacher(teacherName, teacherSubject, teacherExperience);
            try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
                insertTeacher(conn, teacher);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        scanner.close();
    }

    private static void insertStudent(Connection conn, Student student) throws SQLException {
        String sql = "INSERT INTO students (name, age, gpa) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, student.getName());
            pstmt.setInt(2, student.getAge());
            pstmt.setBigDecimal(3, BigDecimal.valueOf(student.getGpa()));
            pstmt.executeUpdate();
            System.out.println("Inserted student: " + student.getName());
        }
    }

    private static void insertTeacher(Connection conn, Teacher teacher) throws SQLException {
        String sql = "INSERT INTO teachers (name, subject, experience) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, teacher.getName());
            pstmt.setString(2, teacher.getSubject());
            pstmt.setInt(3, teacher.getExperience());
            pstmt.executeUpdate();
            System.out.println("Inserted teacher: " + teacher.getName());
        }
    }
}

class Student {
    private String name;
    private int age;
    private double gpa;

    public Student(String name, int age, double gpa) {
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getGpa() {
        return gpa;
    }
}

class Teacher {
    private String name;
    private String subject;
    private int experience;

    public Teacher(String name, String subject, int experience) {
        this.name = name;
        this.subject = subject;
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public String getSubject() {
        return subject;
    }

    public int getExperience() {
        return experience;
    }
}
