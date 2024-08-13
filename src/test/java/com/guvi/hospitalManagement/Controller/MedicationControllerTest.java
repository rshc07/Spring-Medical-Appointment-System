package com.guvi.hospitalManagement.Controller;

import com.guvi.hospitalManagement.Entity.Medication;
import com.guvi.hospitalManagement.Service.MedicationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MedicationControllerTest {

    @Mock
    private MedicationService medicationService;

    @Mock
    private Model model;

    @InjectMocks
    private MedicationController medicationController;

    @Test
    public void testShowAllMedicine() {
        List<Medication> medications = Collections.singletonList(new Medication());
        when(medicationService.displayAll()).thenReturn(medications);

        String viewName = medicationController.showAllMedicine(model);

        verify(model).addAttribute("medicine", medications);
        assertEquals("viewMedicines", viewName);
    }

    @Test
    public void testAddEmployee() {
        Medication medication = new Medication();
        String viewName = medicationController.addEmployee(medication);

        verify(medicationService).saveMedicine(medication);
        assertEquals("redirect:/viewMedicine", viewName);
    }
}

