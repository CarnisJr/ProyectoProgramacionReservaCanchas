package Logica.Canchas;

import Logica.Usuarios.ColaReservas;
import Logica.Usuarios.Usuario;

public class Cancha {
    private String tipoCancha;
    private int codigo;
    private String campus;
    private ColaReservas colaReservas;
    private boolean estadoCancha;
    private boolean isBooked;

    public Cancha(String campus, int codigo, String tipoCancha, boolean estadoCancha, boolean isBooked, ColaReservas colaReservas) {
        this.tipoCancha = tipoCancha;
        this.codigo = codigo;
        this.campus = campus;
        this.estadoCancha = estadoCancha;
        this.isBooked = isBooked;
        this.colaReservas = colaReservas;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTipoCancha() {
        return tipoCancha;
    }

    public void setTipoCancha(String tipoCancha) {
        this.tipoCancha = tipoCancha;
    }

    public ColaReservas getCola() {
        return colaReservas;
    }

    public void setCola(ColaReservas colaReservas) {
        this.colaReservas = colaReservas;
    }

    public boolean isEstadoCancha() {
        return estadoCancha;
    }

    public void setEstadoCancha(boolean estadoCancha) {
        this.estadoCancha = estadoCancha;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    public void reservar(){

    }
}
