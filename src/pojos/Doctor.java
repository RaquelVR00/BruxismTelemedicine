package pojos;

/**
 *
 * @author RAQUEL
 */




import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


public class Doctor implements Serializable {

	// <element attribute="value">text or other elements</element>
	/**
	 * 
	 */
	private static final long serialVersionUID = 6891296751142184360L;

	
	// In some cases, you might prefer to use @XmlAttribute
	private Integer id;
	
	private String Fullname;
	
	
        
	// <dog>
	//   <medicines> <-- Wrapper
	//	   <medicine></medicine>
	//	   <medicine></medicine>
	//   </medicines>
	// </dog>
	
	private List<Patient> patient;

    public Doctor(Integer id, String Fullname, List<Patient> patient) {
        this.id = id;
        this.Fullname = Fullname;
        this.patient = patient;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullname() {
        return Fullname;
    }

    public void setFullname(String Fullname) {
        this.Fullname = Fullname;
    }

    public List<Patient> getPatient() {
        return patient;
    }

    public void setPatient(List<Patient> patient) {
        this.patient = patient;
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

    


