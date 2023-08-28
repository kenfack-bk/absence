package com.bksoft.absence.payload;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AbsenceLine {

    private String studentRegistrationNumber;
    private String studentName;
    private List<Long> slotIds;

}
