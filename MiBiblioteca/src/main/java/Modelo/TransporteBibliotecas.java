
package Modelo;

import java.sql.Date;

/**
 *
 * @author moisibot
 */
public class TransporteBibliotecas {
    
    private int id_tb;
    private Bibliotecas id_biblioteca_origen;
    private Bibliotecas id_biblioteca_destino;
    private Recepcionista id_recepcionista;
    private Transportista id_transportista;
    private Date fecha;
    private boolean estado;

    public TransporteBibliotecas() {
    }

    public TransporteBibliotecas(int id_tb, Bibliotecas id_biblioteca_origen, Bibliotecas id_biblioteca_destino, Recepcionista id_recepcionista, Transportista id_transportista, Date fecha, boolean estado) {
        this.id_tb = id_tb;
        this.id_biblioteca_origen = id_biblioteca_origen;
        this.id_biblioteca_destino = id_biblioteca_destino;
        this.id_recepcionista = id_recepcionista;
        this.id_transportista = id_transportista;
        this.fecha = fecha;
        this.estado = estado;
    }

    public int getId_tb() {
        return id_tb;
    }

    public void setId_tb(int id_tb) {
        this.id_tb = id_tb;
    }

    public Bibliotecas getId_biblioteca_origen() {
        return id_biblioteca_origen;
    }

    public void setId_biblioteca_origen(Bibliotecas id_biblioteca_origen) {
        this.id_biblioteca_origen = id_biblioteca_origen;
    }

    public Bibliotecas getId_biblioteca_destino() {
        return id_biblioteca_destino;
    }

    public void setId_biblioteca_destino(Bibliotecas id_biblioteca_destino) {
        this.id_biblioteca_destino = id_biblioteca_destino;
    }

    public Recepcionista getId_recepcionista() {
        return id_recepcionista;
    }

    public void setId_recepcionista(Recepcionista id_recepcionista) {
        this.id_recepcionista = id_recepcionista;
    }

    public Transportista getId_transportista() {
        return id_transportista;
    }

    public void setId_transportista(Transportista id_transportista) {
        this.id_transportista = id_transportista;
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

    @Override
    public String toString() {
        return "TransporteBibliotecas{" + "id_tb=" + id_tb + ", id_biblioteca_origen=" + id_biblioteca_origen + ", id_biblioteca_destino=" + id_biblioteca_destino + ", id_recepcionista=" + id_recepcionista + ", id_transportista=" + id_transportista + ", fecha=" + fecha + ", estado=" + estado + '}';
    }

    public int getIdTb() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    
}
