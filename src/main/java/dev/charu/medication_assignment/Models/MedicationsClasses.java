package dev.charu.medication_assignment.Models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.aspectj.apache.bcel.classfile.InnerClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class MedicationsClasses {
    private List<Map<String, List<ClassName>>> medicationClasses = new ArrayList<>();

    public MedicationsClasses(List<Map<String, List<ClassName>>> medicationClasses) {
        this.medicationClasses = medicationClasses;
    }
}
