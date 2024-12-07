package GUI;

import Sistema.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogInScreen extends JFrame {
    private JPanel mainFrame;
    private JButton logInButton;
    public JTextField usrField;
    public JPasswordField pwdField;

    public LogInScreen() {

        add(mainFrame);
        this.setTitle("Log in");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.logIn();
            }
        });
    }
}
