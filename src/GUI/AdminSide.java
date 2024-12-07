package GUI;

import Logica.ListaSimpleEstudiantes;
import Logica.Usuario;
import Sistema.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminSide extends JFrame {
    private JPanel mainFrame;
    private JTabbedPane tabbedPane;
    private JPanel gestionarEstudiantes;
    private JButton agregarEstudiantesButton;
    private JTextField nombreAgregarUsr;
    private JTextField cedulaAgregarUsr;
    private JButton buscarButton;
    private JTextArea textLog;
    private JButton eleminarEstudianteButton;
    private JButton mostrarEstudiantesButton;
    private JTable tablaEstudiantes;
    private ListaSimpleEstudiantes listaSimpleEstudiantes = new ListaSimpleEstudiantes();

    public AdminSide() {
        add(mainFrame);
        this.setTitle(Main.usuarioLogged.getCorreoInstitucional());
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        hashMapValuesToList(listaSimpleEstudiantes);

        agregarEstudiantesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(!Main.logIn.getUsuarios().containsKey(cedulaAgregarUsr.getText())) {
                    Usuario usr = new Usuario(nombreAgregarUsr.getText(), cedulaAgregarUsr.getText(), false);
                    listaSimpleEstudiantes.agreagarEstudiante(usr);
                    Main.logIn.getUsuarios().put(usr.getCedula(), usr);
                    JOptionPane.showMessageDialog(mainFrame, "Se agregó al usuario");
                }else JOptionPane.showMessageDialog(mainFrame, "Ya existe el usuario");
            }
        });

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listaSimpleEstudiantes.buscarEstudiante(cedulaAgregarUsr.getText(), textLog);
            }
        });

        eleminarEstudianteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                listaSimpleEstudiantes.eliminar(cedulaAgregarUsr.getText(), textLog);
                listaSimpleEstudiantes = new ListaSimpleEstudiantes();
                hashMapValuesToList(listaSimpleEstudiantes);
            }
        });

        mostrarEstudiantesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listaSimpleEstudiantes.mostrarElementos(tablaEstudiantes);
            }
        });
    }

    public void hashMapValuesToList(ListaSimpleEstudiantes listaSimpleEstudiantes){
        for(Usuario usr : Main.logIn.getUsuarios().values()) {
            if(!usr.isAdmin()){
                listaSimpleEstudiantes.agreagarEstudiante(usr);
            }
        }
    }
}
