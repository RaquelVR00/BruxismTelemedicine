package pojos;

/**
 *
 * @author RAQUEL
 */




import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Doctor implements Serializable {


    private static final long serialVersionUID = 6891296751142184360L;

    private Integer id;
    private String Fullname;
    private List<Patient> patients;
    
    public Doctor(){
        super();
    }

    
    public Doctor(Integer id, String Fullname) {
        this.id = id;
        this.Fullname = Fullname;
       
    }
    
    public Doctor(String Fullname, List<Patient> patients) {
		super();
		this.Fullname = Fullname;
                this.patients = patients;
		
	}
/*
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
		Pharmacy other = (Pharmacy) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
    */
    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullname() {
        return Fullname;
    }

    public void setFullname(String Fullname) {
        this.Fullname = Fullname;
    }
       
    public static long getSerialversionuid() {
		return serialVersionUID;
	}
    public List<Patient> getPatients() {
		return patients;
	}

    public void setPatients(List<Patient> patients) {
            this.patients = patients;
    }
    /*
    public static void main(String[] args) {
        Doctor doctor = new Doctor(1, "my first doctor", new LinkedList());
        System.out.println("doct: " + doctor);
    }
*/
}

    


