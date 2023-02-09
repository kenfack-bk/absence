package com.bksoft.absence.features.edit.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bksoft.absence.models.Absence;
import com.bksoft.absence.models.Classroom;
import com.bksoft.absence.models.Slot;
import com.bksoft.absence.models.Student;
import com.bksoft.absence.payload.AbsenceLine;
import com.bksoft.absence.payload.EditAbsenceRequest;
import com.bksoft.absence.payload.JustifyAbsenceRequest;
import com.bksoft.absence.repository.AbsenceRepository;
import com.bksoft.absence.repository.ClassroomRepository;
import com.bksoft.absence.repository.SlotRepository;
import com.bksoft.absence.repository.StudentRepository;
import com.bksoft.absence.features.edit.service.EditService;


@Service
@Transactional
public class EditServiceImpl implements EditService {

    private AbsenceRepository absenceRepository;
    private SlotRepository slotRepository;
    private ClassroomRepository classroomRepository;
    private StudentRepository studentRepository;

    public EditServiceImpl(AbsenceRepository absenceRepository, SlotRepository slotRepository,
                           ClassroomRepository classroomRepository, StudentRepository studentRepository) {
        this.absenceRepository = absenceRepository;
        this.slotRepository = slotRepository;
        this.classroomRepository = classroomRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public Map<Student, List<Long>> fetchClassroomAbsences(String code, LocalDate absenceDate) {
        Classroom classRoom = classroomRepository.findByCode(code);
        List<Absence> absences = absenceRepository.findByAbsenceDateAndClassroomCode(absenceDate, code);
        List<Student> students = classRoom.getStudents();

        Map<Student, List<Long>> results = new HashMap<>();
        if (absences == null || absences.isEmpty()){
            for (Student student: students){
                results.put(student, new ArrayList<Long>());
            }
            return results;
        }

        for (Student student: students){
            results.put(student, getStudentAbsenceSlotIds(absences, student.getId()));
        }

        return results;
    }

    @Override
    public void editAbsences(EditAbsenceRequest request) {
        List<Slot> slots = slotRepository.findAll();
        Classroom classroom = classroomRepository.findByCode(request.getClassroomCode());
        List<Student> students = studentRepository.findAllStudentIn(
                getRegistrationNumbers(request.getData())
        );

        request.getData().forEach(
                line -> {
                    Student std = students.stream().filter(
                            student -> student.getRegistrationNumber().equals(line.getStudentRegistrationNumber())
                                    ).findFirst().orElse(null);
                    if(std != null){
                        saveAbsences(std, classroom, request.getAbsenceDate(), getSlotListFrom(slots, line.getSlotIds()));
                    }
                }
        );
    }

    @Override
    public void justifyAbsences(JustifyAbsenceRequest request) {
        Student student = studentRepository.findByRegistrationNumber(request.getRegistrationNumber());
        List<Absence> absences = absenceRepository.findByAbsenceDateAndStudentId(request.getAbsenceDate(),
                student.getId());
        for (Absence absence : absences) {
            if(request.getSlotIds().contains(absence.getSlot().getId())){
                absence.justify(request.getJustification());
            }
        }
        absenceRepository.saveAll(absences);
    }

    private List<Long> getStudentAbsenceSlotIds(List<Absence> abs, Long studentId){
        List<Long> ids = new ArrayList<>();
        abs.stream().forEach(
                absence -> {
                    if(absence.getStudent().getId() == studentId){
                        ids.add(absence.getSlot().getId());
                    }
                }
        );
        return ids;
    }

    private List<Slot> getSlotListFrom(List<Slot> slots, List<Long> ids){
        return slots.stream()
                .filter(slot -> ids.contains(slot.getId()))
                .collect(Collectors.toList());
    }

    private void saveAbsences(Student student, Classroom classroom, LocalDate absenceDate, List<Slot> newSlots){
        List<Absence> oldAbsences = absenceRepository.findByAbsenceDateAndStudentId(absenceDate, student.getId());
        List<Slot> oldSlots = oldAbsences.stream()
                .map(absence -> absence.getSlot())
                .collect(Collectors.toList());
        List<Slot> commonSlots = newSlots.stream()
                .distinct()
                .filter(oldSlots::contains)
                .collect(Collectors.toList());

        // remove obsolete absences
        List<Absence> absencesToRemove = new ArrayList<>();
        for(Absence absence: oldAbsences) {
            if (!newSlots.contains(absence.getSlot())) {
                absencesToRemove.add(absence);
            }
        }
        absenceRepository.deleteAll(absencesToRemove);

        // Add new absences  for new slots
        newSlots.removeAll(commonSlots);
        List<Absence> newAbsences = new ArrayList<>();
        for (Slot slot: newSlots) {
            newAbsences.add(new Absence(absenceDate, false, null, slot, student, classroom));
        }
        absenceRepository.saveAll(newAbsences);
    }

    private List<String> getRegistrationNumbers(List<AbsenceLine> absenceLines){
        List<String> registrationNumbers = new ArrayList<>();
        absenceLines.stream().forEach(
                absenceLine -> registrationNumbers.add(absenceLine.getStudentRegistrationNumber())
        );
        return registrationNumbers;
    }

}
