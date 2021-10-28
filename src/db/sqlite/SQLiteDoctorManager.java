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
public class SQLiteDoctorManager extends DoctorManager {

    private Connection c;

    public SQLiteDoctorManager(Connection c) {
        this.c = c;
    }

}
