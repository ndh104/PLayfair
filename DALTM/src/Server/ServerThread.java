/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;

import Client.User.DBAccess;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author nguyenphuduc
 */
public class ServerThread implements Runnable {

    private Scanner in = null;
    private PrintWriter out = null;
    private Socket socket = null;
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

            String chuoi = in.nextLine().trim();

            String outputString = new String(Base64.getDecoder().decode(chuoi), StandardCharsets.UTF_8);

            String[] arrString = outputString.split("\n");

            String idUser = String.valueOf(arrString[0].toCharArray());
            char[] func = arrString[1].toCharArray();
            char[] key = arrString[2].toCharArray();

            String string = "";

            for (int i = 3; i < arrString.length; i++) {
                if (i != 3) {
                    string += "\n" + arrString[i].toString();
                } else {
                    string += arrString[i].toString();
                }

            }

            String funcString = String.valueOf(func);

            AES aes = new AES();
            AlphabetFrequencyString afs = new AlphabetFrequencyString();

            if (funcString.equals("encrypt")) {
                String enString = aes.encrypt(String.valueOf(string), String.valueOf(key));

                DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

                Date dateobj = new Date();

                DBAccess acc = new DBAccess();
                String query = "insert into tb_Encrypt values('" + idUser + "','" + df.format(dateobj) + "','" + enString + "','" + String.valueOf(key) + "')";
                acc.Update(query);

                out.println(enString);
            } else if (funcString.equals("decrypt")) {
                String deString = null;

                deString = aes.decrypt(String.valueOf(string), String.valueOf(key));
                String inputBase64 = null;

                if (deString != null) {

                    String demString = afs.frequencycount(deString);

                    deString += "\n" + demString;

                    byte[] deByte = deString.getBytes(StandardCharsets.UTF_8);
                    inputBase64 = Base64.getEncoder().encodeToString(deByte);
                } else {
                    byte[] deByte = "null".getBytes(StandardCharsets.UTF_8);
                    inputBase64 = Base64.getEncoder().encodeToString(deByte);
                }
                out.println(inputBase64);
            }

        } catch (Exception e) {
            System.err.println(name + "has departed");
        } finally {
            try {
                socket.close();
            } catch (Exception e) {
            }
        }
    }
}
