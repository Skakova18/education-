package Controller;

import Entity.Student;
import Repository.Interface.IStudentRepository;

import java.util.List;

public class StudentController {
    private final IStudentRepository repo;

    public StudentController(IStudentRepository repo) {
        this.repo = repo;
    }

    public String createStudent(String name, int age, double gpa) {
        Student student = new Student(name, age, gpa);

        boolean created = repo.createStudent(student);

        return (created ? "Student Created" : "Student Not Created");
    }

    public String getStudent(int id) {
        Student student = repo.getStudent(id);

        return (student != null ? student.getName() : "Student Not Found");
    }

    public String getAllStudents() {
        List<Student> students = repo.getAllStudents();
        return (students != null ? students.toString() : "Students Not Found");
    }

    public String deleteStudent(int id) {
        boolean deleted = repo.deleteStudent(id);
        return (deleted ? "Student Deleted" : "Student Not Found");
    }

    public String updateStudent(int id, String name, int age, double gpa) {
        boolean updated = repo.updateStudent(id, name, age, gpa);
        return (updated ? "Student Updated" : "Student Not Updated");
    }
}