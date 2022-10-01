/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;

import Entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Scanner;

/**
 *
 * @author bigbo
 */
public class ServerThread implements Runnable {

    private Scanner in = null;
    private PrintWriter out = null;
    private Socket socket;
    private String name;

    public ServerThread(Socket socket, String name) throws IOException {
        this.socket = socket;
        this.name = name;
        this.in = new Scanner(this.socket.getInputStream());
        this.out = new PrintWriter(this.socket.getOutputStream(), true);
        new Thread(this).start();
    }

    public void run() {

        try {
            while (true) {
                String chuoi = in.nextLine().trim();
                // lấy chuỗi string từ chuỗi byte
                String inputString = new String(Base64.getDecoder().decode(chuoi), StandardCharsets.UTF_8);
                String arr[]=inputString.split("\n");
                String func=String.valueOf(arr[0]);
                String string = StringHandling.StringHandling.getString(arr, 1, arr.length);
                if(func.equals("Login")){
                    String arrString[]=string.split("\n");
                    User user=new User(String.valueOf(arrString[0]),String.valueOf(arrString[1]));
                    String result=Data.DBAccess.Login(user);
                    out.println(result);
                }
            }
        } catch (Exception e) {
            System.out.println(name + "has departed");
        } finally {
            try {
                socket.close();
            } catch (Exception e) {
            }
        }
    }
}
