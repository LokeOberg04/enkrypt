package enkrypt;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller extends JFrame {
    Model model;
    GUI GUI;

    public Controller(Model m, GUI v) {
        this.model = m;
        this.GUI = v;
        this.setContentPane(GUI.getPanel());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        GUI.setCryptListener(new cryptListener());
        GUI.setmessageListener(new messageListener());
        GUI.setkeyListener(new keyListener());
        GUI.exportListener(new exportListener());
    }
    private class exportListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            model.filewriter2();
        }
    }
    private class messageListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            model.setmessage(model.fileread());
            GUI.setmessage(model.getmessage());
        }
    }
    private class keyListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            model.setk(model.keyread());
            GUI.setkey(model.getkey());
        }
    }
    private class cryptListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            model.setmessage(GUI.getMessage());
            model.setk(GUI.getKey());
            model.keymaker();
            model.encrypt();
            GUI.setCrypt(model.getkrypt());
        }
    }

    public static void main(String[] args) {
        Model m = new Model();
        GUI v = new GUI();
        Controller thisIsTheProgram = new Controller(m,v);
        thisIsTheProgram.setVisible(true);

    }
}