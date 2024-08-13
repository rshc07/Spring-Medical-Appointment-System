package com.guvi.hospitalManagement.Service;

import com.guvi.hospitalManagement.Entity.Medication;
import com.guvi.hospitalManagement.Repository.MedicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicationService {

    @Autowired
    private MedicationRepository mediRepo;

    //    1) To Store medicines in Database(mySQL)

    public Medication saveMedicine(Medication medication){

        //save the Employee
        return mediRepo.save(medication);
    }

    //     2) Display all medicine

    public List<Medication> displayAll(){

        return mediRepo.findAll();
    }

    //    3) FindByMedicineId



    public Medication getMedicineById(int Id) {
        Optional<Medication> medicineId = mediRepo.findById(Id);
        if(medicineId.isPresent()){
            return medicineId.get();
        }else{
            throw new RuntimeException("Medicine not found with id: " + Id);
        }

    }

    //     4) Upadate Medicine

    public void updateMedicine(int Id, Medication medication) {
        Optional<Medication> medicineId = mediRepo.findById(Id);
        if (medicineId.isPresent()) {
            Medication medicine = medicineId.get();
            medicine.setMedicineName(medication.getMedicineName());
            medicine.setDosage(medication.getDosage());
            medicine.setQuantity(medication.getQuantity());

            mediRepo.save(medicine);
        }

    }

    //     5) Delete Medicine

    public Medication deleteMedicineById(int Id){

        mediRepo.deleteById(Id);
        return null;
    }

}
