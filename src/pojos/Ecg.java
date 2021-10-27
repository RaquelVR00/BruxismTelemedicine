/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author RAQUEL
 */
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

    @Override
    public String toString() {
        return "Ecg{" + "id=" + id + ", name_ecg=" + name_ecg + ", start_date=" + start_date + ", finish_date=" + finish_date + '}';
    }

    
}
