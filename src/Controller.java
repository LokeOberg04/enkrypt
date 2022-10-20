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
        GUI.setkeyListener(new cryptListener());
        GUI.setmessageListener(new cryptListener());
    }

    private class cryptListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            model.setmessage(GUI.getMessage());
            model.setk(GUI.getKey());
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