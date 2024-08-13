package com.guvi.hospitalManagement.Controller;

import com.guvi.hospitalManagement.Entity.Medication;
import com.guvi.hospitalManagement.Service.MedicationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@Tag(name = "Medication Management System", description = "APIs for managing medications")
public class MedicationController {

    @Autowired
    private MedicationService medicationService;

    @Operation(summary = "View all medications")
    @GetMapping("/viewMedicine")

    public String showAllMedicine(Model model){
        List<Medication> medicines = medicationService.displayAll();
        model.addAttribute("medicine",medicines);

        return "viewMedicines";
    }
    @Operation(summary = "Get the form to add a new medication")
    @GetMapping("/addMedicine")

    public String getAddMedicineForm(){
        return "addMedicine";
    }
    @Operation(summary = "Add a new medication")
    @PostMapping("/addMedicine")
    public String addEmployee(@ModelAttribute Medication medication){

        medicationService.saveMedicine(medication);
        return "redirect:/viewMedicine";
    }

    @Operation(summary = "Get the form to update a medication")
    @GetMapping("/updateMedicine/{Id}")
    public String showMedicineUpdate(@PathVariable(value = "Id") int Id, Model model){
        Medication medicine = medicationService.getMedicineById(Id);
        model.addAttribute("medicine",medicine);
        return "updateMedicine";
    }
    @Operation(summary = "Update a medication")
    @PostMapping ("/updateMedicine/{Id}")
    public String updateEmployee(@PathVariable (value = "Id") int Id,@ModelAttribute("medicine") Medication medication) {
        medicationService.updateMedicine(Id,medication);

        return "redirect:/viewMedicine";
    }
    @Operation(summary = "Delete a medication")
    @GetMapping("/deleteMedicine/{Id}")
    public String deleteEmployee(@PathVariable (value = "Id") int Id,Model model) {
        Medication medicine=medicationService.deleteMedicineById(Id);
        model.addAttribute("medicine",medicine);
        return "redirect:/viewMedicine";
    }


}
