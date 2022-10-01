/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;

import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author nguyenphuduc
 */
public class TCP_Server {
    static final int PORT = 8888;
    private ServerSocket server = null;
    
    public TCP_Server(){
        try {
            server = new ServerSocket(PORT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void action(){
        Socket socket = null;
        int i=0;
        System.out.println("Server đang lắng nghe...");
        try {
            while ((socket = server.accept()) != null) {                
                new ServerThread(socket, "Client"+i);
                System.out.printf("Thread for Client # %d generating...%n", i++);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        new TCP_Server().action();
    }
    
}
