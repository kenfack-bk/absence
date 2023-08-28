package com.bksoft.absence.models;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter @Setter @NoArgsConstructor
@Entity
@Table(name = "classrooms", uniqueConstraints = {
        @UniqueConstraint(columnNames = "code")})
public class Classroom extends BaseEntity{

    private String code; // field - level. ex: GL-1
    private String fieldOfStudy; // ex: génie logiciel
    private int level;

    @OneToMany(
            mappedBy = "classroom",
            fetch = FetchType.LAZY)
    private List<Student> students;

    public Classroom(String code, String fieldOfStudy, int level) {
        this.code = code;
        this.fieldOfStudy = fieldOfStudy;
        this.level = level;
    }
}
