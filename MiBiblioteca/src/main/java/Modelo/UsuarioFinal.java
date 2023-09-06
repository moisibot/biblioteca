
package Modelo;

/**
 *
 * @author moisibot
 */
public class UsuarioFinal {
    
    private int id_usuariofinal;
    private double saldoinicial;
    private Usuario id_usuario;

    public UsuarioFinal() {
    }

    public UsuarioFinal(int id_usuariofinal, double saldoinicial, Usuario id_usuario) {
        this.id_usuariofinal = id_usuariofinal;
        this.saldoinicial = saldoinicial;
        this.id_usuario = id_usuario;
    }

    public int getId_usuariofinal() {
        return id_usuariofinal;
    }

    public void setId_usuariofinal(int id_usuariofinal) {
        this.id_usuariofinal = id_usuariofinal;
    }

    public double getSaldoinicial() {
        return saldoinicial;
    }

    public void setSaldoinicial(double saldoinicial) {
        this.saldoinicial = saldoinicial;
    }

    public Usuario getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Usuario id_usuario) {
        this.id_usuario = id_usuario;
    }

    @Override
    public String toString() {
        return "UsuarioFinal{" + "id_usuariofinal=" + id_usuariofinal + ", saldoinicial=" + saldoinicial + ", id_usuario=" + id_usuario + '}';
    }

    public int getIdUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getIdUsuarioFinal() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getId_usuarioFinal() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
    
    
    
}
