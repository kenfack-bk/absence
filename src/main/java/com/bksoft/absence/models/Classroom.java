package com.bksoft.absence.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "classrooms", uniqueConstraints = {
        @UniqueConstraint(columnNames = "code")})
public class Classroom extends BaseEntity{

    private String code; // field - level. ex: GL-1
    private String fieldOfStudy;
    private int level;

    @OneToMany(
            mappedBy = "classroom",
            fetch = FetchType.LAZY)
    private List<Student> students;

    public Classroom() {
    }

    public Classroom(String code, String fieldOfStudy, int level) {
        this.code = code;
        this.fieldOfStudy = fieldOfStudy;
        this.level = level;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFieldOfStudy() {
        return fieldOfStudy;
    }

    public void setFieldOfStudy(String fieldOfStudy) {
        this.fieldOfStudy = fieldOfStudy;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
