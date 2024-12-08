package Logica.Usuarios;

public class Nodo {
    private Usuario usuario;
    private Nodo proximo;

    /**
     * Constructor de nodo
     * @param usuario es de la clase usuario
     * @param proximo este parámetro debe ser inicializado en null
     */
    public Nodo(Usuario usuario, Nodo proximo) {
        this.usuario = usuario;
        this.proximo = proximo;
    }

    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Nodo getProximo() {
        return proximo;
    }
    public void setProximo(Nodo proximo) {
        this.proximo = proximo;
    }
}
