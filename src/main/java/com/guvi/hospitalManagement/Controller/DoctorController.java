package com.guvi.hospitalManagement.Controller;

import com.guvi.hospitalManagement.Entity.Appointment;
import com.guvi.hospitalManagement.Entity.Doctor;
import com.guvi.hospitalManagement.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping("/displayDoctor")

    public String displayAllDoctor(Model model){
        List<Doctor> doctors = doctorService.displayAll();
        model.addAttribute("doctor",doctors);
        return "viewDoctors";
    }

    @GetMapping("/doctorBook/{id}")

    public String getBookForm(@PathVariable(value = "id") int id,Model model){
        Doctor doctors = doctorService.findDoctorById(id);
        model.addAttribute("doctor",doctors);
        model.addAttribute("appointment", new Appointment());
        return "bookAppointment";
    }

}
