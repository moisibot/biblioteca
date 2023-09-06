
package Modelo;

/**
 *
 * @author moisibot
 */
public class DetallesLibros {
    
    private String ISBN;
    private TransporteBibliotecas id_tb;
    private int unidades;

    public DetallesLibros() {
    }

    public DetallesLibros(String ISBN, TransporteBibliotecas id_tb, int unidades) {
        this.ISBN = ISBN;
        this.id_tb = id_tb;
        this.unidades = unidades;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public TransporteBibliotecas getId_tb() {
        return id_tb;
    }

    public void setId_tb(TransporteBibliotecas id_tb) {
        this.id_tb = id_tb;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    @Override
    public String toString() {
        return "DetallesLibros{" + "ISBN=" + ISBN + ", id_tb=" + id_tb + ", unidades=" + unidades + '}';
    }    
}
