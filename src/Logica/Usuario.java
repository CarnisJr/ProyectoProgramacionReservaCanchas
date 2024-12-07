package Logica;

import java.util.Random;

public class Usuario {
    private String correoInstitucional;
    private String contrasenia;
    private String nombre;
    private String cedula;
    private boolean isAdmin;

    public Usuario(String nombre, String cedula, String correoInstitucional, String contrasenia, boolean isAdmin) {
        this.correoInstitucional = correoInstitucional;
        this.contrasenia = contrasenia;
        this.nombre = nombre;
        this.cedula = cedula;
        this.isAdmin = isAdmin;
    }

    public Usuario(String nombre, String cedula, boolean isAdmin) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.correoInstitucional = generarCorreoInstitucional();
        this.contrasenia = generarContraseniaTemporal();
        this.isAdmin = isAdmin;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return this.cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getContrasenia() {
        return this.contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getCorreoInstitucional() {
        return this.correoInstitucional;
    }

    public boolean isAdmin() {
        return this.isAdmin;
    }

    public void setCorreoInstitucional(String correoInstitucional) {
        this.correoInstitucional = correoInstitucional;
    }


    private String generarCorreoInstitucional() {
        StringBuilder correoInstutucional = new StringBuilder();
        String[] nombreApellido = this.nombre.split(" ");
        return correoInstutucional.append(nombreApellido[0].toLowerCase()).append(".").append(nombreApellido[1].toLowerCase()).append("@udla.edu.ec").toString();
    }

    private String generarContraseniaTemporal(){
        Random rand = new Random();
        StringBuilder contraseniaTemporal = new StringBuilder();
        for(int i = 0; i < 10; i++){
            char caracterAleatorio = (char) (rand.nextInt(61) + 65);
            contraseniaTemporal.append(caracterAleatorio);
        }
        return contraseniaTemporal.toString();
    }
}
