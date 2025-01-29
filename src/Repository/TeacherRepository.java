package Repository;

import Data.DB;
import Entity.Teacher;
import Repository.Interface.ITeacherRepository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public abstract class TeacherRepository implements ITeacherRepository {
    private final DB db;

    public TeacherRepository(DB db) {
        this.db = db;
    }

    @Override
    public boolean createTeacher(Teacher teacher) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO teachers(name, subject, experience) VALUES (?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, teacher.getName());
            stmt.setString(2, teacher.getSubject());
            stmt.setInt(3, teacher.getExperience());

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
    public Teacher getTeacher(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id, name, subject, experience FROM teachers WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Teacher(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("subject"),
                        rs.getInt("experience"));
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
    public List<Teacher> getAllTeachers() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id, name, subject, experience FROM teachers";
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(sql);
            List<Teacher> teachers = new LinkedList<>();
            while (rs.next()) {
                Teacher teacher = new Teacher(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("subject"),
                        rs.getInt("experience"));
                teachers.add(teacher);
            }
            return teachers;
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
    public boolean updateTeacher(int id, String name, String subject, int experience) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "UPDATE Teacher SET name = ?, subject = ?, experience = ? WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, subject);
            stmt.setInt(3, experience);
            stmt.setInt(4, id);

            stmt.executeUpdate();
            System.out.println("Teacher updated successfully!");
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
    public boolean deleteTeacher(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "DELETE FROM Teacher WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Teacher deleted successfully!");
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
}