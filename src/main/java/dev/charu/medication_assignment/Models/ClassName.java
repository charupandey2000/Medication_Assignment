package dev.charu.medication_assignment.Models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Setter
@Getter
@NoArgsConstructor
public class ClassName {

    private Map<String, List<Drug>> associatedDrugs=new HashMap<>();

    public ClassName(Map<String, List<Drug>> associatedDrugs) {
        this.associatedDrugs = associatedDrugs;
    }
}
