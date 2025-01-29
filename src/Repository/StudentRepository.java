package Repository;

import Data.DB;
import Entity.Student;
import Repository.Interface.IStudentRepository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public abstract class StudentRepository implements IStudentRepository {
    private final DB db;

    public StudentRepository(DB db) {
        this.db = db;
    }

    @Override
    public boolean createStudent(Student student) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO Student(name, age, gpa) VALUES (?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, student.getName());
            stmt.setInt(2, student.getAge());
            stmt.setDouble(3, student.getGpa());

            stmt.execute();
            return true;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public Student getStudent(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id, name, age, gpa FROM Student WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Student(
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getDouble("gpa"));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Student> getAllStudent() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id, name, age, gpa FROM Student";
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(sql);
            List<Student> Student = new LinkedList<>();
            while (rs.next()) {
                Student student = new Student(
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getDouble("gpa"));
               boolean add = Student.add(student);
            }
            return Student;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public boolean updateStudent(int id, String name) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "UPDATE Student SET name = ? WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setInt(2, id);

            stmt.executeUpdate();
            System.out.println("Student updated successfully!");
            return true;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean deleteStudent(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "DELETE FROM Student WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Student deleted successfully!");
            return true;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean insertStudent(Student student) {
        // Implement the method as required by the IStudentRepository interface
        return false;
    }
}