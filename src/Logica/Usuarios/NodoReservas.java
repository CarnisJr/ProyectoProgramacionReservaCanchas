package Logica.Usuarios;

public class NodoReservas {
    private Usuario usuario;
    private NodoReservas proximo;

    /**
     * Constructor de una nodo para la estructura de nodo.
     * @param usuario almacena una instancia de la clase usuario.
     * @param proximo siempre inicializado en null.
     */
    public NodoReservas(Usuario usuario, NodoReservas proximo) {
        this.usuario = usuario;
        this.proximo = proximo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public NodoReservas getProximo() {
        return proximo;
    }

    public void setProximo(NodoReservas proximo) {
        this.proximo = proximo;
    }
}
