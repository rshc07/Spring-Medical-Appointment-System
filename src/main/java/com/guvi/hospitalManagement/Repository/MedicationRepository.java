package com.guvi.hospitalManagement.Repository;

import com.guvi.hospitalManagement.Entity.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicationRepository extends JpaRepository<Medication,Integer> {
}
