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
import java.sql.Date;
import java.util.List;
import pojos.Ecg;
import pojos.Patient;

/**
 *
 * @author RAQUEL
 */
public class SQLiteEcgManager implements EcgManager {
    private Connection c;

    public SQLiteEcgManager(Connection c) {
            this.c = c;
    }
    
    public List<Ecg> searchByName(String name_ecg) {
        // TODO Auto-generated method stub
        // return null;
        List<Ecg> ecgsList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM ecg WHERE name_ecg LIKE ?";
            PreparedStatement prep = c.prepareStatement(sql);
            prep.setString(1, "%" + name_ecg + "%");
            ResultSet rs = prep.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String ecgName = rs.getString("name_ecg");
                Date ecgStart_date = rs.getDate("start_date");
                Date ecgFinish_date = rs.getDate("finish_date");
           

                Ecg newecg = new Ecg(id, ecgName, ecgStart_date, 
                        ecgFinish_date);
                ecgsList.add(newecg);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ecgsList;
    }

    
    public List<Ecg> searchByStartDate(Date start_date) {
        // TODO Auto-generated method stub
        // return null;
        List<Ecg> ecgsList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM ecg WHERE sart_date LIKE ?";
            PreparedStatement prep = c.prepareStatement(sql);
            prep.setString(1, "%" + start_date+ "%");
            ResultSet rs = prep.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String ecgName = rs.getString("name_ecg");
                Date ecgStart_date = rs.getDate("start_date");
                Date ecgFinish_date = rs.getDate("finish_date");
            

                Ecg newecg = new Ecg(id, ecgName, ecgStart_date, 
                        ecgFinish_date);
                ecgsList.add(newecg);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ecgsList;
    }

    public void add(Ecg ecg) {
        try {
            String sql = "INSERT INTO ecg (name_ecg, start_date, finish_date "
                    + ") "
                    + "VALUES (?,?,?,?)";
            PreparedStatement prep = c.prepareStatement(sql);
            prep.setString(1, ecg.getName_ecg());
            prep.setDate(2, ecg.getStart_date());
            prep.setDate(3, ecg.getFinish_date());
            prep.executeUpdate();
            prep.close();
        } catch (SQLException e) {
        }
    }
    
    public void delete(Integer ecg_id) {
        try {
            String sql = "DELETE FROM ecg WHERE id=?";
            PreparedStatement prep = c.prepareStatement(sql);
            prep.setInt(1, ecg_id);
            prep.executeUpdate();
            prep.close();
        } catch (SQLException e) {
        }
    }

    
}