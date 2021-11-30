package BITalino;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Vector;

import javax.bluetooth.RemoteDevice;


import java.util.logging.Level;
import java.util.logging.Logger;

public class BitalinoDemo {

    public static Frame[] frame;

    public static void main(String[] args) {

        BITalino bitalino = null;
        try {
            bitalino = new BITalino();
            // find devices
            //Only works on some OS
            Vector<RemoteDevice> devices = bitalino.findDevices();
            System.out.println(devices);

            //You need TO CHANGE THE MAC ADDRESS
            String macAddress = "98:D3:51:FD:9C:72";
            int SamplingRate = 10;
            bitalino.open(macAddress, SamplingRate);

            // start acquisition on analog channels A2 and A6
            //If you want A1, A3 and A4 you should use {0,2,3}
            int[] channelsToAcquire = {0, 1}; //A1 --> EMG, A2-->ECG  
            bitalino.start(channelsToAcquire);
            

            String data=null;
            ArrayList <Objeto> arrayEMG = new ArrayList <Objeto>();
            ArrayList <Objeto> arrayEMG_rec;
            
            ArrayList <Objeto> arrayECG = new ArrayList <Objeto>();
            ArrayList <Objeto> arrayECG_rec;
            
            
            //read 10000 samples
            for (int j = 0; j < 10; j++) {

                //Read a block of 100 samples 
                frame = bitalino.read(10);

                System.out.println("size block: " + frame.length);

                //Print the samples

                for (int i = 0; i < frame.length; i++) {
                    /*System.out.println((j * 100 + i) + " seq: " + frame[i].seq + " "
                            + frame[i].analog[0] + " "
                            + frame[i].analog[1] + " "
                    //  + frame[i].analog[2] + " "
                    //  + frame[i].analog[3] + " "
                    //  + frame[i].analog[4] + " "
                    //  + frame[i].analog[5]
                    );*/

                    Objeto newEMG = new Objeto("seq: "+frame[i].seq+", EMG: "+frame[i].analog[0]);
                    arrayECG.add(newEMG);

                    Objeto newECG = new Objeto("seq: "+frame[i].seq+", ECG: "+frame[i].analog[1]);
                    arrayECG.add(newECG);




                }
            }
                       
            
            //stop acquisition
            bitalino.stop();
            
            
             try {
                 
                System.out.println("Guardando EMGs en el fichero emg.txt ");
                ObjectOutputStream File_EMG = new ObjectOutputStream(new FileOutputStream("emg.txt") );
                File_EMG.writeObject(arrayEMG);
                File_EMG.close();
                
                System.out.println("Leyendo EMGs del fichero emg.txt. ");
                ObjectInputStream File_EMG_rec = new ObjectInputStream(new FileInputStream("emg.txt") );
                arrayEMG_rec = ( ArrayList <Objeto> )File_EMG_rec.readObject();
                File_EMG_rec.close();
                
                System.out.println("Datos leídos del fichero EMG:");
                for(int i = 0; i < arrayEMG_rec.size(); i++) {
                    System.out.println( arrayEMG_rec.get(i) );
                }
                
                
                
                System.out.println("Guardando ECGs en el fichero ecg.txt ");
                ObjectOutputStream File_ECG = new ObjectOutputStream(new FileOutputStream("ecg.txt") );
                File_ECG.writeObject(arrayECG);
                File_ECG.close();
                
                System.out.println("Leyendo ECGs del fichero ecg.txt. ");
                ObjectInputStream File_ECG_rec = new ObjectInputStream(new FileInputStream("ecg.txt") );
                arrayECG_rec = ( ArrayList <Objeto> )File_ECG_rec.readObject();
                File_ECG_rec.close();
                
                System.out.println("Datos leídos del fichero ECG:");
                for(int i = 0; i < arrayECG_rec.size(); i++) {
                    System.out.println( arrayECG_rec.get(i) );
                }
                
                
            } catch (Exception e) {
                System.out.println( e.getMessage() );
            }
            
            
        } catch (BITalinoException ex) {
            Logger.getLogger(BitalinoDemo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Throwable ex) {
            Logger.getLogger(BitalinoDemo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                //close bluetooth connection
                if (bitalino != null) {
                    bitalino.close();
                }
            } catch (BITalinoException ex) {
                Logger.getLogger(BitalinoDemo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        

    }

}
