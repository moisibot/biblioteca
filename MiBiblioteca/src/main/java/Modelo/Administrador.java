
package Modelo;

/**
 *
 * @author moisibot
 */
public class Administrador {
    private String id_administrador;
    private Usuario id_usuario;

    public Administrador() {
    }

    public Administrador(String id_administrador, Usuario id_usuario) {
        this.id_administrador = id_administrador;
        this.id_usuario = id_usuario;
    }

    public String getId_administrador() {
        return id_administrador;
    }

    public void setId_administrador(String id_administrador) {
        this.id_administrador = id_administrador;
    }

    public Usuario getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Usuario id_usuario) {
        this.id_usuario = id_usuario;
    }

    @Override
    public String toString() {
        return "Administrador{" + "id_administrador=" + id_administrador + ", id_usuario=" + id_usuario + '}';
    }

    
   
    
    
    
}
