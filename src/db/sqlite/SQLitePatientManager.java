/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.sqlite;

import db.interfaces.*;
import java.sql.Connection;

/**
 *
 * @author RAQUEL
 */
public class SQLitePatientManager extends PatientManager {
    private Connection c;

    public SQLitePatientManager(Connection c) {
            this.c = c;
    }

   

    
}
