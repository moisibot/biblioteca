
package Modelo;

/**
 *
 * @author moisibot
 */
public class Incidencias {
    
    private int id_incidencias;
    private Prestamos id_prestamos;
    private String tipo;
    private double cantidadPagada;

    public Incidencias() {
    }

    public Incidencias(int id_incidencias, Prestamos id_prestamos, String tipo, double cantidadPagada) {
        this.id_incidencias = id_incidencias;
        this.id_prestamos = id_prestamos;
        this.tipo = tipo;
        this.cantidadPagada = cantidadPagada;
    }

    public int getId_incidencias() {
        return id_incidencias;
    }

    public void setId_incidencias(int id_incidencias) {
        this.id_incidencias = id_incidencias;
    }

    public Prestamos getId_prestamos() {
        return id_prestamos;
    }

    public void setId_prestamos(Prestamos id_prestamos) {
        this.id_prestamos = id_prestamos;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getCantidadPagada() {
        return cantidadPagada;
    }

    public void setCantidadPagada(double cantidadPagada) {
        this.cantidadPagada = cantidadPagada;
    }

    @Override
    public String toString() {
        return "Incidencias{" + "id_incidencias=" + id_incidencias + ", id_prestamos=" + id_prestamos + ", tipo=" + tipo + ", cantidadPagada=" + cantidadPagada + '}';
    }  
}
