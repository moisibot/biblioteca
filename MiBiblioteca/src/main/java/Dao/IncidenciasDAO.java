
package Dao;

/**
 *
 * @author moisibot
 */

import Modelo.Incidencias;
import Modelo.Prestamos;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class IncidenciasDAO {
    private Connection conexion;

    public IncidenciasDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public boolean crear(Incidencias incidencia) {
        String query = "INSERT INTO INCIDENCIAS (id_prestamos, tipo, cantidadPagada) VALUES (?, ?, ?)";
        try (var preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setInt(1, incidencia.getId_prestamos().getIdPrestamo());
            preparedStatement.setString(2, incidencia.getTipo());
            preparedStatement.setDouble(3, incidencia.getCantidadPagada());
            preparedStatement.executeUpdate();
            System.out.println("Incidencia creada");
            return true;
        } catch (SQLException e) {
            System.out.println("Error al crear incidencia: " + e);
        }
        return false;
    }

    public void actualizar(Incidencias incidencia) {
        String query = "UPDATE INCIDENCIAS SET tipo = ?, cantidadPagada = ? WHERE id_incidencias = ?";
        try (var preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setString(1, incidencia.getTipo());
            preparedStatement.setDouble(2, incidencia.getCantidadPagada());
            preparedStatement.setInt(3, incidencia.getId_incidencias());
            preparedStatement.executeUpdate();
            System.out.println("Incidencia actualizada");
        } catch (SQLException e) {
            System.out.println("Error al actualizar incidencia: " + e);
        }
    }

    public void eliminar(int id_incidencia) {
        String query = "DELETE FROM INCIDENCIAS WHERE id_incidencias = ?";
        try (var preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setInt(1, id_incidencia);
            preparedStatement.executeUpdate();
            System.out.println("Incidencia eliminada");
        } catch (SQLException e) {
            System.out.println("Error al eliminar incidencia: " + e);
        }
    }

    public List<Incidencias> listar() {
        var incidenciasList = new ArrayList<Incidencias>();
        try (var stmt = conexion.createStatement();
             var resultSet = stmt.executeQuery("SELECT * FROM INCIDENCIAS")) {

            while (resultSet.next()) {
                var id_incidencias = resultSet.getInt("id_incidencias");
                var id_prestamos = resultSet.getInt("id_prestamos");
                var tipo = resultSet.getString("tipo");
                var cantidadPagada = resultSet.getDouble("cantidadPagada");

                Prestamos prestamos = obtenerPrestamosPorId(id_prestamos);

                var incidencia = new Incidencias(id_incidencias, prestamos, tipo, cantidadPagada);
                incidenciasList.add(incidencia);
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar incidencias: " + e);
        }
        return incidenciasList;
    }

    public Optional<Incidencias> obtenerIncidencia(int id_incidencia) {
        String query = "SELECT * FROM INCIDENCIAS WHERE id_incidencias = ?";
        Incidencias incidencia = null;

        try (var preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setInt(1, id_incidencia);

            try (var resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    var id_prestamos = resultSet.getInt("id_prestamos");
                    var tipo = resultSet.getString("tipo");
                    var cantidadPagada = resultSet.getDouble("cantidadPagada");

                    Prestamos prestamos = obtenerPrestamosPorId(id_prestamos);

                    incidencia = new Incidencias(id_incidencia, prestamos, tipo, cantidadPagada);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar incidencia: " + e);
        }

        return Optional.ofNullable(incidencia);
    }

    // Método para obtener un objeto Prestamos por su ID
    private Prestamos obtenerPrestamosPorId(int id_prestamos) {
        // Debes implementar este método o usar la clase PrestamosDB para obtener el objeto
        // Prestamos por su ID.
        // Ejemplo: PrestamosDB prestamosDB = new PrestamosDB(conexion);
        // return prestamosDB.obtenerPrestamosPorId(id_prestamos);
        return null; // Implementa la lógica adecuada aquí.
    }
}

