package com.bksoft.absence.features.structure.payload;

import com.bksoft.absence.models.Student;
import com.bksoft.absence.models.Tutor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
    private String registrationNumber;
    private String name;
    private String email;
    private String phoneNumber;
    private String classroomCode;
    private Tutor tutor;

    public Student getStudent(){
        Student std =  new Student(registrationNumber, name, email, phoneNumber);
        std.setTutor(tutor);
        return std;
    }
}
