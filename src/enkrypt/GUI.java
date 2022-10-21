package enkrypt;

import javax.swing.*;
import java.awt.event.ActionListener;


public class GUI {
    private JButton importKeyFromKeyButton;
    private JButton importTextFromInfoButton;
    private JTextField writeYourTextHereTextField;
    private JTextField writeYourKeyHereTextField;
    private JTextField textField3;
    private JButton exportToOutputTxtButton;
    private JPanel jpanel1;
    private JButton encryptDecryptButton;

    public GUI() {

    }


    public JPanel getPanel() {
        return jpanel1;
    }

    public String getMessage() {
        return writeYourTextHereTextField.getText();
    }

    public String getMessage2() {
        return importTextFromInfoButton.getText();
    }

    public String getKey() {
        return writeYourKeyHereTextField.getText();
    }
    public String getKey2() {
        return importKeyFromKeyButton.getText();
    }

    public void setCrypt(String c) {
        textField3.setText(c);
    }

    public void setmessage(String c) {
        writeYourTextHereTextField.setText(c);
    }

    public void setkey(String c) {
        writeYourKeyHereTextField.setText(c);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("View");
        frame.setContentPane(new GUI().jpanel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    public void setCryptListener(ActionListener cryptListener) {
        encryptDecryptButton.addActionListener(cryptListener);
    }

    public void setkeyListener(ActionListener keyListener) {
        importKeyFromKeyButton.addActionListener(keyListener);
    }
    public void setmessageListener(ActionListener messageListener) {
        importTextFromInfoButton.addActionListener(messageListener);
    }

    public void exportListener(ActionListener exportListener) {
        exportToOutputTxtButton.addActionListener(exportListener);
    }

}
