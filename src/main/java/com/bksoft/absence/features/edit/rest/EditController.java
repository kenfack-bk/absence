package com.bksoft.absence.features.edit.rest;

import com.bksoft.absence.payload.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import com.bksoft.absence.mappers.AbsenceListMapper;
import com.bksoft.absence.models.Student;
import com.bksoft.absence.features.edit.service.EditService;

/**
 * implement use case : Edit absence
 */
@RestController
@CrossOrigin
@RequestMapping("/api/absence")
public class EditController {
    @Autowired
    private EditService editService;

    @GetMapping("/edit/{code}/{date}")
    public  ResponseEntity<EditAbsencePayload> fetchDataForEditAbsence(
            @PathVariable(name = "code") String code,
            @PathVariable(name = "date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date){
        Map<Student, List<Long>> data = editService.fetchClassroomAbsences(code, date);
        List<AbsenceLine> results = AbsenceListMapper.convertAbsencelinesFrom(data);
        return new ResponseEntity<>(new EditAbsencePayload(code, date, results),  HttpStatus.OK);
    }

    @PostMapping("/edit")
    public ResponseEntity<String> editAbsence(@Valid @RequestBody EditAbsencePayload request){
        editService.editAbsences(request);
        return new ResponseEntity<>("Absences enregistrées avec succès",  HttpStatus.OK);
    }

    @PutMapping("/edit/justify")
    public ResponseEntity<String> justifyAbsence(@Valid @RequestBody JustifyAbsenceRequest request){
        editService.justifyAbsences(request);
        return ResponseEntity.ok()
                .body("Absences justifiées avec succès");
    }
}
