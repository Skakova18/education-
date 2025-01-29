package Repository.Interface;
import Entity.Teacher;
import java.util.List;

public interface ITeacherRepository {
    boolean insertTeacher(Teacher teacher);

    boolean createTeacher(Teacher teacher);

    Entity.Teacher getTeacher(int id);
    List<Teacher> getAllTeacher();

    List<Teacher> getAllTeachers();

    boolean updateTeacher(int id, String name, String subject, int experience);
    boolean deleteTeacher(int id);
}
