/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.NumberFormatException;

/**
 *
 * @author ricardooriol
 */
public class InputOutput {
    public static int getIntFromKeyboard1to10(String question) {
        int readInt;
        BufferedReader consola = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                System.out.println(question);
                String cadena = consola.readLine();
                readInt = Integer.parseInt(cadena);
                if(readInt<1|readInt>10){
                    throw  new NumberFormatException ("You must enter an integer between 1 and 10.");
                }
                return readInt;
            } catch (IOException ioe) {
                System.out.println("There was a problem while reading, please enter it again.");
            } catch (NumberFormatException nfe) {
                System.out.println("You must enter an integer between 1 and 10.");
            }

        }

    }
}