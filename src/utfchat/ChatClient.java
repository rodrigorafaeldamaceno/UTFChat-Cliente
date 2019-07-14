/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfchat;

import java.awt.Color;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Random;

/**
 *
 * @author Rodri
 */
public class ChatClient extends UnicastRemoteObject implements ChatClientInt {

    private String name;
    private Color color = gerarCorAleatoriamente();
    private ChatGUI clienteGui;

    public ChatClient(String n) throws RemoteException {
        name = n;
    }

    public void tell(String st) throws RemoteException {
        System.out.println(st);
        clienteGui.writeMsg(st);
    }

    public String getName() throws RemoteException {
        return name;
    }

    public void setGUI(ChatGUI t) {
        clienteGui = t;
    }

    private Color gerarCorAleatoriamente() {
        Random randColor = new Random();
        int r = randColor.nextInt(256);
        int g = randColor.nextInt(256);
        int b = randColor.nextInt(256);
        return new Color(r, g, b);
    }
}
