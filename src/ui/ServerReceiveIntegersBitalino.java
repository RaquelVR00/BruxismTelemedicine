package ui;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerReceiveIntegersBitalino {
    
    public static List <Integer> arrayEMG = new ArrayList <Integer>();
    public static List <Integer> arrayECG = new ArrayList <Integer>();

    public static void main(String args[]) throws IOException {
        int EMG_value, ECG_value;
        
        //Create a service that is waiting in port 9000
        ServerSocket serverSocket = new ServerSocket(9000);
        
        //Thie executes when we have a client
        Socket socket = serverSocket.accept();
        //Read from the client
        InputStream inputStream = socket.getInputStream();
        DataInputStream din; 
        while (true) {
            din = new DataInputStream(inputStream); 
            EMG_value = din.readInt();
            arrayEMG.add(EMG_value);
            if (EMG_value == -10000) {
                break;
            }
        }
        while (true) {
            din = new DataInputStream(inputStream); 
            ECG_value = din.readInt();
            arrayECG.add(ECG_value);
            if (ECG_value == -20000) {
                break;
            }
        }
        
        releaseResources(inputStream, socket, serverSocket);
        
    }

    private static void releaseResources(InputStream inputStream, Socket socket,
            ServerSocket severSocket) {
      
        try {
            inputStream.close();
        } catch (IOException ex) {
            Logger.getLogger(ServerReceiveIntegersBitalino.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        try {
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(ServerReceiveIntegersBitalino.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            severSocket.close();
        } catch (IOException ex) {
            Logger.getLogger(ServerReceiveIntegersBitalino.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}