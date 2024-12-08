package Logica.Usuarios;

import javax.swing.*;
import java.awt.*;

public class ColaReservas {
    private NodoReservas inicio;
    private NodoReservas fin;
    private int tamanioCola;

    public ColaReservas(){
        this.inicio = this.fin = null;
        this.tamanioCola = 0;
    }

    public NodoReservas getNodoInicio() {
        return this.inicio;
    }

    public boolean isEmpty(){
        return this.inicio == null && this.fin == null;
    }

    public void agregarUsuario(Usuario usuario){
        NodoReservas nuevoUsuario = new NodoReservas(usuario, null);

        if(isEmpty()){
            this.inicio = this.fin = nuevoUsuario;
        }else{
            this.fin.setProximo(nuevoUsuario);
            this.fin = nuevoUsuario;
        }
        this.tamanioCola++;
    }

    public void desencolarUsuario(){
        if(isEmpty()){
            JOptionPane.showMessageDialog(null, "No existen reservas");
        }else{
            if(this.inicio == this.fin){
                this.inicio = this.fin = null;
            }else{
                this.inicio = this.inicio.getProximo();
            }
            this.tamanioCola--;
        }
    }

    public String mostrarCola(){
        NodoReservas aux = this.inicio;
        StringBuilder colaStr = new StringBuilder();
        while(aux != null){
            colaStr.append(aux.getUsuario().getCorreoInstitucional()).append("\n");
            aux = aux.getProximo();
        }
        return colaStr.toString();
    }
}
