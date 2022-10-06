import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import static java.lang.Integer.parseInt;
import static java.lang.Integer.toHexString;

class Filereading {

    public static void main(String[] args) throws IOException {
        String message = "";
        int m;
        int k = '(';
        String krypt = "";
        String dekrypt = "";

        int svar = JOptionPane.showConfirmDialog(null, "Vill använda standard nyckeln?");
        if (svar == 1) {
            String customnyckel = JOptionPane.showInputDialog("Skriv en egen nyckel (ett tecken)");
            k = customnyckel.charAt(0);
        }
        if (svar != 1 && svar != 0 ) {
            System.exit(1);
        }

        int answer = JOptionPane.showConfirmDialog(null, "Vill du importera text från info.txt?");

        if (answer == 0) {
            message = fileread(message);
        }
        if (answer == 1) {
            message = JOptionPane.showInputDialog("Skriv din text:");
        }

        if (answer != 1 && answer != 0) {
            System.exit(1);
        }

        krypt += encrypt(k,message);
        dekrypt = decrypt(dekrypt,krypt);
        System.out.println("Nyckel: " + k);
        System.out.println("Hexadecimal: " + krypt);
        System.out.println("Krypterad text: " + dekrypt);
    }



    private static String encrypt(int k, String message) {
        int m;
        String d = "";
        for (int i = 0; i < message.length(); i++) {
            m = message.charAt(i);
            int c = m ^ k;
            d += toHexString(c);
        }
        return d;
    }

    private static String decrypt(String dekrypt, String krypt) {

        char[] Temp_Char = krypt.toCharArray();
        for(int x = 0; x < Temp_Char.length; x=x+2) {
            String Temp_String = ""+Temp_Char[x]+""+Temp_Char[x+1];
            char character = (char)Integer.parseInt(Temp_String, 16);
            dekrypt = dekrypt + character;
        }
        return dekrypt;
    }

    private static String fileread(String message) throws IOException {

        FileReader file = new FileReader("info.txt");

        BufferedReader bufferedreader = new BufferedReader(file);
        String line = "";
        Scanner scanner = new Scanner(bufferedreader);

        while (scanner.hasNextLine()) {
            //System.out.println(scanner.nextLine());
            message = message + scanner.nextLine();
        }
        bufferedreader.close();
        return message;
    }

}