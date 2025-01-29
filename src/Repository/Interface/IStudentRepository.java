package Repository.Interface;
import Entity.Student;

import java.util.List;

public interface IStudentRepository {
    boolean insertStudent(Student student);

    boolean createStudent(Student student);

    Entity.Student getStudent(int id);
    List<Student> getAllStudents();
    boolean updateStudent(int id, String name, int age, double gpa);

    List<Student> getAllStudent();

    boolean updateStudent(int id, String name);

    boolean deleteStudent(int id);
}