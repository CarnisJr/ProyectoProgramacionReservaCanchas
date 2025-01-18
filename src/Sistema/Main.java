package Sistema;

import GUI.*;
import Logica.Usuarios.LogIn;
import Logica.Usuarios.Usuario;

import javax.swing.*;

public class Main {
    private static LogInScreen logInScreen = null;
    public static Usuario usuarioLogged;
    public static LogIn logIn = new LogIn();
    public static AdminSide adminSide;

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                logInScreen = new LogInScreen();
            }
        });
    }

    public static void logIn(){

        if(logIn.verificarIdentidad(logInScreen.usrField.getText(), logInScreen.pwdField.getText()) == 1) {
            usuarioLogged = logIn.getUsuarioLogged(logInScreen.usrField.getText());
            JOptionPane.showMessageDialog(null, "Bienvenido " + usuarioLogged.getNombre());
            adminSide = new AdminSide();
            //logInScreen.dispose();
        }else if(logIn.verificarIdentidad(logInScreen.usrField.getText(), logInScreen.pwdField.getText()) == 0) {
            usuarioLogged = logIn.getUsuarioLogged(logInScreen.usrField.getText());
            JOptionPane.showMessageDialog(null, "Bienvenido " + usuarioLogged.getNombre());
            new UsrSide();
            //logInScreen.dispose();
        }else
            JOptionPane.showMessageDialog(null, "Usuario " + logInScreen.usrField.getText() + "no encontrado");
    }
}