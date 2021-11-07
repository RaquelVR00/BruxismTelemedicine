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

public class SQLitePatientManager implements PatientManager {

    private Connection c;

    public SQLitePatientManager(Connection c) {
        this.c = c;
    }

    @Override
    public List<Patient> searchByName(String name) {
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
            prep.setString(1, patient.getFullName());
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

    @Override
    public void updateUsername(String username, String newUsername) {
        try {
            String sql = "UPDATE patient SET nameuser=? WHERE nameuser=?";
            PreparedStatement s = c.prepareStatement(sql);
            s.setString(2, username);
            s.setString(1, newUsername);
            s.executeUpdate();
            s.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<String> getUsernames() {
        List<String> stringList = new ArrayList<String>();
        try {
            String sql = "SELECT nameuser FROM patient";
            PreparedStatement p = c.prepareStatement(sql);
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                String nameuser = rs.getString("nameuser");
                stringList.add(nameuser);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return stringList;
    }

    public Patient getPatient(int patientId) {
        Patient newPatient = null;
        try {
            String sql = "SELECT * FROM patients" + " WHERE id = ?";
            PreparedStatement p = c.prepareStatement(sql);
            p.setInt(1, patientId);
            ResultSet rs = p.executeQuery();
            boolean patientCreated = false;
            while (rs.next()) {
                if (!patientCreated) {
                    int newPatientId = rs.getInt(1);
                    String patientName = rs.getString(2);
                    String patientAge = rs.getString(3);
                    Float patientWeight = rs.getFloat(4);
                    Float patientHeight = rs.getFloat(5);
                    String patientGender = rs.getString(6);
                    String username = rs.getString(7);
                    newPatient = new Patient(newPatientId, patientName, patientAge, patientWeight, patientHeight, patientGender, username);
                    newPatient.setNameuser(username);
                    patientCreated = true;
                }
                int emgId = rs.getInt(8);
                String emgName = rs.getString(9);
                Float price = rs.getFloat(10);
                String supplier = rs.getString(11);
                int numberComponents = rs.getInt(12);
                Component newComponent = new Component(componentId, componentName, price, supplier, numberComponents);
                componentsList.add(newComponent);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newPatient;
    }
}
