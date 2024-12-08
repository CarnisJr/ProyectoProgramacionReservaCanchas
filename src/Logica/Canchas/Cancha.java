package Logica.Canchas;

import Logica.Usuarios.Usuario;

public class Cancha {
    private String tipoCancha;
    private int codigo;
    private String campus;
    private Usuario usuario;
    private boolean estadoCancha;
    private boolean isBooked;

    public Cancha(String campus, int codigo, String tipoCancha, boolean estadoCancha, boolean isBooked, Usuario usuario) {
        this.tipoCancha = tipoCancha;
        this.codigo = codigo;
        this.campus = campus;
        this.estadoCancha = estadoCancha;
        this.isBooked = isBooked;
        this.usuario = usuario;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
