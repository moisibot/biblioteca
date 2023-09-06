
package Modelo;

import java.sql.Date;

/**
 *
 * @author moisibot
 */
public class SolicitudesdePrestamos {
    
    private int id_solicitud;
    private Bibliotecas id_biblioteca;
    private UsuarioFinal id_usuariofinal;
    private Transportista id_transportista;
    private Recepcionista id_recepcionista;
    private TipoEntrega tipo;
    private boolean estado;
    private Date fecha;
    private Libros ISBN;

    public SolicitudesdePrestamos() {
    }

    public SolicitudesdePrestamos(int id_solicitud, Bibliotecas id_biblioteca, UsuarioFinal id_usuariofinal, Transportista id_transportista, Recepcionista id_recepcionista, TipoEntrega tipo, boolean estado, Date fecha, Libros ISBN) {
        this.id_solicitud = id_solicitud;
        this.id_biblioteca = id_biblioteca;
        this.id_usuariofinal = id_usuariofinal;
        this.id_transportista = id_transportista;
        this.id_recepcionista = id_recepcionista;
        this.tipo = tipo;
        this.estado = estado;
        this.fecha = fecha;
        this.ISBN = ISBN;
    }

    public int getId_solicitud() {
        return id_solicitud;
    }

    public void setId_solicitud(int id_solicitud) {
        this.id_solicitud = id_solicitud;
    }

    public Bibliotecas getId_biblioteca() {
        return id_biblioteca;
    }

    public void setId_biblioteca(Bibliotecas id_biblioteca) {
        this.id_biblioteca = id_biblioteca;
    }

    public UsuarioFinal getId_usuariofinal() {
        return id_usuariofinal;
    }

    public void setId_usuariofinal(UsuarioFinal id_usuariofinal) {
        this.id_usuariofinal = id_usuariofinal;
    }

    public Transportista getId_transportista() {
        return id_transportista;
    }

    public void setId_transportista(Transportista id_transportista) {
        this.id_transportista = id_transportista;
    }

    public Recepcionista getId_recepcionista() {
        return id_recepcionista;
    }

    public void setId_recepcionista(Recepcionista id_recepcionista) {
        this.id_recepcionista = id_recepcionista;
    }

    public TipoEntrega getTipo() {
        return tipo;
    }

    public void setTipo(TipoEntrega tipo) {
        this.tipo = tipo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Libros getISBN() {
        return ISBN;
    }

    public void setISBN(Libros ISBN) {
        this.ISBN = ISBN;
    }

    @Override
    public String toString() {
        return "SolicitudesdePrestamos{" + "id_solicitud=" + id_solicitud + ", id_biblioteca=" + id_biblioteca + ", id_usuariofinal=" + id_usuariofinal + ", id_transportista=" + id_transportista + ", id_recepcionista=" + id_recepcionista + ", tipo=" + tipo + ", estado=" + estado + ", fecha=" + fecha + ", ISBN=" + ISBN + '}';
    }

    
            
            
            
    public enum TipoEntrega {
    DOMICILIO,
 
    PRESENCIAL
}
    
    
}
