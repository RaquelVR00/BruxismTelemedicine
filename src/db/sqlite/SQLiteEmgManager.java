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
import pojos.Emg;
import pojos.Patient;

/**
 *
 * @author RAQUEL
 */
public class SQLiteEmgManager extends EmgManager {
    private Connection c;

    public SQLiteEmgManager(Connection c) {
            this.c = c;
    }
    
    public List<Emg> searchByName(String name_emg) {
        // TODO Auto-generated method stub
        // return null;
        List<Emg> emgsList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM emg WHERE name_emg LIKE ?";
            PreparedStatement prep = c.prepareStatement(sql);
            prep.setString(1, "%" + name_emg + "%");
            ResultSet rs = prep.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String emgName = rs.getString("name_emg");
                Date emgStart_date = rs.getDate("start_date");
                Date emgFinish_date = rs.getDate("finish_date");
           

                Emg newemg = new Emg(id, emgName, emgStart_date, 
                        emgFinish_date);
                emgsList.add(newemg);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return emgsList;
    }

    
    public List<Emg> searchByStartDate(Date start_date) {
        // TODO Auto-generated method stub
        // return null;
        List<Emg> emgsList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM emg WHERE sart_date LIKE ?";
            PreparedStatement prep = c.prepareStatement(sql);
            prep.setString(1, "%" + start_date+ "%");
            ResultSet rs = prep.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String emgName = rs.getString("name_emg");
                Date emgStart_date = rs.getDate("start_date");
                Date emgFinish_date = rs.getDate("finish_date");
            

                Emg newemg = new Emg(id, emgName, emgStart_date, 
                        emgFinish_date);
                emgsList.add(newemg);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return emgsList;
    }

    public void add(Emg emg) {
        try {
            String sql = "INSERT INTO emg (name_emg, start_date, finish_date "
                    + ") "
                    + "VALUES (?,?,?,?)";
            PreparedStatement prep = c.prepareStatement(sql);
            prep.setString(1, emg.getName_emg());
            prep.setDate(2, emg.getStart_date());
            prep.setDate(3, emg.getFinish_date());
            prep.executeUpdate();
            prep.close();
        } catch (SQLException e) {
        }
    }

    
}