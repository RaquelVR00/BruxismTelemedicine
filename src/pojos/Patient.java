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
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


public class Patient implements Serializable {

	// <element attribute="value">text or other elements</element>
	/**
	 * 
	 */
    private static final long serialVersionUID = 6891296751142184360L;


    // In some cases, you might prefer to use @XmlAttribute
    private Integer id;
    
    private int anita;

    private String Fullname;

    private Integer age;

    private Float weight;

    private Float height;

    private String gender;

    private Emg emg;

    private Ecg ecg;

    private Doctor doctor;
    // <dog>
    //   <medicines> <-- Wrapper
    //	   <medicine></medicine>
    //	   <medicine></medicine>
    //   </medicines>
    // </dog>

    private List<Ecg> ecg;

    public Patient(Integer id, String Fullname, Integer age, Float weight, Float height, String gender, Emg emg, Ecg ecg, List<Ecg> ecg) {
        super();
        this.id = id;
        this.Fullname = Fullname;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.gender = gender;
        this.emg = emg;
        this.ecg = ecg;
        this.ecg = new ArrayList<Ecg>();
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

    public Emg getEmg() {
        return emg;
    }

    public Ecg getEcg() {
        return ecg;
    }

    public List<Ecg> getEcg() {
        return ecg;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
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

        public void setEmg(Emg emg) {
            this.emg = emg;
        }

        public void setEcg(Ecg ecg) {
            this.ecg = ecg;
        }

/**
	@Override
	public String toString() {
		if (medicines.isEmpty()) {
			return "Dog [id=" + id + ", name=" + name + ", breed=" + breed + ", weight=" + weight + ", admissionDate="
					+ admissionDate + ", releaseDate=" + releaseDate + "]";
		} else {
			return "Dog [id=" + id + ", name=" + name + ", breed=" + breed + ", weight=" + weight + ", admissionDate="
					+ admissionDate + ", releaseDate=" + releaseDate + ", medicines=" + medicines + "]";
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dog other = (Dog) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public List<Medicine> getMedicines() {
		return medicines;
	}

	public void setMedicines(List<Medicine> medicines) {
		this.medicines = medicines;
	}
**/
}

    

