import java.io.*;
import java.util.Scanner;

import static java.lang.Integer.toHexString;

public class Model {

    private String message = "";
    private String k = "";
    private String krypt = "";
    private String dekrypt = "";
    public void setmessage(String message) {
        this.message = message;
    }
    public void setk(String k) {
        this.k = k;
    }

    public String getkrypt() {
        return krypt;
    }


    public String keymaker() {
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

    public String encrypt() {
        int key;
        int m;
        for (int i = 0; i < message.length(); i++) {
            m = message.charAt(i);
            key = k.charAt(i);
            int c = m ^ key;
            krypt += (char) c;
        }
        return krypt;
    }

    public void filewriter2() {
        String str = krypt;
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter("output.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            writer.write(str);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void filewrite() {
        String str = krypt;
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter("output.txt", true));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            writer.append(' ');
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            writer.append(str);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String fileread() {

        FileReader file = null;
        try {
            file = new FileReader("info.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        BufferedReader bufferedreader = new BufferedReader(file);
        String line = "";
        Scanner scanner = new Scanner(bufferedreader);

        while (scanner.hasNextLine()) {
            //System.out.println(scanner.nextLine());
            message = message + scanner.nextLine();
        }
        try {
            bufferedreader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return message;
    }


    public String HexToString() {

        char[] Temp_Char = krypt.toCharArray();
        for(int x = 0; x < Temp_Char.length; x=x+2) {
            String Temp_String = ""+Temp_Char[x]+""+Temp_Char[x+1];
            char character = (char)Integer.parseInt(Temp_String, 16);
            dekrypt = dekrypt + character;
        }
        return dekrypt;
    }

    public static void main(String[] args) {

        String k = "¤%";
        String message = "david";

        Model kryptmodel = new Model();
            message = kryptmodel.fileread();
        kryptmodel.setk(k);
        kryptmodel.setmessage(message);
        System.out.println(kryptmodel.keymaker());
        System.out.println(kryptmodel.encrypt());
        kryptmodel.getkrypt();
        kryptmodel.filewriter2();
    }
}