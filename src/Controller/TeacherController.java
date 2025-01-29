package Controller;

import Entity.Teacher;
import Repository.Interface.ITeacherRepository;

import java.util.List;

public class TeacherController {
    private final ITeacherRepository repo;

    public TeacherController(ITeacherRepository repo) {
        this.repo = repo;
    }

    public String createTeacher(String name, String subject, int experience) {
        Teacher teacher = new Teacher(name, subject, experience);

        boolean created = repo.createTeacher(teacher);

        return (created ? "Teacher Created" : "Teacher Not Created");
    }

    public String getTeacher(int id) {
        Teacher teacher = repo.getTeacher(id);

        return (teacher != null ? teacher.getName() : "Teacher Not Found");
    }

    public String getAllTeachers() {
        List<Teacher> teachers = repo.getAllTeachers();
        return (teachers != null ? teachers.toString() : "Teachers Not Found");
    }

    public String deleteTeacher(int id) {
        boolean deleted = repo.deleteTeacher(id);
        return (deleted ? "Teacher Deleted" : "Teacher Not Found");
    }

    public String updateTeacher(int id, String name, String subject, int experience) {
        boolean updated = repo.updateTeacher(id, name, subject, experience);
        return (updated ? "Teacher Updated" : "Teacher Not Updated");
    }
}
