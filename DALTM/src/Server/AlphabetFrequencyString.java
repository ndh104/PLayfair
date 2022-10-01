/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;

/**
 *
 * @author nguyenphuduc
 */
public class AlphabetFrequencyString {

    static int i, j, k, c = 0, w;

    public String frequencycount(String s) {

        String result = "";

        char[] z = new char[s.length()];
        for (w = 0; w < s.length(); w++) {
            z[w] = s.charAt(w);
        }
        for (i = 0; i < w; i++) {
            char ch = z[i];
            for (j = i + 1; j < w; j++) {
                if (z[j] == ch) {
                    for (k = j; k < (w - 1); k++) {
                        z[k] = z[k + 1];
                    }
                    w--;
                    j = i;
                }
            }
        }

        int[] t = new int[w];
        for (i = 0; i < w; i++) {
            for (j = 0, c = 0; j < s.length(); j++) {
                if (z[i] == s.charAt(j)) {
                    c++;
                }
            }
            t[i] = c;
            if (i==0) {
                if (String.valueOf(z[i]).equals(" "))
                    result += "Số lần xuất hiện của [khoảng trắng] trong chuỗi: " + c;
                else if (String.valueOf(z[i]).equals("\n"))
                    result += "Số lần xuất hiện [xuống dòng] trong chuỗi: " + c;
                else
                    result += "Số lần xuất hiện của " + z[i] + " trong chuỗi: " + c;
            }
            else
                if (String.valueOf(z[i]).equals(" "))
                    result += "@@Số lần xuất hiện của [khoảng trắng] trong chuỗi: " + c;
                else if (String.valueOf(z[i]).equals("\n"))
                    result += "@@Số lần xuất hiện [xuống dòng] trong chuỗi: " + c;
                else
                    result += "@@Số lần xuất hiện của " + z[i] + " trong chuỗi: " + c;
        }
        return result;
    }

    public static void main(String[] args) {

        AlphabetFrequencyString afs = new AlphabetFrequencyString();

        String string = afs.frequencycount("int[] t = new int[w];\n"
                + "        for (i = 0; i < w; i++) {\n"
                + "            for (j = 0, c = 0; j < s.length(); j++) {\n"
                + "                if (z[i] == s.charAt(j)) {\n"
                + "                    c++;\n"
                + "                }\n"
                + "            }\n"
                + "            t[i] = c;\n");
        
        System.out.println(string);
    }

}
