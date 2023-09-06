
package Modelo;

/**
 *
 * @author moisibot
 */
public class Libreria {
    
        private Libros ISBN;
    private Bibliotecas blioteca_id;
    private int existencia;

    public Libreria() {
    }

    public Libreria(Libros ISBN, Bibliotecas blioteca_id, int existencia) {
        this.ISBN = ISBN;
        this.blioteca_id = blioteca_id;
        this.existencia = existencia;
    }

    
    
    
    public Libros getISBN() {
        return ISBN;
    }

    public void setISBN(Libros ISBN) {
        this.ISBN = ISBN;
    }

    public Bibliotecas getBlioteca_id() {
        return blioteca_id;
    }

    public void setBlioteca_id(Bibliotecas blioteca_id) {
        this.blioteca_id = blioteca_id;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    @Override
    public String toString() {
        return "Libreria{" + "ISBN=" + ISBN + ", blioteca_id=" + blioteca_id + ", existencia=" + existencia + '}';
    }

}
