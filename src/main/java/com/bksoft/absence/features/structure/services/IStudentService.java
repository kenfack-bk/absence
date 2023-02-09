package com.bksoft.absence.features.structure.services;

import com.bksoft.absence.features.reports.payload.StudentReportData;
import com.bksoft.absence.features.structure.payload.StudentDto;
import com.bksoft.absence.models.Student;

import java.util.List;

public interface IStudentService {

    void addAllClassroomStudents(String classroomCode, List<StudentDto> students);
    List<Student> getAllClassroomStudents(String classroomCode);

}
