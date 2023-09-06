
package Modelo;

import jakarta.websocket.Decoder.Text;

/**
 *
 * @author moisibot
 */
public class SolicitudesRevocacion {
    
    private int id_solicitudRevocacion;
    private Usuario id_usuarioFinal;
    private String estado;
    private String detalle;

    public SolicitudesRevocacion() {
    }

    public SolicitudesRevocacion(int id_solicitudRevocacion, Usuario id_usuarioFinal, String estado, String detalle) {
        this.id_solicitudRevocacion = id_solicitudRevocacion;
        this.id_usuarioFinal = id_usuarioFinal;
        this.estado = estado;
        this.detalle = detalle;
    }

    public int getId_solicitudRevocacion() {
        return id_solicitudRevocacion;
    }

    public void setId_solicitudRevocacion(int id_solicitudRevocacion) {
        this.id_solicitudRevocacion = id_solicitudRevocacion;
    }

    public Usuario getId_usuarioFinal() {
        return id_usuarioFinal;
    }

    public void setId_usuarioFinal(Usuario id_usuarioFinal) {
        this.id_usuarioFinal = id_usuarioFinal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    

    @Override
    public String toString() {
        return "SolicitudesRevocacion{" + "id_solicitudRevocacion=" + id_solicitudRevocacion + ", id_usuarioFinal=" + id_usuarioFinal + ", estado=" + estado + ", detalle=" + detalle + '}';
    }
}
