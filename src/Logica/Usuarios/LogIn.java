package Logica.Usuarios;

import java.util.HashMap;

public class LogIn {
    private final HashMap<String, Usuario> usuarios = new HashMap<>();

    public LogIn(){
        usuarios.put("1723372821", new Usuario("Pablo Piedra", "1723372821", "pablo.piedra@udla.edu.ec", "carlos1", true));
        usuarios.put("1723372822", new Usuario("Juan Fonseca", "1723372822","juan.fonseca@udla.edu.ec", "antonio1", false));
        usuarios.put("1723372823", new Usuario("Rosa Santome", "1723372823","rosa.santome@udla.edu.ec", "felipe1", true));
    }

    public HashMap<String, Usuario> getUsuarios() {
        return usuarios;
    }

    public int verificarIdentidad(String cedula, String contr){
        if(usuarios.containsKey(cedula) && usuarios.get(cedula).getContrasenia().equals(contr) && usuarios.get(cedula).isAdmin()) return 1;
        else if (usuarios.containsKey(cedula) && usuarios.get(cedula).getContrasenia().equals(contr) && !usuarios.get(cedula).isAdmin()) return 0;
        return -1;
    }

    public Usuario getUsuarioLogged(String cedula){
        if(!usuarios.containsKey(cedula)) return null;
        return usuarios.get(cedula);
    }
}
