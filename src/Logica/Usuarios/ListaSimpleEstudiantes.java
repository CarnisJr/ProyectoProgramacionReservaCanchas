package Logica.Usuarios;

import Sistema.Main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ListaSimpleEstudiantes {

    private Nodo inicio;

    public ListaSimpleEstudiantes() {
        this.inicio = null;
    }

    public boolean isEmpty(){
        return this.inicio == null;
    }

    public void agreagarEstudiante(Usuario estudiante){
        Nodo nuevoNodo = new Nodo(estudiante, null);

        if(isEmpty())
            this.inicio = nuevoNodo;
        else{
            Nodo aux = this.inicio;
            while(aux.getProximo() != null){
                aux = aux.getProximo();
            }
            aux.setProximo(nuevoNodo);
        }
    }

    public boolean buscarEstudiante(String cedula, JTextArea textArea){
        Nodo aux = this.inicio;

        while(aux != null){
            if(aux.getUsuario().getCedula().equals(cedula)){
                JOptionPane.showMessageDialog(null, "Estudiante encontrado");
                textArea.setText("Nombre: " + aux.getUsuario().getNombre() + "\nCédula: " + aux.getUsuario().getCedula()
                                    + "\nCorreo Institucional: " + aux.getUsuario().getCorreoInstitucional());
                return true;
            }
            aux = aux.getProximo();
        }
        JOptionPane.showMessageDialog(null, "No se ha encontrado al estudiante");
        return false;
    }

    public void eliminar(String cedula, JTextArea textArea){
        if(buscarEstudiante(cedula, textArea)){
            int confirmacion = JOptionPane.showConfirmDialog(null, "Seguro quieres eliminar al estudiante?", "Confirmación", JOptionPane.YES_NO_OPTION);
            if(confirmacion == JOptionPane.YES_OPTION)
                Main.logIn.getUsuarios().remove(cedula);
        }
    }

    public void mostrarElementos(JTable table){

        Nodo aux = this.inicio;
        DefaultTableModel model = new DefaultTableModel(new Object[]{"Nombre", "Cédula", "Correo Institucional"}, 0);
        model.addRow(new Object[]{"Nombre", "Cédula", "Correo Institucional"});

        while(aux != null){

            model.addRow(new Object[]{aux.getUsuario().getNombre(), aux.getUsuario().getCedula(), aux.getUsuario().getCorreoInstitucional()});
            System.out.println(aux.getUsuario().getNombre() + "\n");
            aux = aux.getProximo();
        }
        table.setModel(model);
    }
}