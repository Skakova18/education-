import Entity.Student;
import Entity.Teacher;

import java.util.Arrays;
public class Institution {
    public String name;
    public String location;
    public Student[] student;
    public Teacher[] teachers;

    public Institution(String name, String location, Student[] student, Teacher[] teachers) {
        this.name = name;
        this.location = location;
        this.student = student;
        this.teachers = teachers;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Student[] getStudent() {
        return student;
    }

    public void setStudent(Student[] student) {
        this.student = student;
    }

    public Teacher[] getTeachers() {
        Teacher[] Teacher;
        return teachers;
    }

    public void displayInfo() {
        System.out.println("Institution [Name: " + name + ", Location: " + location + "]");
        System.out.println("Students:");
        for (Student student : student) {
            System.out.println(student.displayInfo());
        }
        System.out.println("Teachers:");
        for (Teacher teacher : teachers) {
            System.out.println(teacher.displayInfo());
        }
    }

    public void filterStudentsByGpa(double minGpa) {
        System.out.println("Students with GPA >= " + minGpa + ":");
        Arrays.stream(student)
                .filter(student -> student.getGpa() >= minGpa)
                .forEach(System.out::println);
    }

    public void filterTeachersByExperience(int minExperience) {
        System.out.println("Teachers with Experience >= " + minExperience + " years:");
        Arrays.stream(teachers)
                .filter(teacher -> teacher.getExperience() >= minExperience)
                .forEach(System.out::println);
    }

    public void sortStudentsByGpa() {
        System.out.println("Students sorted by GPA:");
        Arrays.stream(student)
                .sorted((s1, s2) -> Double.compare(s2.getGpa(), s1.getGpa()))
                .forEach(System.out::println);
    }

    public void sortTeachersByExperience() {
        System.out.println("Teachers sorted by Experience:");
        Arrays.stream(teachers)
                .sorted((t1, t2) -> Integer.compare(t2.getExperience(), t1.getExperience()))
                .forEach(System.out::println);
    }

    public void searchPersonByName(String name) {
        System.out.println("Searching for " + name + ":");
        Arrays.stream(student)
                .filter(student -> student.getName().equals(name))
                .forEach(System.out::println);
        Arrays.stream(teachers)
                .filter(teacher -> teacher.getName().equals(name))
                .forEach(System.out::println);

    }
}

