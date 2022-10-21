package PLayFair;

import java.util.ArrayList;

public class PlayfairCipher {

    public PlayfairCipher() {
    }

    public String generateKey(String keyword) {
        keyword = bigLetters(keyword);
        String abc = "ABCDEFGHIKLMNOPQRSTUVWXYZ";
        StringBuilder newKeyword = new StringBuilder();
        char c;
        for (int i = 0; i < keyword.length(); i++) {
            c = keyword.charAt(i);
            if (!newKeyword.toString().contains("" + c)) {
                newKeyword.append(c);
                abc = abc.replace("" + c, "");
            }
        }
        return newKeyword + abc;
    }

    public String encryptMsg(String msg, String key) {
        final char[][] matrix = generateMatrix(key);
        final ArrayList<String> msgList = msgList(msg);
        return encrypt(matrix, msgList);
    }

    public String decryptMsg(String msg, String key) {
        final char[][] matrix = generateMatrix(key);
        final ArrayList<String> msgList = msgList(msg);

        return decrypt(matrix, msgList);
    }

    private char[][] generateMatrix(String key) {
        int c = 0;
        char[][] matrixKey = new char[5][5];
        for (int i = 0; i < matrixKey.length; i++) {
            for (int j = 0; j < matrixKey[0].length; j++) {
                matrixKey[i][j] = key.charAt(c);
                c++;
            }
        }
        return matrixKey;
    }

    private int[] findCharInMatrix(char[][] matrix, char searched) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == searched) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    private String bigLetters(String s) {
        s = s.toUpperCase();
        s = s.replace("J", "I").replace("ß", "SS").replace("Ä", "AE").replace("Ö", "OE").replace("Ü", "UE");
        s = s.replaceAll("[^A-Z]+", "");
        return s;
    }

    private ArrayList<String> msgList(String msg) {
        msg = bigLetters(msg);

        if (msg.length() % 2 == 1) {
            msg += "X";
        }

        ArrayList<String> msgList = new ArrayList<>();

        for (int i = 0; i < msg.length(); i += 2) {
            msgList.add(msg.substring(i, i + 2));
        }
        return msgList;
    }

    private String encrypt(char[][] matrix, ArrayList<String> msgList) {
        StringBuilder outMsg = new StringBuilder();

        for (String s : msgList) {
            int[] charPosA = findCharInMatrix(matrix, s.charAt(0));
            int[] charPosB = findCharInMatrix(matrix, s.charAt(1));

            assert charPosA != null;
            assert charPosB != null;
            if (charPosA[0] == charPosB[0]) {

                outMsg.append(matrix[charPosA[0]][(charPosA[1] + 1) % matrix[0].length]);
                outMsg.append(matrix[charPosB[0]][(charPosB[1] + 1) % matrix[0].length]);
            } else if (charPosA[1] == charPosB[1]) {
                outMsg.append(matrix[(charPosA[0] + 1) % matrix.length][charPosA[1]]);
                outMsg.append(matrix[(charPosB[0] + 1) % matrix.length][charPosB[1]]);
            } else {
                outMsg.append(matrix[charPosA[0]][charPosB[1]]);
                outMsg.append(matrix[charPosB[0]][charPosA[1]]);
            }
        }
        return outMsg.toString();
    }

    private String decrypt(char[][] matrix, ArrayList<String> msgList) {
        StringBuilder outMsg = new StringBuilder();

        for (String s : msgList) {
            int[] charPosA = findCharInMatrix(matrix, s.charAt(0));
            int[] charPosB = findCharInMatrix(matrix, s.charAt(1));

            assert charPosA != null;
            assert charPosB != null;
            if (charPosA[0] == charPosB[0]) {
                outMsg.append(matrix[charPosA[0]][(charPosA[1] + 4) % matrix[0].length]);
                outMsg.append(matrix[charPosB[0]][(charPosB[1] + 4) % matrix[0].length]);
            } else if (charPosA[1] == charPosB[1]) {
                outMsg.append(matrix[(charPosA[0] + 4) % matrix.length][charPosA[1]]);
                outMsg.append(matrix[(charPosB[0] + 4) % matrix.length][charPosB[1]]);
            } else {
                outMsg.append(matrix[charPosA[0]][charPosB[1]]);
                outMsg.append(matrix[charPosB[0]][charPosA[1]]);
            }
        }
        return outMsg.toString();
    }

    public static String encrypt(String string, String key) {
        PlayfairCipher p = new PlayfairCipher();
        key = p.generateKey(key);
        return p.encryptMsg(string, key);
    }

    public static String decrypt(String string, String key) {
        PlayfairCipher p = new PlayfairCipher();
        key = p.generateKey(key);
        return p.decryptMsg(string, key);
    }
    
    public static void main(String[] args) {
        String string="admin";
        String key="hello";
        String p = encrypt(string, key);
//        String s0 = "admin";
//        PlayfairCipher p = new PlayfairCipher();
//        String key = p.generateKey("hello");
//        String pencrypt = p.encryptMsg(s0, key);
        System.out.println("Encrypted: " + p + "\n");
//        String pdecrypt = p.decryptMsg(pencrypt, key);
//        System.out.println("Decrypted: " + pdecrypt + "\n");

    }
}
