package Logica.Usuarios;

public class NodoListaSimple {
    private Usuario usuario;
    private NodoListaSimple proximo;

    /**
     * Constructor de nodo
     * @param usuario es de la clase usuario
     * @param proximo este parámetro debe ser inicializado en null
     */
    public NodoListaSimple(Usuario usuario, NodoListaSimple proximo) {
        this.usuario = usuario;
        this.proximo = proximo;
    }

    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public NodoListaSimple getProximo() {
        return proximo;
    }
    public void setProximo(NodoListaSimple proximo) {
        this.proximo = proximo;
    }
}
