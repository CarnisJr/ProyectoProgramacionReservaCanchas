package Sistema;

import GUI.LogInScreen;
import GUI.AdminSide;
import Logica.Usuarios.LogIn;
import Logica.Usuarios.Usuario;

import javax.swing.*;

public class Main {
    private static LogInScreen logInScreen = null;
    public static Usuario usuarioLogged;
    public static LogIn logIn = new LogIn();

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                logInScreen = new LogInScreen();
            }
        });
    }

    public static void logIn(){

        //System.out.println(logIn.verificarIdentidad(logInScreen.usrField.getText(), logInScreen.pwdField.getText()));
        if(logIn.verificarIdentidad(logInScreen.usrField.getText(), logInScreen.pwdField.getText()) == 1) {
            usuarioLogged = logIn.getUsuarioLogged(logInScreen.usrField.getText());
            JOptionPane.showMessageDialog(null, "Bienvenido " + usuarioLogged.getNombre());
            new AdminSide();
            logInScreen.dispose();
        }
    }
}