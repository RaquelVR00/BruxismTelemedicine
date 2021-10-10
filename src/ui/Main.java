package ui;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
//import java.util.Date;
import java.util.List;
import java.util.Scanner;

import db.interfaces.*;

import pojos.*;
import db.sqlite.SQLiteManager;

import java.sql.*;

public class Main {
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // Each time dates are added
																							// this is the format that
																							// is needed.
	private static BufferedReader reader; // To read from the console
	// para añadir nuevos productos a la base de datos una vez que ya se han creado
	private static DBManager dbManager;
	private static PatientManager patientManager;
	private static DoctorManager doctorManager;
	

	public static void main(String[] args) throws Exception {
		// In order to connect with the DB
		dbManager = new SQLiteManager();
		dbManager.connect();
		patientManager = dbManager.getPatientManager();
		doctorManager = dbManager.getDoctorManager();
		
		dbManager.createTables();
		/*
		// To initialize the bufferedReader
		reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Welcome to our data base!");
		// System.out.println("Do you want to create the tables?");
		while (true) {
			System.out.println("What do you want to do?");
			System.out.println("1. Create roles");
			System.out.println("2. Create a new user");
			System.out.println("3. Login");
			System.out.println("0. Exit");
			Integer choice = new Integer(0);
			boolean wrongtext = false;
			do {
				System.out.println("Introduce the number of the option you would like to choose: ");
				try {
					choice = Integer.parseInt(reader.readLine());
					wrongtext = false;
				} catch (NumberFormatException ex) {
					wrongtext = true;
					System.out.println("It's not a int, please enter a int.");
				}
			} while (choice < 0 || choice > 3 || wrongtext);
			switch (choice) {
			case 1:
				newRole();
				break;
			case 2:
				newUser();
				break;
			case 3:
				login();
				break;
			case 0:
				dbManager.disconnect();
				userManager.disconnect();
				return;
			default:
				break;
			}
		}*/
                
	}
}