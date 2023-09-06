
package Dao;

/**
 *
 * @author moisibot
 */

import Modelo.Categorias;
import Modelo.Libros;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LibrosDAO {
    private Connection conexion;

    public LibrosDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public boolean crear(Libros libro) {
        String query = "INSERT INTO LIBROS (ISBN, nombre, costo, id_categoria, autor) VALUES (?, ?, ?, ?, ?)";
        try (var preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setString(1, libro.getISBN());
            preparedStatement.setString(2, libro.getNombre());
            preparedStatement.setDouble(3, libro.getCosto());
            preparedStatement.setInt(4, libro.getId_categoria().getId_categoria());
            preparedStatement.setString(5, libro.getAutor());
            preparedStatement.executeUpdate();
            System.out.println("Libro creado");
            return true;
        } catch (SQLException e) {
            System.out.println("Error al crear libro: " + e);
        }
        return false;
    }

    public void actualizar(Libros libro) {
        String query = "UPDATE LIBROS SET nombre = ?, costo = ?, id_categoria = ?, autor = ? WHERE ISBN = ?";
        try (var preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setString(1, libro.getNombre());
            preparedStatement.setDouble(2, libro.getCosto());
            preparedStatement.setInt(3, libro.getId_categoria().getId_categoria());
            preparedStatement.setString(4, libro.getAutor());
            preparedStatement.setString(5, libro.getISBN());
            preparedStatement.executeUpdate();
            System.out.println("Libro actualizado");
        } catch (SQLException e) {
            System.out.println("Error al actualizar libro: " + e);
        }
    }

    public void eliminar(String ISBN) {
        String query = "DELETE FROM LIBROS WHERE ISBN = ?";
        try (var preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setString(1, ISBN);
            preparedStatement.executeUpdate();
            System.out.println("Libro eliminado");
        } catch (SQLException e) {
            System.out.println("Error al eliminar libro: " + e);
        }
    }

    public List<Libros> listar() {
        var librosList = new ArrayList<Libros>();
        try (var stmt = conexion.createStatement();
             var resultSet = stmt.executeQuery("SELECT * FROM LIBROS")) {

            while (resultSet.next()) {
                var ISBN = resultSet.getString("ISBN");
                var nombre = resultSet.getString("nombre");
                var costo = resultSet.getDouble("costo");
                var id_categoria = resultSet.getInt("id_categoria");
                var autor = resultSet.getString("autor");

                Categorias categorias = obtenerCategoriaPorId(id_categoria);

                var libro = new Libros(ISBN, nombre, costo, categorias, autor);
                librosList.add(libro);
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar libros: " + e);
        }
        return librosList;
    }

    public Optional<Libros> obtenerLibro(String ISBN) {
        String query = "SELECT * FROM LIBROS WHERE ISBN = ?";
        Libros libro = null;

        try (var preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setString(1, ISBN);

            try (var resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    var nombre = resultSet.getString("nombre");
                    var costo = resultSet.getDouble("costo");
                    var id_categoria = resultSet.getInt("id_categoria");
                    var autor = resultSet.getString("autor");


                    Categorias categorias = obtenerCategoriaPorId(id_categoria);

                    libro = new Libros(ISBN, nombre, costo, categorias, autor);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar libro: " + e);
        }

        return Optional.ofNullable(libro);
    }

    // Método para obtener un objeto Categorias por su ID
    private Categorias obtenerCategoriaPorId(int id_categoria) {
        // Debes implementar este método o usar la clase CategoriasDB para obtener el objeto
        // Categorias por su ID.
        // Ejemplo: CategoriasDB categoriasDB = new CategoriasDB(conexion);
        // return categoriasDB.obtenerCategoriaPorId(id_categoria);
        return null; // Implementa la lógica adecuada aquí.
    }
}
