package com.bksoft.absence.features.reports.service.impl;

import com.bksoft.absence.features.reports.payload.*;
import com.bksoft.absence.features.reports.service.ReportService;
import com.bksoft.absence.models.Absence;
import com.bksoft.absence.models.Classroom;
import com.bksoft.absence.models.Student;
import com.bksoft.absence.repository.AbsenceRepository;
import com.bksoft.absence.repository.ClassroomRepository;
import com.bksoft.absence.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ReportServiceImpl implements ReportService {

    AbsenceRepository absenceRepository;
    StudentRepository studentRepository;
    ClassroomRepository classroomRepository;

    public ReportServiceImpl(AbsenceRepository absenceRepository, StudentRepository studentRepository,
                             ClassroomRepository classroomRepository) {
        this.absenceRepository = absenceRepository;
        this.studentRepository = studentRepository;
        this.classroomRepository = classroomRepository;
    }

    @Override
    public StudentReportData buildStudentStatData(String registrationNumber, LocalDate startDate,
                                                  LocalDate endDate) {
        Student student = studentRepository.findByRegistrationNumber(registrationNumber);
        List<Absence> absences = absenceRepository.findByStudentRegistrationNumberAndAbsenceDateBetween(
                registrationNumber, startDate, endDate);
        if(absences == null || absences.isEmpty()){
            return new StudentReportData(0, 0,
                    registrationNumber, student.getName(), new ArrayList<>());
        }

        int totalAbsences = 0;
        int totalJustifyAbsences = 0;
        List<StudentReportItem>  stats = new ArrayList<>();
        for (Absence abs : absences) {
            totalAbsences += abs.getSlot().getDuration();
            if(abs.isJustify()) totalJustifyAbsences += abs.getSlot().getDuration();
            stats.add(new StudentReportItem(abs));
        }
        stats.stream().sorted(Comparator.comparing(StudentReportItem::getAbsenceDate));
        return new StudentReportData(totalAbsences, totalJustifyAbsences,
                registrationNumber, student.getName(), stats);
    }

    @Override
    public ClassroomReportData buildClassroomStatData(String classroomCode, LocalDate startDate, LocalDate endDate) {
        Classroom cls = classroomRepository.findByCode(classroomCode);
        List<IClassroomReportItem> rawData = absenceRepository.findClassroomAbsences(cls.getId(), startDate, endDate);

        Map<String, ClassroomReportItem> data = new HashMap<>();
        AtomicInteger totalAbsencesDuration  = new AtomicInteger();
        AtomicInteger totalJustifyAbsencesDuration = new AtomicInteger();

        List<String> registrationNumbers = new ArrayList<>();

        rawData.stream().forEach(
                item -> {
                    ClassroomReportItem elem = data.get(item.getRegistrationNumber());
                    if(elem == null){
                        ClassroomReportItem newItem = new ClassroomReportItem(item.getRegistrationNumber(), item.getName(),
                                item.getDuration(), item.isJustify() ? item.getDuration() : 0);
                        data.put(item.getRegistrationNumber(), newItem);
                        if (item.isJustify()){
                            totalJustifyAbsencesDuration.set(totalJustifyAbsencesDuration.get() + item.getDuration());
                        }
                    } else {
                        elem.setTotalAbsences( elem.getTotalAbsences() + item.getDuration());
                        if (item.isJustify()){
                            elem.setTotalJustifyAbsences(elem.getTotalJustifyAbsences() + item.getDuration());
                            totalJustifyAbsencesDuration.set(totalJustifyAbsencesDuration.get() + item.getDuration());
                        }
                    }
                    totalAbsencesDuration.set(totalAbsencesDuration.get() + item.getDuration());
                    registrationNumbers.add(item.getRegistrationNumber());
                }
        );

        List<Student> students = studentRepository.findByClassroomCodeAndRegistrationNumberNotIn(classroomCode,
                registrationNumbers);
        students.stream().forEach(
                student -> {
                    data.put(student.getRegistrationNumber(), new ClassroomReportItem(student.getRegistrationNumber(),
                            student.getName(), 0,0));
                }
        );

        return new ClassroomReportData(classroomCode, totalAbsencesDuration.get(),
                totalJustifyAbsencesDuration.get(), new ArrayList<>(data.values()));
    }
}
