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

        int svar = JOptionPane.showConfirmDialog(null, "Vill du välja en egen nyckel?");
        if (svar == 0) {
            String ko = JOptionPane.showInputDialog("Skriv in din nyckel");
            k = ko.charAt(0);
            System.out.println(k);
        }

        int answer = JOptionPane.showConfirmDialog(null, "Vill du importera text från info.txt?");

        if (answer == 0) {
            FileReader file = new FileReader("info.txt");

            BufferedReader bufferedreader = new BufferedReader(file);
            String line = "";
            Scanner scanner = new Scanner(bufferedreader);

            while (scanner.hasNextLine()) {
                //System.out.println(scanner.nextLine());
                message = message + scanner.nextLine();
            }
            bufferedreader.close();
            System.out.println(message);
        }
        if (answer == 1) {
            message = JOptionPane.showInputDialog("Skriv din text:");
        }

        for (int i = 0; i < message.length(); i++) {
            m = message.charAt(i);
            krypt += toHexString(encrypt(m,k));
        }
        char[] Temp_Char = krypt.toCharArray();
        for(int x = 0; x < Temp_Char.length; x=x+2) {
            String Temp_String = ""+Temp_Char[x]+""+Temp_Char[x+1];
            char character = (char)Integer.parseInt(Temp_String, 16);
            dekrypt = dekrypt + character;
        }
        System.out.println(krypt);
        System.out.println(dekrypt);
    }

    private static int encrypt(int m, int k) {
        int c = m ^ k;
        return c;
    }

}