package dev.charu.medication_assignment.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.charu.medication_assignment.Models.Medication;
import org.aspectj.apache.bcel.classfile.InnerClass;

import java.io.IOException;
import java.sql.*;
import java.util.*;

public class MedicationRepository {

    public ResultSet get_Data() throws ClassNotFoundException, SQLException {
     Class.forName("com.mysql.cj.jdbc.Driver");
     Connection connection=DriverManager.getConnection(
             "jdbc:mysql://localhost:3306/Medication","root","Asha@1975");

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT \n" +
                "    m.id AS medication_id,\n" +
                "    mc.id AS medications_classes_id,\n" +
                "    cn.id AS class_name_id,\n" +
                "    d.name AS drug_name,\n" +
                "    d.dose AS drug_dose,\n" +
                "    d.strength AS drug_strength,\n" +
                "    ad.key_name AS drug_key,\n" +
                "    mcm.key_name AS class_key\n" +
                "FROM \n" +
                "    medications m\n" +
                "JOIN \n" +
                "    medications_map mm ON m.id = mm.medication_id\n" +
                "JOIN \n" +
                "    medications_classes mc ON mm.medications_classes_id = mc.id\n" +
                "JOIN \n" +
                "    medications_classes_map mcm ON mc.id = mcm.medications_classes_id\n" +
                "JOIN \n" +
                "    class_names cn ON mcm.class_name_id = cn.id\n" +
                "JOIN \n" +
                "    associated_drugs ad ON cn.id = ad.class_name_id\n" +
                "JOIN \n" +
                "    drugs d ON ad.drug_id = d.id\n" +
                "WHERE \n" +
                "    m.id = 1;");
        return resultSet;

 }





    }








