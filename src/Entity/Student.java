package Entity;

public class Student {
    private int id;
    private String name;
    private int age;
    private double gpa;

    public Student(String name, int age, double gpa) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String displayInfo() {
        return "Student [Name: " + name + ", Age: " + age + ", GPA: " + gpa + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return age == student.age && Double.compare(student.gpa, gpa) == 0 && name.equals(student.name);
    }

    @Override
    public int hashCode() {
        return 31 * age + Double.hashCode(gpa) + name.hashCode();
    }

    @Override
    public String toString() {
        return "Student [Name: " + name + ", Age: " + age + ", GPA: " + gpa + "]";
    }
}



