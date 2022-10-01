/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StringHandling;

/**
 *
 * @author bigbo
 */
public class StringHandling {
    // lấy ra đoạn string từ array
    public static String getString(String[] arrStrings, int begin, int end) {
        String string = "";
        for (int i = begin; i < end; i++) {
            if (i != begin) {
                string += "\n" + arrStrings[i];
            } else {
                string += arrStrings[i];
            }
        }
        return string;
    }
}
