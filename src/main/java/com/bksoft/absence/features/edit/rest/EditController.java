package com.bksoft.absence.features.edit.rest;

import com.bksoft.absence.payload.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public  ResponseEntity<EditAbsenceResponse> fetchDataForEditAbsence(
            @PathVariable(name = "code") String code,
            @PathVariable(name = "date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date){
        Map<Student, List<Long>> data = editService.fetchClassroomAbsences(code, date);
        List<AbsenceLine> results = AbsenceListMapper.convertAbsencelinesFrom(data);
        return new ResponseEntity<>(new EditAbsenceResponse(code, date, results),  HttpStatus.OK);
    }

    @PostMapping("/edit")
    public ResponseEntity<ApiResponse> editAbsence(@Valid @RequestBody EditAbsenceRequest request){
        editService.editAbsences(request);
        return new ResponseEntity<>(new ApiResponse("Absences enregistrées avec succès"),  HttpStatus.OK);
    }

    @PutMapping("/edit/justify")
    public ResponseEntity<ApiResponse> justifyAbsence(@Valid @RequestBody JustifyAbsenceRequest request){
        editService.justifyAbsences(request);
        return ResponseEntity.ok()
                .body(new ApiResponse("Absences justifiées avec succès"));
    }
}
