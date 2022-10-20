import javax.swing.*;
import java.awt.event.ActionListener;


public class GUI {
    private JButton insertTextButton;
    private JButton insertKeyButton;
    private JButton useDefaultKeyButton;
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
        return useDefaultKeyButton.getText();
    }

    public void setCrypt(String c) {
        textField3.setText(c);
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

    public void setkeyListener(ActionListener cryptListener) {
        writeYourKeyHereTextField.addActionListener(cryptListener);
    }
    public void setmessageListener(ActionListener cryptListener) {
        writeYourTextHereTextField.addActionListener(cryptListener);
    }

}
