package miu.edu.cs.cs544.CourseRegistrationSystem.Model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class RegistrationGroupStudents {
    @Id
    @Column(name="registration_group_id")
    private int regroupid;
    @Column(name="students_id")
    private int student_id;

    public int getRegroupid() {
        return regroupid;
    }

    public void setRegroupid(int regroupid) {
        this.regroupid = regroupid;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }
}
