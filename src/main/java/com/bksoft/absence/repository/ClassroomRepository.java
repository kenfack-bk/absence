package com.bksoft.absence.repository;

import com.bksoft.absence.models.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassroomRepository extends JpaRepository<Classroom, Long> {
    Classroom findByCode(String code);
}
