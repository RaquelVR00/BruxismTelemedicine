/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojos.Patient;
import static utils.InputOutput.getIntFromKeyboard1to10;

/**
 *
 * @author ricardooriol
 */
public class test {

    private static BufferedReader reader;

    private static void completeForm(Patient patient) throws Exception {
        System.out.println("Please answer the following questions.");
        System.out.println("For each question, enter a number between 0 (not likely) to 10 (very likely):");
        Integer q1 = getIntFromKeyboard1to10("1. Do you have difficulty or pain when opening your mouth, for example, when yawning?");
        Integer q2 = getIntFromKeyboard1to10("2. Do you feel your jaw “sticking”, “locking” or “popping out”?");
        Integer q3 = getIntFromKeyboard1to10("3. Do you have difficulty or pain when you chew, speak, or use your jaws?");
        Integer q4 = getIntFromKeyboard1to10("4. Have you noticed noises in your jaw joints?");
        Integer q5 = getIntFromKeyboard1to10("5. Do your jaws regularly feel stiff or clenched?");
        Integer q6 = getIntFromKeyboard1to10("6. Do you have pain around your ears, temples, or cheeks?");
        Integer q7 = getIntFromKeyboard1to10("7. Do you have frequent headaches or neck pain?");
        Integer q8 = getIntFromKeyboard1to10("8. Have you had a recent injury or trauma to your head, neck, or jaw?");
        Integer q9 = getIntFromKeyboard1to10("9. Have you noticed or felt any recent change in your bite?");
        Integer q10 = getIntFromKeyboard1to10("10. Have you ever been treated for a jaw joint problem?");
        Integer q11 = getIntFromKeyboard1to10("11. Have you noticed that you grind or clench your teeth frequently during sleep?");
        Integer q12 = getIntFromKeyboard1to10("12. Has anyone heard you grind your teeth at night?");
        Integer q13 = getIntFromKeyboard1to10("13. Did your jaw feel sore or fatigued when you woke up in the morning?");
        Integer q14 = getIntFromKeyboard1to10("14. Do you ever have a momentary headache when you wake up in the morning?");
        Integer q15 = getIntFromKeyboard1to10("15. Have you noticed that you grind/clench your teeth during the day?");
        Integer q16 = getIntFromKeyboard1to10("16. Do you have difficulty opening your mouth wide when you wake up?");
        Integer q17 = getIntFromKeyboard1to10("17. Do you feel pain in your teeth when they come in contact with cold air or liquids?");
        Integer q18 = getIntFromKeyboard1to10("18. Do you feel your jaw joint lock or make a clicking sound when you move it?");
        Integer q19 = getIntFromKeyboard1to10("19. Do your teeth or gums feel sore when you wake up in the morning?");
        Integer q20 = getIntFromKeyboard1to10("20. Have you noticed that you have considerable wear on your teeth?");

        File file = new File("patient_form.txt");
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(file);
            printWriter.print("1. Do you have difficulty or pain when opening your mouth, for example, when yawning? -> " + q1.toString());
            printWriter.print("\n2. Do you feel your jaw “sticking”, “locking” or “popping out”? -> " + q2.toString());
            printWriter.print("\n3. Do you have difficulty or pain when you chew, speak, or use your jaws? -> " + q3.toString());
            printWriter.print("\n4. Have you noticed noises in your jaw joints? -> " + q4.toString());
            printWriter.print("\n5. Do your jaws regularly feel stiff or clenched? -> " + q5.toString());
            printWriter.print("\n6. Do you have pain around your ears, temples, or cheeks? -> " + q6.toString());
            printWriter.print("\n7. Do you have frequent headaches or neck pain? -> " + q7.toString());
            printWriter.print("\n8. Have you had a recent injury or trauma to your head, neck, or jaw? -> " + q8.toString());
            printWriter.print("\n9. Have you noticed or felt any recent change in your bite? -> " + q9.toString());
            printWriter.print("\n10. Have you ever been treated for a jaw joint problem? -> " + q10.toString());
            printWriter.print("\n11. Have you noticed that you grind or clench your teeth frequently during sleep? -> " + q11.toString());
            printWriter.print("\n12. Has anyone heard you grind your teeth at night? -> " + q12.toString());
            printWriter.print("\n13. Did your jaw feel sore or fatigued when you woke up in the morning? -> " + q13.toString());
            printWriter.print("\n14. Do you ever have a momentary headache when you wake up in the morning? -> " + q14.toString());
            printWriter.print("\n15. Have you noticed that you grind/clench your teeth during the day? -> " + q15.toString());
            printWriter.print("\n16. Do you have difficulty opening your mouth wide when you wake up? -> " + q16.toString());
            printWriter.print("\n17. Do you feel pain in your teeth when they come in contact with cold air or liquids? -> " + q17.toString());
            printWriter.print("\n18. Do you feel your jaw joint lock or make a clicking sound when you move it? -> " + q18.toString());
            printWriter.print("\n19. Do your teeth or gums feel sore when you wake up in the morning? -> " + q19.toString());
            printWriter.print("\n20. Have you noticed that you have considerable wear on your teeth? -> " + q20.toString());

            System.out.println("Form saved successfully.");
            byte[] patient_form = Files.readAllBytes(Paths.get("patient_form.txt"));
            patient.setPatientForm(patient_form);

        } catch (IOException ex) {
            System.out.println("There was an error while saving.");

        } finally {
            if (printWriter != null) {
                printWriter.close();
            }

        }

    }

    private static void searchFormByName(Patient patient) throws Exception {
        reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please, enter the following information: ");
        System.out.println("Enter the name of the patient you want to search: ");
        String name = reader.readLine();

        if (patient.getFullName().equalsIgnoreCase(name)) {
            System.out.println("Enter the desired name of the file (fileName.txt):");
            String fileName = reader.readLine();
            Path path = Paths.get(fileName);
            Files.write(path, patient.getPatientForm());
        } else {
            System.out.println("There is no patient with the name " + name);
        }
    }

    public static void main(String[] args) {

        /*try {
            String filePath = "patient_form.txt";
            byte[] bytes = Files.readAllBytes(Paths.get(filePath));
            Path path = Paths.get("patientFormTest.txt");
            Files.write(path, bytes);} catch (IOException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
            }*/
        try {
            Patient patient = new Patient("Carlos");
            completeForm(patient);
            searchFormByName(patient);
        } catch (Exception ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
