
package Dao;

/**
 *
 * @author moisibot
 */

import Modelo.Bibliotecas;
import Modelo.Libreria;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BibliotecasDAO {
    private Connection conexion;

    public BibliotecasDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public boolean crear(Bibliotecas biblioteca) {
        String query = "INSERT INTO BIBLIOTECAS (nombre, direccion) VALUES (?, ?)";
        try (var preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setString(1, biblioteca.getNombre());
            preparedStatement.setString(2, biblioteca.getDireccion());
            preparedStatement.executeUpdate();
            System.out.println("Biblioteca creada");
            return true;
        } catch (SQLException e) {
            System.out.println("Error al crear biblioteca: " + e);
        }
        return false;
    }

    public void actualizar(Bibliotecas biblioteca) {
        String query = "UPDATE BIBLIOTECAS SET nombre = ?, direccion = ? WHERE id_biblioteca = ?";
        try (var preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setString(1, biblioteca.getNombre());
            preparedStatement.setString(2, biblioteca.getDireccion());
            preparedStatement.setInt(3, biblioteca.getId_biblioteca());
            preparedStatement.executeUpdate();
            System.out.println("Biblioteca actualizada");
        } catch (SQLException e) {
            System.out.println("Error al actualizar biblioteca: " + e);
        }
    }

    public void eliminar(int id_biblioteca) {
        String query = "DELETE FROM BIBLIOTECAS WHERE id_biblioteca = ?";
        try (var preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setInt(1, id_biblioteca);
            preparedStatement.executeUpdate();
            System.out.println("Biblioteca eliminada");
        } catch (SQLException e) {
            System.out.println("Error al eliminar biblioteca: " + e);
        }
    }

    public List<Bibliotecas> listar() {
        var bibliotecas = new ArrayList<Bibliotecas>();
        try (var stmt = conexion.createStatement();
             var resultSet = stmt.executeQuery("SELECT * FROM BIBLIOTECAS")) {

            while (resultSet.next()) {
                var id_biblioteca = resultSet.getInt("id_biblioteca");
                var nombre = resultSet.getString("nombre");
                var direccion = resultSet.getString("direccion");

                List<Libreria> libreria = obtenerLibreriasPorBiblioteca(id_biblioteca);

                var biblioteca = new Bibliotecas(id_biblioteca, nombre, direccion, libreria);
                bibliotecas.add(biblioteca);
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar bibliotecas: " + e);
        }
        return bibliotecas;
    }

    public Optional<Bibliotecas> obtenerBiblioteca(int id_biblioteca) {
        String query = "SELECT * FROM BIBLIOTECAS WHERE id_biblioteca = ?";
        Bibliotecas biblioteca = null;

        try (var preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setInt(1, id_biblioteca);

            try (var resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    var nombre = resultSet.getString("nombre");
                    var direccion = resultSet.getString("direccion");

                    List<Libreria> libreria = obtenerLibreriasPorBiblioteca(id_biblioteca);

                    biblioteca = new Bibliotecas(id_biblioteca, nombre, direccion, libreria);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar biblioteca: " + e);
        }

        return Optional.ofNullable(biblioteca);
    }

    // Método para obtener las librerías relacionadas con una biblioteca
    private List<Libreria> obtenerLibreriasPorBiblioteca(int id_biblioteca) {
        // Debes implementar este método o usar la clase LibreriaDB para obtener las librerías por la biblioteca.
        // Ejemplo: LibreriaDB libreriaDB = new LibreriaDB(conexion);
        // return libreriaDB.obtenerLibreriasPorBiblioteca(id_biblioteca);
        return new ArrayList<>(); // Implementa la lógica adecuada aquí.
    }
}


