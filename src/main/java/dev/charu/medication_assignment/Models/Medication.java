package dev.charu.medication_assignment.Models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Setter
@Getter
@NoArgsConstructor
public class Medication {
    private List<MedicationsClasses>medicationsClasses=new ArrayList<>();

    public Medication(List<MedicationsClasses> medicationsClasses) {
        this.medicationsClasses = medicationsClasses;
    }
}
