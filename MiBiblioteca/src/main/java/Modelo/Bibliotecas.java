
package Modelo;
import java.util.List;

/**
 *
 * @author moisibot
 */
public class Bibliotecas {
    
    private int id_biblioteca ;
    private String nombre;
    private String direccion;
    
    private List<Libreria> libreria;

    public Bibliotecas() {
    }

    public Bibliotecas(int id_biblioteca, String nombre, String direccion) {
        this.id_biblioteca = id_biblioteca;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public Bibliotecas(int id_biblioteca, String nombre, String direccion, List<Libreria> libreria) {
        this.id_biblioteca = id_biblioteca;
        this.nombre = nombre;
        this.direccion = direccion;
        this.libreria = libreria;
    }

    public int getId_biblioteca() {
        return id_biblioteca;
    }

    public void setId_biblioteca(int id_biblioteca) {
        this.id_biblioteca = id_biblioteca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Libreria> getLibreria() {
        return libreria;
    }

    public void setLibreria(List<Libreria> libreria) {
        this.libreria = libreria;
    }

    @Override
    public String toString() {
        return "Bibliotecas{" + "id_biblioteca=" + id_biblioteca + ", nombre=" + nombre + ", direccion=" + direccion + ", libreria=" + libreria + '}';
    }  

    public int getIdBiblioteca() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
