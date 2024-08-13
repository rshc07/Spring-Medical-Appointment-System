package com.guvi.hospitalManagement.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalTime;

@Entity
@Table(name = "Doctors")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "doctor_Id")
    private int doctorId;
    private String doctorName;
    private String specialization;
    private double consultationFee;
    private String availableSlot;
    private String availableTime;

}
