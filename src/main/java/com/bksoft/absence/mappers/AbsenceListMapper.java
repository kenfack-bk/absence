package com.bksoft.absence.mappers;

import com.bksoft.absence.models.Student;
import com.bksoft.absence.payload.AbsenceLine;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AbsenceListMapper {

    public static List<AbsenceLine> convertAbsencelinesFrom(Map<Student, List<Long>> data){
        List<AbsenceLine> results = new ArrayList<>();
        if(data == null || data.isEmpty())
            return results;

        for(Map.Entry<Student, List<Long>> entry : data.entrySet()){
            results.add(new AbsenceLine(entry.getKey().getRegistrationNumber(), entry.getKey().getName(),
                    entry.getValue()));
        }

        return results;
    }
}
