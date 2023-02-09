package com.bksoft.absence.features.structure.services.impl;

import com.bksoft.absence.features.structure.payload.StudentDto;
import com.bksoft.absence.features.structure.services.IStudentService;
import com.bksoft.absence.models.*;
import com.bksoft.absence.repository.ClassroomRepository;
import com.bksoft.absence.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService implements IStudentService {

    StudentRepository studentRepository;
    ClassroomRepository classroomRepository;

    public StudentService(StudentRepository studentRepository, ClassroomRepository classroomRepository) {
        this.studentRepository = studentRepository;
        this.classroomRepository = classroomRepository;
    }

    @Override
    public void addAllClassroomStudents(String classroomCode, List<StudentDto> studentsDto) {
        Classroom classroom = classroomRepository.findByCode(classroomCode);
        List<Student> students = new ArrayList<>();
        studentsDto.stream().forEach(
                studentDto -> {
                    Student newStd = studentDto.getStudent();
                    newStd.setClassroom(classroom);
                    students.add(newStd);
                }
        );
        studentRepository.saveAll(students);
    }
    @Override
    public List<Student> getAllClassroomStudents(String classroomCode) {
        return classroomRepository.findByCode(classroomCode)
                .getStudents();
    }
}
