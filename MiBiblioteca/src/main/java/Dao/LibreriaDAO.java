/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Modelo.Bibliotecas;
import Modelo.Libreria;
import Modelo.Libros;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
/**
 *
 * @author moisibot
 */
public class LibreriaDAO {
    private Connection conexion;

    public LibreriaDAO(Connection conexion) {
        this.conexion = conexion;
    }
    
public boolean crear(Libreria libreria) {
    String query = "INSERT INTO LIBRERIAS (ISBN, blioteca_id, existencia) VALUES (?, ?, ?)";
    try (var preparedStatement = conexion.prepareStatement(query)) {
        preparedStatement.setString(1, libreria.getISBN().getISBN());
        preparedStatement.setInt(2, libreria.getBlioteca_id().getIdBiblioteca());
        preparedStatement.setInt(3, libreria.getExistencia());
        preparedStatement.executeUpdate();
        System.out.println("Libreria creada");
        return true;
    } catch (SQLException e) {
        System.out.println("Error al crear libreria: " + e);
    }
    return false;
}

public void actualizar(Libreria libreria) {
    String query = "UPDATE LIBRERIAS SET ISBN = ?, blioteca_id = ?, existencia = ? WHERE ISBN = ?";

    try (var preparedStatement = conexion.prepareStatement(query)) {
        preparedStatement.setString(1, libreria.getISBN().getISBN());
        preparedStatement.setInt(2, libreria.getBlioteca_id().getIdBiblioteca());
        preparedStatement.setInt(3, libreria.getExistencia());
        preparedStatement.setString(4, libreria.getISBN().getISBN());
        preparedStatement.executeUpdate();
        System.out.println("Libreria actualizada");
    } catch (SQLException e) {
        System.out.println("Error al actualizar libreria: " + e);
    }
}

public void eliminar(String ISBN) {
    String query = "DELETE FROM LIBRERIAS WHERE ISBN = ?";

    try (var preparedStatement = conexion.prepareStatement(query)) {
        preparedStatement.setString(1, ISBN);
        preparedStatement.executeUpdate();
        System.out.println("Libreria eliminada");
    } catch (SQLException e) {
        System.out.println("Error al eliminar libreria: " + e);
    }
}

public List<Libreria> listar() {
        var libreriaList = new ArrayList<Libreria>();
        try (var stmt = conexion.createStatement();
             var resultSet = stmt.executeQuery("SELECT * FROM LIBRERIA")) {

            while (resultSet.next()) {
                var ISBN = resultSet.getString("ISBN");
                var biblioteca_id = resultSet.getInt("blioteca_id");
                var existencia = resultSet.getInt("existencia");

                // Debes implementar la lógica para obtener los objetos Libros y Bibliotecas correspondientes
                Libros libros = obtenerLibrosPorISBN(ISBN);
                Bibliotecas bibliotecas = obtenerBibliotecasPorId(biblioteca_id);

                var libreria = new Libreria(libros, bibliotecas, existencia);
                libreriaList.add(libreria);
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar librerias: " + e);
        }
        return libreriaList;
    }

    public Optional<Libreria> obtenerLibreria(String ISBN, int biblioteca_id) {
        String query = "SELECT * FROM LIBRERIA WHERE ISBN = ? AND biblioteca_id = ?";
        Libreria libreria = null;

        try (var preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setString(1, ISBN);
            preparedStatement.setInt(2, biblioteca_id);

            try (var resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    var existencia = resultSet.getInt("existencia");

                    // Debes implementar la lógica para obtener los objetos Libros y Bibliotecas correspondientes
                    Libros libros = obtenerLibrosPorISBN(ISBN);
                    Bibliotecas bibliotecas = obtenerBibliotecasPorId(biblioteca_id);

                    libreria = new Libreria(libros, bibliotecas, existencia);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar libreria: " + e);
        }

        return Optional.ofNullable(libreria);
    }

    // Método para obtener un objeto Libros por su ISBN
    private Libros obtenerLibrosPorISBN(String ISBN) {
        // Debes implementar este método o usar la clase LibrosDB para obtener el objeto
        // Libros por su ISBN.
        // Ejemplo: LibrosDB librosDB = new LibrosDB(conexion);
        // return librosDB.obtenerLibrosPorISBN(ISBN);
        return null; // Implementa la lógica adecuada aquí.
    }

    // Método para obtener un objeto Bibliotecas por su ID
    private Bibliotecas obtenerBibliotecasPorId(int id_biblioteca) {
        // Debes implementar este método o usar la clase BibliotecasDB para obtener el objeto
        // Bibliotecas por su ID.
        // Ejemplo: BibliotecasDB bibliotecasDB = new BibliotecasDB(conexion);
        // return bibliotecasDB.obtenerBibliotecaPorId(id_biblioteca);
        return null; // Implementa la lógica adecuada aquí.
    }
}

