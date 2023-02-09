package com.bksoft.absence.repository;

import com.bksoft.absence.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("select s from Student s where s.registrationNumber in ?1" )
    List<Student> findAllStudentIn(List<String> registrationNumbers);
    List<Student> findByClassroomCodeAndRegistrationNumberNotIn(String classroomCode,
                                                                List<String> registrationNumbers);
    Student findByRegistrationNumber(String registrationNumber);
}
