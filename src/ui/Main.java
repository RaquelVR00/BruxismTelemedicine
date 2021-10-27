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
    //PRUEBA PUSH PARA VER SI SE PUEDE HACER PULL -  RICARDO ORIOL
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // Each time dates are added
																							// this is the format that
																							// is needed.
	private static BufferedReader reader; // To read from the console
	// para añadir nuevos productos a la base de datos una vez que ya se han creado
	private static DBManager dbManager;
	private static PatientManager patientManager;
	private static DoctorManager doctorManager;
	private static EmgManager emgManager;
        private static EcgManager ecgManager;
        //private static UserManager userManager;
	
	//public static String numbers = "0123456789";
	//public static String caps = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	//public static String low_case = "abcdefghijklmnopqrstuvwxyz";
        

	public static void main(String[] args) throws Exception {
		// In order to connect with the DB
		dbManager = new SQLiteManager();
		dbManager.connect();
		patientManager = dbManager.getPatientManager();
		doctorManager = dbManager.getDoctorManager();
		emgManager = dbManager.getEmgManager();
                ecgManager = dbManager.getEcgManager();
		dbManager.createTables();
                //userManager = new JPAUserManager();
		//userManager.connect();
		
                //To initialize the bufferedReader
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
				//newRole();
				break;
			case 2:
				//newUser();
				break;
			case 3:
				//login();
				break;
			case 0:
				dbManager.disconnect();
				//userManager.disconnect();
				return;
			default:
				break;
			}
		}
                
	}
        /*
        private static void newRole() throws Exception {
		String roleName="patient";
		Role role = new Role(roleName);
		userManager.createRole(role);
		roleName = "boss";
		role = new Role(roleName);
		userManager.createRole(role);
		System.out.println("Roles Created!!");
	}
        */

	private static void newUser() throws Exception {
		List<Role> roles = userManager.getRoles();
		if(roles.isEmpty()) {
			System.out.println("There are not roles, please create the roles");
			return;
		}
		System.out.println("Please type the new user information:");
		System.out.print("Username:");
		String username = reader.readLine();
		System.out.print("Password:");
		String password = reader.readLine();
	
		// Create the password's hash
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(password.getBytes());
		byte[] hash = md.digest();
		// Show all the roles and let the user choose one
		Integer roleId = new Integer (0);
		boolean wrongtext = true;
		String exit = "1";
		do {
			if(exit.equals("yes") || exit.equals("Yes") ){
				break;
			}
			for (Role role : roles) {
				
				System.out.println(role);
				
			}
			System.out.print("Type the chosen role id:");
			try {
				roleId = Integer.parseInt(reader.readLine());
				wrongtext = false;
			} catch (NumberFormatException ex) {
				wrongtext = true;
				System.out.println("It's not a int, please enter a int.");
			}
			if(roleId != 1 && roleId != 3) {
				System.out.println("Not valid id, if you want to exit this option say yes:");
				exit=reader.readLine();
			}
		} while (roleId != 1 && roleId != 2);
		if(exit.contentEquals("yes") || exit.contentEquals("Yes")) {
			return;
		}
		Role chosenRole = userManager.getRole(roleId);
		// Create the user and store it
		User user = new User(username, hash, chosenRole);
		
	        userManager.createUser(user);
		
		
		

	}

	private static void login() throws Exception {
		System.out.println("Please input your credentials");
		System.out.print("Username:");
		String username = reader.readLine();
		System.out.print("Password:");
		String password = reader.readLine();
		User user = userManager.checkPassword(username, password);
		// We check if the user/password combination was OK
		if (user == null) {
			System.out.println("Wrong credentials, please try again!");
		}
		// We check the role
		else if (user.getRole().getRole().equalsIgnoreCase("doctor")) {
			System.out.println("Welcome doctor " + username + "!");
			doctorName = username;
			doctorMenu();
		} else if (user.getRole().getRole().equalsIgnoreCase("patient")) {
			System.out.println("Welcome patient" + username + "!");
			patientName = username;
			patientMenu();
		} else {
			System.out.println("Invalid role.");
		}
	}
        
        
	private static void patientMenu() throws Exception {
		while (true) {
			System.out.println("What would you like to do?");
			System.out.println("1. Complete form");
			System.out.println("2. Add EMG");
			System.out.println("3. Add ECG");
			System.out.println("4. Search EMG by start date");
			System.out.println("5. Search ECG by start date");
			System.out.println("6. Change your user name");
			System.out.println("7. Change your password");
			System.out.println("8. Go back");
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
			} while (choice < 0 || choice > 8 || wrongtext);
			switch (choice) {
			case 1:
				completeForm();
				break;
			case 2:
				addEMG();
				break;
			case 3:
				addECG();
				break;
			case 4:
				searchEMGByStartDate();
				break;
			case 5:
				searchECGByStartDate();
				break;
			case 6:
				String userName = userManager.updateUserName(patientName);
				patientManager.updateUserName(patientName,userName);
				return;
			case 7:
				userManager.updatePassword(patientName);
				return;
			case 8:
				return;
			}
		}
	}

	private static void searchEMGByStartDate() throws Exception {
		System.out.println("Please, enter the following information: ");
		
                
                Date start_date = null;
                String date = reader.readLine();
		boolean wrongtext = false;
		do {
			System.out.println("Enter the date of the EMG: ");
			do {
				try {
					start_date = (Date) formatter.parse(date);
					wrongtext = false;
				} catch (NumberFormatException ex) {
					wrongtext = true;
					System.out.println("It's not a date, please enter a date.");
				}
			} while (wrongtext);
		} while (patientManager.searchByStartDate(start_date) == null);
		
		List<Emg> emgList = patientManager.searchByStartDate(start_date);
		for (Emg emg : emgList) {
			System.out.println(emg);
		}
	}
        
        private static void searchECGByStartDate() throws Exception {
		System.out.println("Please, enter the following information: ");
		
                
                Date start_date = null;
                String date = reader.readLine();
		boolean wrongtext = false;
		do {
			System.out.println("Enter the date of the ECG: ");
			do {
				try {
					start_date = (Date) formatter.parse(date);
					wrongtext = false;
				} catch (NumberFormatException ex) {
					wrongtext = true;
					System.out.println("It's not a date, please enter a date.");
				}
			} while (wrongtext);
		} while (patientManager.searchByStartDate(start_date) == null);
		
		List<Ecg> ecgList = patientManager.searchByStartDate(start_date);
		for (Ecg ecg : emgList) {
			System.out.println(ecg);
		}
	}
        
        private static void addEMG() throws Exception {
		System.out.println("Please, enter the following information: ");
		System.out.println("Name: ");
		String name = reader.readLine();
		
		System.out.println("Start_date: ");
                Date start_date = null;
                String date = reader.readLine();
		boolean wrongtext = false;
                do {
                        System.out.println("Enter the start date of the EMG: ");
                    try {
                        start_date = (Date) formatter.parse(date);
                        wrongtext = false;
                    } catch (NumberFormatException ex) {
                        wrongtext = true;
                        System.out.println("It's not a date, please enter a date.");
                }
                } while (wrongtext);
		
		
		Emg emg = new Emg(name, start_date);
		EmgManager.add(emg);
                }

}