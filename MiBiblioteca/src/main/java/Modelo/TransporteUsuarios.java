
package Modelo;

import java.sql.Date;

/**
 *
 * @author moisibot
 */
public class TransporteUsuarios {
    
    private int id_transporte;
    private Bibliotecas id_biblioteca;
    private UsuarioFinal id_usuarioFinal;
    private Libros ISBN;
    private Date fecha;
    private boolean estado;
    private double multa;

    public TransporteUsuarios() {
    }

    public TransporteUsuarios(int id_transporte, Bibliotecas id_biblioteca, UsuarioFinal id_usuarioFinal, Libros ISBN, Date fecha, boolean estado, double multa) {
        this.id_transporte = id_transporte;
        this.id_biblioteca = id_biblioteca;
        this.id_usuarioFinal = id_usuarioFinal;
        this.ISBN = ISBN;
        this.fecha = fecha;
        this.estado = estado;
        this.multa = multa;
    }

    public int getId_transporte() {
        return id_transporte;
    }

    public void setId_transporte(int id_transporte) {
        this.id_transporte = id_transporte;
    }

    public Bibliotecas getId_biblioteca() {
        return id_biblioteca;
    }

    public void setId_biblioteca(Bibliotecas id_biblioteca) {
        this.id_biblioteca = id_biblioteca;
    }

    public UsuarioFinal getId_usuarioFinal() {
        return id_usuarioFinal;
    }

    public void setId_usuarioFinal(UsuarioFinal id_usuarioFinal) {
        this.id_usuarioFinal = id_usuarioFinal;
    }

    public Libros getISBN() {
        return ISBN;
    }

    public void setISBN(Libros ISBN) {
        this.ISBN = ISBN;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public double getMulta() {
        return multa;
    }

    public void setMulta(double multa) {
        this.multa = multa;
    }

    @Override
    public String toString() {
        return "TransporteUsuarios{" + "id_transporte=" + id_transporte + ", id_biblioteca=" + id_biblioteca + ", id_usuarioFinal=" + id_usuarioFinal + ", ISBN=" + ISBN + ", fecha=" + fecha + ", estado=" + estado + ", multa=" + multa + '}';
    }
    
}
