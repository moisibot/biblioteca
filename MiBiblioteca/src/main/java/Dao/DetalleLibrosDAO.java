
package Dao;

/**
 *
 * @author moisibot
 */
import Modelo.DetallesLibros;
import Modelo.TransporteBibliotecas;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DetalleLibrosDAO {
    private Connection conexion;

    public DetalleLibrosDAO(Connection conexion) {
        this.conexion = conexion;
    }
 public boolean crear(DetallesLibros detallesLibros) {
    String query = "INSERT INTO DETALLES_LIBROS (ISBN, id_tb, unidades) VALUES (?, ?, ?)";
    try (var preparedStatement = conexion.prepareStatement(query)) {
        preparedStatement.setString(1, detallesLibros.getISBN());
        preparedStatement.setInt(2, detallesLibros.getId_tb().getIdTb());
        preparedStatement.setInt(3, detallesLibros.getUnidades());
        preparedStatement.executeUpdate();
        System.out.println("Detalles libros creado");
        return true;
    } catch (SQLException e) {
        System.out.println("Error al crear detalles libros: " + e);
    }
    return false;
}

public void actualizar(DetallesLibros detallesLibros) {
    String query = "UPDATE DETALLES_LIBROS SET ISBN = ?, id_tb = ?, unidades = ? WHERE ISBN = ?";

    try (var preparedStatement = conexion.prepareStatement(query)) {
        preparedStatement.setString(1, detallesLibros.getISBN());
        preparedStatement.setInt(2, detallesLibros.getId_tb().getIdTb());
        preparedStatement.setInt(3, detallesLibros.getUnidades());
        preparedStatement.setString(4, detallesLibros.getISBN());
        preparedStatement.executeUpdate();
        System.out.println("Detalles libros actualizado");
    } catch (SQLException e) {
        System.out.println("Error al actualizar detalles libros: " + e);
    }
}

public void eliminar(String ISBN) {
    String query = "DELETE FROM DETALLES_LIBROS WHERE ISBN = ?";

    try (var preparedStatement = conexion.prepareStatement(query)) {
        preparedStatement.setString(1, ISBN);
        preparedStatement.executeUpdate();
        System.out.println("Detalles libros eliminado");
    } catch (SQLException e) {
        System.out.println("Error al eliminar detalles libros: " + e);
    }
}

public List<DetallesLibros> listar() {
        var detallesLibrosList = new ArrayList<DetallesLibros>();
        try (var stmt = conexion.createStatement();
             var resultSet = stmt.executeQuery("SELECT * FROM DETALLES_LIBROS")) {

            while (resultSet.next()) {
                var ISBN = resultSet.getString("ISBN");
                var id_tb = resultSet.getInt("id_tb");
                var unidades = resultSet.getInt("unidades");

                TransporteBibliotecas transporteBibliotecas = obtenerTransporteBibliotecasPorId(id_tb);

                var detallesLibros = new DetallesLibros(ISBN, transporteBibliotecas, unidades);
                detallesLibrosList.add(detallesLibros);
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar detalles del libro: " + e);
        }
        return detallesLibrosList;
    }

    public Optional<DetallesLibros> obtenerDetallesLibros(String ISBN, int id_tb) {
        String query = "SELECT * FROM DETALLES_LIBROS WHERE ISBN = ? AND id_tb = ?";
        DetallesLibros detallesLibros = null;

        try (var preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setString(1, ISBN);
            preparedStatement.setInt(2, id_tb);

            try (var resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    var unidades = resultSet.getInt("unidades");

                    TransporteBibliotecas transporteBibliotecas = obtenerTransporteBibliotecasPorId(id_tb);

                    detallesLibros = new DetallesLibros(ISBN, transporteBibliotecas, unidades);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar detalles del libro: " + e);
        }

        return Optional.ofNullable(detallesLibros);
    }

    // Método para obtener un objeto TransporteBibliotecas por su ID
    private TransporteBibliotecas obtenerTransporteBibliotecasPorId(int id_tb) {
        // Debes implementar este método o usar la clase TransporteBibliotecasDB para obtener el objeto
        // TransporteBibliotecas por su ID.
        // Ejemplo: TransporteBibliotecasDB transporteBibliotecasDB = new TransporteBibliotecasDB(conexion);
        // return transporteBibliotecasDB.obtenerTransporteBibliotecasPorId(id_tb);
        return null; // Implementa la lógica adecuada aquí.
    }

    
    
    
}