package Modelo;

/**
 *
 * @author moisibot
 */
public class Transportista {
    
    private int id_transportista;
    private Bibliotecas id_biblioteca;
    private Usuario id_usuario;

    public Transportista() {
    }

    public Transportista(int id_transportista, Bibliotecas id_biblioteca, Usuario id_usuario) {
        this.id_transportista = id_transportista;
        this.id_biblioteca = id_biblioteca;
        this.id_usuario = id_usuario;
    }

    public int getId_transportista() {
        return id_transportista;
    }

    public void setId_transportista(int id_transportista) {
        this.id_transportista = id_transportista;
    }

    public Bibliotecas getId_biblioteca() {
        return id_biblioteca;
    }

    public void setId_biblioteca(Bibliotecas id_biblioteca) {
        this.id_biblioteca = id_biblioteca;
    }

    public Usuario getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Usuario id_usuario) {
        this.id_usuario = id_usuario;
    }

    @Override
    public String toString() {
        return "Transportista{" + "id_transportista=" + id_transportista + ", id_biblioteca=" + id_biblioteca + ", id_usuario=" + id_usuario + '}';
    }

}
