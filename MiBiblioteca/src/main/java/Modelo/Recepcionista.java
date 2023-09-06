
package Modelo;

/**
 *
 * @author moisibot
 */
public class Recepcionista {
    
    private int id_recepcionista;
    private Bibliotecas id_biblioteca;
    private Usuario id_usuario;

    public Recepcionista() {
    }

    public Recepcionista(int id_recepcionista, Bibliotecas id_biblioteca, Usuario id_usuario) {
        this.id_recepcionista = id_recepcionista;
        this.id_biblioteca = id_biblioteca;
        this.id_usuario = id_usuario;
    }

    public int getId_recepcionista() {
        return id_recepcionista;
    }

    public void setId_recepcionista(int id_recepcionista) {
        this.id_recepcionista = id_recepcionista;
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
        return "Recepcionista{" + "id_recepcionista=" + id_recepcionista + ", id_biblioteca=" + id_biblioteca + ", id_usuario=" + id_usuario + '}';
    }
    
}
