/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 *
 * @author nguyenphuduc
 */
public class StringtoByte {

    public static void main(String[] args) {

        String example = "public static void main(String[] args) {\n"
                + "\n"
                + "        String example = \"This is an example\";\n"
                + "\n"
                + "        // the best , java 1.7+\n"
                + "        byte[] output = example.getBytes(StandardCharsets.UTF_8);\n"
                + "\n"
                + "        System.out.println(\"Text : \" + example);\n"
                + "\n"
                + "        String base64encoded = Base64.getEncoder().encodeToString(output);\n"
                + "\n"
                + "        System.out.println(\"Text [Base64] : \" + base64encoded);\n"
                + "\n"
                + "    }";

        byte[] output = example.getBytes(StandardCharsets.UTF_8);

        String base64encoded = Base64.getEncoder().encodeToString(output);

//        System.out.println("Text [Base64] : " + base64encoded);

        String s = new String(Base64.getDecoder().decode(base64encoded), StandardCharsets.UTF_8);

        // mkyong
        System.out.println(s);

    }
}
