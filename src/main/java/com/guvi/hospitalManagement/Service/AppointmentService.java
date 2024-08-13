package com.guvi.hospitalManagement.Service;

import com.guvi.hospitalManagement.Repository.AppointmentRepository;
import com.guvi.hospitalManagement.Entity.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository AppointmentRepo;

    public List<Appointment> DisplayAll(){
        return AppointmentRepo.findAll();
    }

    public void addAppointment(Appointment appointment){
        AppointmentRepo.save(appointment);
    }

}
