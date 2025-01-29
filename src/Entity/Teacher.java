package Entity;

public class Teacher {
    public String name;
    public String subject;
    public int  experience;
    public Teacher(int id, String name, String subject, int experience) {}

    public Teacher(String name, String subject, int experience) {
        this.name=name;
        this.subject=subject;
        this.experience=experience;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int   experience) {
        this.experience = experience;
    }
    public String displayInfo() {
        return "Entity.Teacher [Name: " + name + ", subject: " + subject + ", experience : " + experience + "]";
    }
    public int equals(Teacher otherTeachers) {
        return this.experience;
    }

    public String toString() {
        return super.toString() + ", Subject: " + subject + ", Experience: " + experience + " years";
    }

    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        Teacher teacher = (Teacher) obj;
        return experience == teacher.experience && subject.equals(teacher.subject);
    }

    public int hashCode() {
        return super.hashCode() + experience * 31 + subject.hashCode();
    }
}