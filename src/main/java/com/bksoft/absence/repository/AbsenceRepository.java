package com.bksoft.absence.repository;

import com.bksoft.absence.features.reports.payload.ClassroomReportItem;
import com.bksoft.absence.features.reports.payload.IClassroomReportItem;
import com.bksoft.absence.models.Absence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface AbsenceRepository extends JpaRepository<Absence, Long> {

    List<Absence> findByAbsenceDateAndClassroomCode(LocalDate date, String code);
    List<Absence> findByAbsenceDateAndStudentIdAndSlotId(LocalDate date, Long studentId, Long slotId);
    List<Absence> findByAbsenceDateAndStudentId(LocalDate absenceDate, Long id);
    List<Absence> findByStudentRegistrationNumberAndAbsenceDateBetween(
            String registrationNumber, LocalDate startDate, LocalDate endDate);

    @Query(nativeQuery = true, value =
            "SELECT std.registration_number as registrationNumber, std.name as name, abs.absence_date as absenceDate, abs.justify as justify,  slt.duration as duration " +
                    "FROM students as std " +
                    "JOIN absences as abs " +
                    "ON std.id = abs.student_id " +
                    "JOIN slots as slt " +
                    "ON slt.id = abs.slot_id " +
                    "AND abs.classroom_id = ?1 " +
                    "AND abs.absence_date BETWEEN ?2 AND ?3 " +
                    "ORDER BY std.name")
    List<IClassroomReportItem> findClassroomAbsences(Long classroomId, LocalDate startDate, LocalDate endDate);
}
