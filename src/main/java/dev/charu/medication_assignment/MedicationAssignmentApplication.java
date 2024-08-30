package dev.charu.medication_assignment;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.mysql.cj.protocol.Resultset;
import dev.charu.medication_assignment.Models.*;
import dev.charu.medication_assignment.Repository.MedicationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.*;

@SpringBootApplication
public class MedicationAssignmentApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MedicationAssignmentApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		MedicationRepository medicationRepository=new MedicationRepository();
		ResultSet resultSet=medicationRepository.get_Data();

		Map<String, Map<String, List<Map<String, String>>>> medicationClassesMap = new LinkedHashMap<>();

		while (resultSet.next()) {
			String classKey = resultSet.getString("class_key");
			String drugKey = resultSet.getString("drug_key");
			String name = resultSet.getString("drug_name");
			String dose = resultSet.getString("drug_dose");
			String strength = resultSet.getString("drug_strength");


			Map<String, String> drugDetails = new LinkedHashMap<>();
			drugDetails.put("name", name);
			drugDetails.put("dose", dose);
			drugDetails.put("strength", strength);


			medicationClassesMap
					.computeIfAbsent(classKey, k -> new LinkedHashMap<>())
					.computeIfAbsent(drugKey, k -> new ArrayList<>())
					.add(drugDetails);
		}


		ObjectMapper mapper = new ObjectMapper();
		ObjectNode rootNode = mapper.createObjectNode();
		rootNode.set("medications", mapper.valueToTree(Collections.singletonList(Collections.singletonMap("medicationsClasses", medicationClassesMap))));


		String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(rootNode);
		System.out.println(jsonString);


	}
}
