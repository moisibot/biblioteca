
package Modelo;

import java.sql.Date;
import java.util.List;

/**
 *
 * @author moisibot
 */
public class Prestamos {
    
    private int id_prestamos;
    private Bibliotecas id_biblioteca;
    private Recepcionista id_recepcionista;
    private UsuarioFinal id_usuarioFinal;
    private Libros ISBN;
    private Date fecha;
    private boolean estado;
    private double multa;
    private List<DetallesLibros> DetallesLibros; 

    public Prestamos() {
    }

    public Prestamos(int id_prestamos, Bibliotecas id_biblioteca, Recepcionista id_recepcionista, UsuarioFinal id_usuarioFinal, Libros ISBN, Date fecha, boolean estado, double multa, List<DetallesLibros> DetallesLibros) {
        this.id_prestamos = id_prestamos;
        this.id_biblioteca = id_biblioteca;
        this.id_recepcionista = id_recepcionista;
        this.id_usuarioFinal = id_usuarioFinal;
        this.ISBN = ISBN;
        this.fecha = fecha;
        this.estado = estado;
        this.multa = multa;
        this.DetallesLibros = DetallesLibros;
    }

    public int getId_prestamos() {
        return id_prestamos;
    }

    public void setId_prestamos(int id_prestamos) {
        this.id_prestamos = id_prestamos;
    }

    public Bibliotecas getId_biblioteca() {
        return id_biblioteca;
    }

    public void setId_biblioteca(Bibliotecas id_biblioteca) {
        this.id_biblioteca = id_biblioteca;
    }

    public Recepcionista getId_recepcionista() {
        return id_recepcionista;
    }

    public void setId_recepcionista(Recepcionista id_recepcionista) {
        this.id_recepcionista = id_recepcionista;
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

    public List<DetallesLibros> getDetallesLibros() {
        return DetallesLibros;
    }

    public void setDetallesLibros(List<DetallesLibros> DetallesLibros) {
        this.DetallesLibros = DetallesLibros;
    }

    @Override
    public String toString() {
        return "Prestamos{" + "id_prestamos=" + id_prestamos + ", id_biblioteca=" + id_biblioteca + ", id_recepcionista=" + id_recepcionista + ", id_usuarioFinal=" + id_usuarioFinal + ", ISBN=" + ISBN + ", fecha=" + fecha + ", estado=" + estado + ", multa=" + multa + ", DetallesLibros=" + DetallesLibros + '}';
    }

    public int getIdPrestamo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
