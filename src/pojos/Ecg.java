/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

import java.io.Serializable;
import java.sql.Date;

public class Ecg implements Serializable {

    private Integer id;
    private String name_ecg;
    private Date start_date;
    private Date finish_date;

    public Ecg(Integer id, String name_ecg) {
        this.id = id;
        this.name_ecg = name_ecg;
    }

    public Ecg(String name_ecg, Date start_date, Date finish_date) {
        this.name_ecg = name_ecg;
        this.start_date = start_date;
        this.finish_date = finish_date;
    }

    public Ecg(Integer id, String name_ecg, Date start_date, Date finish_date) {
        this.id = id;
        this.name_ecg = name_ecg;
        this.start_date = start_date;
        this.finish_date = finish_date;
    }

    public Ecg(String name, Date start_date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getFinish_date() {
        return finish_date;
    }

    public void setFinish_date(Date finish_date) {
        this.finish_date = finish_date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName_ecg() {
        return name_ecg;
    }

    public void setName_ecg(String name_ecg) {
        this.name_ecg = name_ecg;
    }

    /*
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.id);
        hash = 67 * hash + Objects.hashCode(this.name_ecg);
        hash = 67 * hash + Objects.hashCode(this.start_date);
        hash = 67 * hash + Objects.hashCode(this.finish_date);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ecg other = (Ecg) obj;
        if (!Objects.equals(this.name_ecg, other.name_ecg)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.start_date, other.start_date)) {
            return false;
        }
        if (!Objects.equals(this.finish_date, other.finish_date)) {
            return false;
        }
        return true;
    }*/
    @Override
    public String toString() {
        return "Ecg{" + "id=" + id + ", name_ecg=" + name_ecg + ", start_date=" + start_date + ", finish_date=" + finish_date + '}';
    }

}
