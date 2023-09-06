
package Modelo;

/**
 *
 * @author moisibot
 */
public class Libros {
    
    private String ISBN;
    private String nombre;
    private double costo;
    private Categorias id_categoria;
    private String autor;

    public Libros() {
    }

    public Libros(String ISBN, String nombre, double costo, Categorias id_categoria, String autor) {
        this.ISBN = ISBN;
        this.nombre = nombre;
        this.costo = costo;
        this.id_categoria = id_categoria;
        this.autor = autor;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public Categorias getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(Categorias id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Libros{" + "ISBN=" + ISBN + ", nombre=" + nombre + ", costo=" + costo + ", id_categoria=" + id_categoria + ", autor=" + autor + '}';
    }

}
