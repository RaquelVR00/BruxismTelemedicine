/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

/**
 *
 *
 */
import java.io.Serializable;
import java.util.List;
import java.sql.Date;
import java.util.ArrayList;

public class Patient implements Serializable {

    private static final long serialVersionUID = 6891296751142184360L;

    private Integer id;

    private String Fullname;

    private Integer age;

    private Float weight;

    private Float height;

    private String gender;

    private List<Doctor> doctors;

    private List<Ecg> ecg;

    private List<Emg> emg;

    public Patient(Integer id, String Fullname, Integer age, Float weight, Float height, String gender, List<Ecg> ecg, List<Emg> emg) {
        this.id = id;
        this.Fullname = Fullname;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.gender = gender;
        this.ecg = ecg;
        this.emg = emg;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public String getFullname() {
        return Fullname;
    }

    public Integer getAge() {
        return age;
    }

    public Float getWeight() {
        return weight;
    }

    public Float getHeight() {
        return height;
    }

    public String getGender() {
        return gender;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public List<Ecg> getEcg() {
        return ecg;
    }

    public List<Emg> getEmg() {
        return emg;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFullname(String Fullname) {
        this.Fullname = Fullname;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public void setEcg(List<Ecg> ecg) {
        this.ecg = ecg;
    }

    public void setEmg(List<Emg> emg) {
        this.emg = emg;
    }

}
