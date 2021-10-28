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
public class Emg implements Serializable {

    private Integer id;
    private String name_emg;
    private Date start_date;
    private Date finish_date;

    public Emg(Integer id, String name_emg) {
        this.id = id;
        this.name_emg = name_emg;
    }

    public Emg(String name_emg, Date start_date, Date finish_date) {
        this.name_emg = name_emg;
        this.start_date = start_date;
        this.finish_date = finish_date;
    }

    public Emg(Integer id, String name_emg, Date start_date, Date finish_date) {
        this.id = id;
        this.name_emg = name_emg;
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

    public String getName_emg() {
        return name_emg;
    }

    public void setName_emg(String name_emg) {
        this.name_emg = name_emg;
    }

    @Override
    public String toString() {
        return "Emg{" + "id=" + id + ", name_emg=" + name_emg + ", start_date=" + start_date + ", finish_date=" + finish_date + '}';
    }

}
