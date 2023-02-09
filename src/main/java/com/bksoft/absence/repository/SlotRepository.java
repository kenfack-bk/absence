package com.bksoft.absence.repository;

import com.bksoft.absence.models.Slot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SlotRepository extends JpaRepository<Slot, Long> {
}
