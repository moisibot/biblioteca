
package Modelo;

/**
 *
 * @author moisibot
 */
public class Usuario {
    private int id_usuario;
    private String nombre;
    private String username;
    private boolean estado;
    private TipoUsuario tipo;
    private String contrasenia;
    private String email;

    public Usuario() {
    }

    public Usuario(int id_usuario, String nombre, String username, boolean estado, TipoUsuario tipo, String contrasenia, String email) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.username = username;
        this.estado = estado;
        this.tipo = tipo;
        this.contrasenia = contrasenia;
        this.email = email;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public TipoUsuario getTipo() {
        return tipo;
    }

    public void setTipo(TipoUsuario tipo) {
        this.tipo = tipo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id_usuario=" + id_usuario + ", nombre=" + nombre + ", username=" + username + ", estado=" + estado + ", tipo=" + tipo + ", contrasenia=" + contrasenia + ", email=" + email + '}';
    }

    public String getIdUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
        
    
    
    
    public enum TipoUsuario {
    ADMINISTRADOR,
    RECEPCIONISTA,
    TRANSPORTISTA,
    USUARIO_FINAL
}

}
