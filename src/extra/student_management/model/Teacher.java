package extra.student_management.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Teacher extends Person implements Comparable<Teacher> {
    private String specialist;
    public Teacher() {

    }
    public Teacher(String id, String name, String gender, String dateOfBirth, String specialist) {
        super(id, name, dateOfBirth, gender);
        this.specialist = specialist;
    }

    public String getSpecialist() {
        return specialist;
    }

    public void setSpecialist(String specialist) {
        this.specialist = specialist;
    }
    public String getInfor() {
        return String.format("%s,%s,%s,%s,%s", this.getId(), this.getName(), this.getGender(), this.getDateOfBirth(), this.getSpecialist());
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "specialist='" + specialist + '\'' +
                '}' +
                super.toString();
    }
    @Override
    public int compareTo(Teacher o) {
        String[] name = new String[0];
        for (int i = 0; i < getName().length(); i++) {
            name = getName().split(" ");
        }
        return name[name.length - 1].compareTo(o.getName());
    }

}
