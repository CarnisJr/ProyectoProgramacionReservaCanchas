package GUI;

import Logica.Canchas.Cancha;
import Logica.Canchas.GestionCanchas;
import Logica.Usuarios.ColaReservas;
import Sistema.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UsrSide extends JFrame {
    private JPanel mainFrameReservarCancha;
    private JComboBox campusComboBox;
    private JTextField codigoReservaTxt;
    private JTable tableCanchas;
    private JTextArea mostrarColaDeReservasCanchas;
    private JButton mostrarCanchasButton;
    private JButton reservarButton;
    private JButton mostrarColaButton;
    private JTabbedPane tabbedPane;
    private JPanel reservarCancha;
    private AdminSide adminSide = Main.adminSide;
    private GestionCanchas gestionCanchas;

    public UsrSide() {

        add(mainFrameReservarCancha);
        this.setTitle("Usr Side");
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gestionCanchas = adminSide.getGestionCanchas();

        gestionReservaCanchas();

    }
    public void gestionReservaCanchas(){

        mostrarCanchasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gestionCanchas.mostrarCanchas(campusComboBox.getSelectedItem().toString(), tableCanchas);
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

        reservarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(gestionCanchas.getCanchasMap().containsKey(campusComboBox.getSelectedItem().toString())) {
                    ArrayList<Cancha> aux = gestionCanchas.getCanchasMap().get(campusComboBox.getSelectedItem().toString());
                    for(Cancha c : aux) {
                        if(Integer.toString(c.getCodigo()).equals(codigoReservaTxt.getText())) {
                            String cedulaParaReserva = Main.usuarioLogged.getCedula();
                            if(Main.logIn.getUsuarios().containsKey(cedulaParaReserva)) {
                                c.getCola().agregarUsuario(Main.logIn.getUsuarios().get(cedulaParaReserva));
                                c.setBooked(true);
                                adminSide.setGestionCanchas(gestionCanchas);
                                JOptionPane.showMessageDialog(mainFrameReservarCancha, "Cancha Reservada por " + Main.usuarioLogged.getNombre());
                            }
                            break;
                        }
                    }
                }else JOptionPane.showMessageDialog(null, "Seleccione un campus");
            }
        });
    }
}
