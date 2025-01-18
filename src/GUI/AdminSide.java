package GUI;

import Logica.Canchas.Cancha;
import Logica.Canchas.GestionCanchas;
import Logica.Usuarios.ColaReservas;
import Logica.Usuarios.ListaSimpleEstudiantes;
import Logica.Usuarios.Usuario;
import Sistema.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
    private JPanel gestionarCanchas;
    private JTable tableCanchas;
    private JButton mostrarCanchasButton;
    private JComboBox campusComboBox;
    private JTextField codigoReservaTxt;
    private JButton reservarButton;
    private JButton mostrarColaButton;
    private JButton eliminarDeColaButton;
    private JTextArea mostrarColaDeReservasCanchas;
    private ListaSimpleEstudiantes listaSimpleEstudiantes = new ListaSimpleEstudiantes();
    private GestionCanchas gestionCanchas = new GestionCanchas();

    public GestionCanchas getGestionCanchas() {
        return this.gestionCanchas;
    }

    public void setGestionCanchas(GestionCanchas gestionCanchas) {
        this.gestionCanchas = gestionCanchas;
    }

    public AdminSide() {
        add(mainFrame);
        this.setTitle(Main.usuarioLogged.getCorreoInstitucional());
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        hashMapValuesToList(listaSimpleEstudiantes);

        gestionDeEstudiantes();
        gestionarCanchas();
    }

    public void gestionarCanchas() {

        mostrarCanchasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gestionCanchas.mostrarCanchas(campusComboBox.getSelectedItem().toString(), tableCanchas);
            }
        });

        reservarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seleccionarCanchaAReservar();
            }
        });
        mostrarColaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Cancha> aux = gestionCanchas.getCanchasMap().get(campusComboBox.getSelectedItem().toString());
                for(Cancha c : aux) {
                    if(Integer.toString(c.getCodigo()).equals(codigoReservaTxt.getText())) {
                        if(c.getCola().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "No hay nadie en la cola");
                        }
                        mostrarColaDeReservasCanchas.setText(c.getCola().mostrarCola());
                        break;
                    }
                    mostrarColaDeReservasCanchas.setText("No hay reservas");
                }
            }
        });

        eliminarDeColaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Cancha> aux = gestionCanchas.getCanchasMap().get(campusComboBox.getSelectedItem().toString());
                for(Cancha c : aux) {
                    if(Integer.toString(c.getCodigo()).equals(codigoReservaTxt.getText())) {
                        c.getCola().desencolarUsuario();
                        if(c.getCola().isEmpty())
                            c.setBooked(false);
                        mostrarColaDeReservasCanchas.setText(c.getCola().mostrarCola());
                        break;
                    }
                    mostrarColaDeReservasCanchas.setText("No hay reservas");
                }
            }
        });
    }

    public void seleccionarCanchaAReservar(){
        if(gestionCanchas.getCanchasMap().containsKey(campusComboBox.getSelectedItem().toString())) {
            ArrayList<Cancha> aux = gestionCanchas.getCanchasMap().get(campusComboBox.getSelectedItem().toString());
            for(Cancha c : aux) {
                if(Integer.toString(c.getCodigo()).equals(codigoReservaTxt.getText())) {
                    String cedulaParaReserva = JOptionPane.showInputDialog(null, "Ingrese la cédula del estudiante");
                    if(Main.logIn.getUsuarios().containsKey(cedulaParaReserva) && !Main.logIn.getUsuarios().get(cedulaParaReserva).isAdmin()) {
                        c.getCola().agregarUsuario(Main.logIn.getUsuarios().get(cedulaParaReserva));
                        c.setBooked(true);
                        JOptionPane.showMessageDialog(null, "Se realizó la reserva exitosamente");
                    }else JOptionPane.showMessageDialog(null, "No existe ese Estudiante");
                    break;
                }
            }
        }else JOptionPane.showMessageDialog(null, "Seleccione un campus");
    }

    public void hashMapValuesToList(ListaSimpleEstudiantes listaSimpleEstudiantes){
        for(Usuario usr : Main.logIn.getUsuarios().values()) {
            if(!usr.isAdmin()){
                listaSimpleEstudiantes.agreagarEstudiante(usr);
            }
        }
    }

    public void gestionDeEstudiantes(){
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
}
