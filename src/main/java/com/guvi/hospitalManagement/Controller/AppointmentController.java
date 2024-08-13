package com.guvi.hospitalManagement.Controller;

import com.guvi.hospitalManagement.Entity.Appointment;
import com.guvi.hospitalManagement.Entity.Doctor;
import com.guvi.hospitalManagement.Service.AppointmentService;
import com.guvi.hospitalManagement.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;

import java.util.List;

@Controller
@Tag(name = "Appointment Management System", description = "APIs for managing appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private DoctorService doctorService;

    @Operation(summary = "View the appointment form")
    @GetMapping("/appointmentForm")

    public String appointmentForm(Model model){
        model.addAttribute("appointment",new Appointment());
        return "bookAppointment";
    }


    @Operation(summary = "Save a new appointment")
    @PostMapping("/appointmentForm")
    public String saveAppointment(@ModelAttribute("appointment") Appointment appointment,
                                  @RequestParam("doctorId")int doctorId){
        Doctor doctor = doctorService.findDoctorById(doctorId);
        appointment.setDoctor(doctor);
        appointmentService.addAppointment(appointment);
        return "saveSuccessfully";
    }
    @Operation(summary = "View all doctors")
    @GetMapping("/doctorAppointment")

    public String displayAllDoctor(Model model){
        List<Doctor> doctors = doctorService.displayAll();
        model.addAttribute("doctor",doctors);
        return "doctorAppointment";
    }
    @Operation(summary = "View all appointments")
    @GetMapping("/displayAppointment")

    public String displayAllAppointment(Model model){
        List<Appointment> appointmentList = appointmentService.DisplayAll();
        model.addAttribute("appointment",appointmentList);
        return "viewAppointment";
    }
}