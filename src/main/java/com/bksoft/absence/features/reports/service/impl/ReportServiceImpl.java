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
    public StudentReportPayload buildStudentStatData(String registrationNumber, LocalDate startDate,
                                                     LocalDate endDate) {
        Student student = studentRepository.findByRegistrationNumber(registrationNumber);
        List<Absence> absences = absenceRepository.findByStudentRegistrationNumberAndAbsenceDateBetween(
                registrationNumber, startDate, endDate);
        if(absences == null || absences.isEmpty()){
            return new StudentReportPayload(0, 0,
                    registrationNumber, student.getName(), new ArrayList<>());
        }

        int totalAbsences = 0;
        int totalJustifyAbsences = 0;
        List<StudentReportPayload.Item>  stats = new ArrayList<>();
        for (Absence abs : absences) {
            totalAbsences += abs.getSlot().getDuration();
            if(abs.isJustify()) totalJustifyAbsences += abs.getSlot().getDuration();
            stats.add(new StudentReportPayload.Item(abs));
        }
        stats.stream().sorted(Comparator.comparing(StudentReportPayload.Item::getAbsenceDate));
        return new StudentReportPayload(totalAbsences, totalJustifyAbsences,
                registrationNumber, student.getName(), stats);
    }

    @Override
    public ClassroomReportPayload buildClassroomStatData(String classroomCode, LocalDate startDate, LocalDate endDate) {
        Classroom cls = classroomRepository.findByCode(classroomCode);
        List<ClassroomReportPayload.IClassroomReportItem> rawData = absenceRepository.findClassroomAbsences(cls.getId(), startDate, endDate);

        Map<String, ClassroomReportPayload.Item> data = new HashMap<>();
        AtomicInteger totalAbsencesDuration  = new AtomicInteger();
        AtomicInteger totalJustifyAbsencesDuration = new AtomicInteger();

        List<String> registrationNumbers = new ArrayList<>();

        rawData.stream().forEach(
                item -> {
                    ClassroomReportPayload.Item elem = data.get(item.getRegistrationNumber());
                    if(elem == null){
                        ClassroomReportPayload.Item newItem = new ClassroomReportPayload.Item(item.getRegistrationNumber(), item.getName(),
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

        List<Student> students = studentRepository
                .findByClassroomCodeAndRegistrationNumberNotIn(classroomCode,
                registrationNumbers);

        students.stream().forEach(
                student -> {
                    data.put(student.getRegistrationNumber(), new ClassroomReportPayload.Item(student.getRegistrationNumber(),
                            student.getName(), 0,0));
                }
        );

        return new ClassroomReportPayload(classroomCode, totalAbsencesDuration.get(),
                totalJustifyAbsencesDuration.get(), new ArrayList<>(data.values()));
    }
}
