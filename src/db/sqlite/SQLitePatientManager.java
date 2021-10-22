/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.sqlite;

import db.interfaces.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pojos.Patient;

/**
 *
 * @author RAQUEL
 */
public class SQLitePatientManager implements PatientManager {
    private Connection c;

    public SQLitePatientManager(Connection c) {
        this.c = c;
    }

    @Override
    public List<Patient> searchByName(String name) {
        // TODO Auto-generated method stub
        // return null;
        List<Patient> patientsList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM patients WHERE Fullname LIKE ?";
            PreparedStatement prep = c.prepareStatement(sql);
            prep.setString(1, "%" + name + "%");
            ResultSet rs = prep.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String patientName = rs.getString("Fullname");
                Integer patientAge = rs.getInt("age");
                Float patientWeight = rs.getFloat("weight");
                Float patientHeight = rs.getFloat("height");
                String gender = rs.getString("gender");

                Patient newpatient = new Patient(id, patientName, patientAge, 
                        patientWeight, patientHeight, gender);
                patientsList.add(newpatient);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patientsList;
    }

    @Override
    public void add(Patient patient) {
        try {
            String sql = "INSERT INTO patients (Fullname, age, weight, height, "
                    + "gender) "
                    + "VALUES (?,?,?,?,?,?)";
            PreparedStatement prep = c.prepareStatement(sql);
            prep.setString(1, patient.getFullname());
            prep.setInt(2, patient.getAge());
            prep.setFloat(3, patient.getWeight());
            prep.setFloat(4, patient.getHeight());
            prep.setString(5, patient.getGender());
            prep.executeUpdate();
            prep.close();
        } catch (SQLException e) {
        }
    }
    
    @Override
    public void delete(Integer patient_id) {
        try {
            String sql = "DELETE FROM patients WHERE id=?";
            PreparedStatement prep = c.prepareStatement(sql);
            prep.setInt(1, patient_id);
            prep.executeUpdate();
            prep.close();
        } catch (SQLException e) {
        }
    }

}

