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

import java.util.List;

@Controller
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private DoctorService doctorService;


    @GetMapping("/appointmentForm")

    public String appointmentForm(Model model){
        model.addAttribute("appointment",new Appointment());
        return "bookAppointment";
    }



    @PostMapping("/appointmentForm")
    public String saveAppointment(@ModelAttribute("appointment") Appointment appointment,
                                  @RequestParam("doctorId")int doctorId){
        Doctor doctor = doctorService.findDoctorById(doctorId);
        appointment.setDoctor(doctor);
        appointmentService.addAppointment(appointment);
        return "saveSuccessfully";
    }

    @GetMapping("/doctorAppointment")

    public String displayAllDoctor(Model model){
        List<Doctor> doctors = doctorService.displayAll();
        model.addAttribute("doctor",doctors);
        return "doctorAppointment";
    }

    @GetMapping("/displayAppointment")

    public String displayAllAppointment(Model model){
        List<Appointment> appointmentList = appointmentService.DisplayAll();
        model.addAttribute("appointment",appointmentList);
        return "viewAppointment";
    }
}
