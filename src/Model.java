import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import static java.lang.Integer.toHexString;

public class Model {

    String input = new String();
    String k = "pong";
    String krypt = new String();

private static String keymaker(String k, String message) {
    String ogkey = k;
    if (message.length() > k.length()) {
        for (int i = 0; k.length() < message.length(); i++) {
            k += k.charAt(i);
        }
    }
    else {
        k = "";
        for (int i=0; i < message.length(); i++) {
            k += ogkey.charAt(i);
        }
    }
    return k;
}

    private static String encrypt(String k, String message) {
        int key;
        int m;
        String d = "";
        for (int i = 0; i < message.length(); i++) {
            m = message.charAt(i);
            key = k.charAt(i);
            int c = m ^ key;
            d += toHexString(c);
        }
        return d;
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

    private static String decrypt(String dekrypt, String krypt) {

        char[] Temp_Char = krypt.toCharArray();
        for(int x = 0; x < Temp_Char.length; x=x+2) {
            String Temp_String = ""+Temp_Char[x]+""+Temp_Char[x+1];
            char character = (char)Integer.parseInt(Temp_String, 16);
            dekrypt = dekrypt + character;
        }
        return dekrypt;
    }

    public static void main(String[] args) {
        String k = "bruh";
        String message = "high";
        System.out.println(keymaker(k,message));
    }
}