/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PLayFair;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author bigbo
 */
public class Server {
    static final int PORT = 4444;
    private ServerSocket server = null;

    public Server() {
        try {
            server = new ServerSocket(PORT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void action() {
        Socket socket = null;
        int i = 0;
        System.out.print("Serverlistening...");
        try {
            while ((socket = server.accept()) != null) {
                new ServerThread(socket, "Client#" + i);
                System.out.printf("Thread for client #%d generating...#n", i++);
            }
        } catch (Exception e) {
            new Server().action();
        }
    }
    public static void main(String[] args) {
        new Server().action();
    }
}
