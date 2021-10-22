/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

/**
 *
 * @author RAQUEL
 */




import java.io.Serializable;
import java.util.List;
//import java.sql.Date;
//import java.util.ArrayList;


public class Patient implements Serializable {

	// <element attribute="value">text or other elements</element>
	/**
	 * 
	 */
    private static final long serialVersionUID = 6891296751142184360L;


    // In some cases, you might prefer to use @XmlAttribute
    private Integer id;

    private String Fullname;

    private Integer age;

    private Float weight;

    private Float height;

    private String gender;

    //private Emg emg;

    //private Ecg ecg;

    private List<Doctor> doctors;
    // <dog>
    //   <medicines> <-- Wrapper
    //	   <medicine></medicine>
    //	   <medicine></medicine>
    //   </medicines>
    // </dog>

    //private List<Ecg> ecg;

    public Patient(Integer id, String Fullname, Integer age, Float weight, Float height, String gender) {
        this.id = id;
        this.Fullname = Fullname;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.gender = gender;
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
    
    

}

    

