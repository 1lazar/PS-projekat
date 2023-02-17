/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import controller.Controller;
import domain.Administrator;
import domain.Pacijent;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import thread.ProcessClientRequest;

/**
 *
 * @author Laza Laki Lakosta
 */
public class Server  extends Thread  {
    private  ServerSocket serverSocket;
    List<ProcessClientRequest> activeClients;
    private boolean kraj = false;
    
    public Server() throws IOException {
        serverSocket = new ServerSocket(1803);
        activeClients = new ArrayList<>();
    }
    
    @Override
    public void run() {
        while (!kraj) {
            try {
                System.out.println("Waiting for connection...");
                Socket socket = serverSocket.accept();
                System.out.println("Connected!");
                handleClient(socket);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        //CloseActiveUsers();
    }

    private void handleClient(Socket socket) {
        ProcessClientRequest processClientRequests = new ProcessClientRequest(socket);
        processClientRequests.start();
        activeClients.add(processClientRequests);
    }
    
    public ServerSocket getServerSocket() {
        return serverSocket;
    }
    
    public List<Administrator> getActiveUsers() {
        List<Administrator> admin = new ArrayList<>();
        for (ProcessClientRequest c : activeClients) {
            System.out.println(c.getAdministratori());
            admin.add(c.getAdministratori());
        }

        return admin;
    }

    public void closeActiveUsers() {
        //TODO..
        for (ProcessClientRequest k : activeClients) {
            try {
                k.getSocket().close();
                activeClients.remove(k);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public void kraj() {
        try {
            for (ProcessClientRequest processClientRequests : activeClients) {
                processClientRequests.kraj();
            }
            Controller.getInstance().setPrijavljeniKorisnici(new ArrayList<>());
            serverSocket.close();
            kraj = true;
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
