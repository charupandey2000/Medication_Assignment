package dev.charu.medication_assignment.Models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Drug {
    private String name;

    private String dose;

    private String strength;
    public Drug(String name, String dose, String strength) {
        this.name = name;
        this.dose = dose;
        this.strength = strength;
    }

}
