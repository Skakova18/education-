package Entity;

import jdk.internal.classfile.impl.RawBytecodeHelper;

public class Worker extends Teacher {
    private static final RawBytecodeHelper rs = null;
    public String name;
        public int experience;
        private String department;
        public Worker (String department){
            super(rs.getInt(Integer.parseInt("id")), rs.toString(), rs.toString(), rs.getInt(Integer.parseInt("experience")));
            this.department = department;
        }


        public Worker(String name,String subject, int experience) {
            super(name,subject,  experience);
            this.name = name;
            this.experience = experience;
        }

        public String getName() {
            return name;
        }

        public int getExperience() {
            return experience;
        }
        public String getDepartment() {
            return department;
        }
        @Override
        public String displayInfo() {
            return "Entity.Worker [Name: " + name + ", subject: " + subject + ", experience: " + experience + ", department: " + department + "]";
        }
    }


