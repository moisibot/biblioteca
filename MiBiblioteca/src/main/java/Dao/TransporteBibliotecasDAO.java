
package Dao;

/**
 *
 * @author moisibot
 */

import Modelo.Bibliotecas;
import Modelo.Recepcionista;
import Modelo.TransporteBibliotecas;
import Modelo.Transportista;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class TransporteBibliotecasDAO {
    private Connection conexion;

    public TransporteBibliotecasDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public boolean crear(TransporteBibliotecas transporte) {
        String query = "INSERT INTO TRANSPORTE_BIBLIOTECAS (id_biblioteca_origen, id_biblioteca_destino, id_recepcionista, id_transportista, fecha, estado) VALUES (?, ?, ?, ?, ?, ?)";
        try (var preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setInt(1, transporte.getId_biblioteca_origen().getId_biblioteca());
            preparedStatement.setInt(2, transporte.getId_biblioteca_destino().getId_biblioteca());
            preparedStatement.setInt(3, transporte.getId_recepcionista().getId_recepcionista());
            preparedStatement.setInt(4, transporte.getId_transportista().getId_transportista());
            preparedStatement.setDate(5, new java.sql.Date(transporte.getFecha().getTime()));
            preparedStatement.setBoolean(6, transporte.isEstado());
            preparedStatement.executeUpdate();
            System.out.println("Transporte entre bibliotecas creado");
            return true;
        } catch (SQLException e) {
            System.out.println("Error al crear transporte entre bibliotecas: " + e);
        }
        return false;
    }

    public void actualizar(TransporteBibliotecas transporte) {
        String query = "UPDATE TRANSPORTE_BIBLIOTECAS SET id_biblioteca_origen = ?, id_biblioteca_destino = ?, id_recepcionista = ?, id_transportista = ?, fecha = ?, estado = ? WHERE id_tb = ?";
        try (var preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setInt(1, transporte.getId_biblioteca_origen().getId_biblioteca());
            preparedStatement.setInt(2, transporte.getId_biblioteca_destino().getId_biblioteca());
            preparedStatement.setInt(3, transporte.getId_recepcionista().getId_recepcionista());
            preparedStatement.setInt(4, transporte.getId_transportista().getId_transportista());
            preparedStatement.setDate(5, new java.sql.Date(transporte.getFecha().getTime()));
            preparedStatement.setBoolean(6, transporte.isEstado());
            preparedStatement.setInt(7, transporte.getId_tb());
            preparedStatement.executeUpdate();
            System.out.println("Transporte entre bibliotecas actualizado");
        } catch (SQLException e) {
            System.out.println("Error al actualizar transporte entre bibliotecas: " + e);
        }
    }

    public void eliminar(int id_tb) {
        String query = "DELETE FROM TRANSPORTE_BIBLIOTECAS WHERE id_tb = ?";
        try (var preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setInt(1, id_tb);
            preparedStatement.executeUpdate();
            System.out.println("Transporte entre bibliotecas eliminado");
        } catch (SQLException e) {
            System.out.println("Error al eliminar transporte entre bibliotecas: " + e);
        }
    }

    public List<TransporteBibliotecas> listar() {
        var transportesList = new ArrayList<TransporteBibliotecas>();
        try (var stmt = conexion.createStatement();
             var resultSet = stmt.executeQuery("SELECT * FROM TRANSPORTE_BIBLIOTECAS")) {

            while (resultSet.next()) {
                var id_tb = resultSet.getInt("id_tb");
                var id_biblioteca_origen = resultSet.getInt("id_biblioteca_origen");
                var id_biblioteca_destino = resultSet.getInt("id_biblioteca_destino");
                var id_recepcionista = resultSet.getInt("id_recepcionista");
                var id_transportista = resultSet.getInt("id_transportista");
                var fecha = resultSet.getDate("fecha");
                var estado = resultSet.getBoolean("estado");

                Bibliotecas bibliotecaOrigen = obtenerBibliotecaPorId(id_biblioteca_origen);
                Bibliotecas bibliotecaDestino = obtenerBibliotecaPorId(id_biblioteca_destino);
                Recepcionista recepcionista = obtenerRecepcionistaPorId(id_recepcionista);
                Transportista transportista = obtenerTransportistaPorId(id_transportista);

                var transporte = new TransporteBibliotecas(id_tb, bibliotecaOrigen, bibliotecaDestino, recepcionista, transportista, fecha, estado);
                transportesList.add(transporte);
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar transportes entre bibliotecas: " + e);
        }
        return transportesList;
    }

    public Optional<TransporteBibliotecas> obtenerPorId(int id_tb) {
        TransporteBibliotecas transporte = null;
        try (var preparedStatement = conexion.prepareStatement("SELECT * FROM TRANSPORTE_BIBLIOTECAS WHERE id_tb = ?")) {
            preparedStatement.setInt(1, id_tb);
            try (var resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    var id_biblioteca_origen = resultSet.getInt("id_biblioteca_origen");
                    var id_biblioteca_destino = resultSet.getInt("id_biblioteca_destino");
                    var id_recepcionista = resultSet.getInt("id_recepcionista");
                    var id_transportista = resultSet.getInt("id_transportista");
                    var fecha = resultSet.getDate("fecha");
                    var estado = resultSet.getBoolean("estado");

                    Bibliotecas bibliotecaOrigen = obtenerBibliotecaPorId(id_biblioteca_origen);
                    Bibliotecas bibliotecaDestino = obtenerBibliotecaPorId(id_biblioteca_destino);
                    Recepcionista recepcionista = obtenerRecepcionistaPorId(id_recepcionista);
                    Transportista transportista = obtenerTransportistaPorId(id_transportista);

                    transporte = new TransporteBibliotecas(id_tb, bibliotecaOrigen, bibliotecaDestino, recepcionista, transportista, fecha, estado);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar transporte entre bibliotecas por ID: " + e);
        }
        return Optional.ofNullable(transporte);
    }

    // Implementa los métodos para obtener los objetos correspondientes por su ID
    private Bibliotecas obtenerBibliotecaPorId(int id_biblioteca) {
        // Implementa la lógica para obtener una biblioteca por su ID
        // Puedes usar una clase BibliotecasDB o una consulta SQL aquí
        return null;
    }

    private Recepcionista obtenerRecepcionistaPorId(int id_recepcionista) {
        // Implementa la lógica para obtener un recepcionista por su ID
        // Puedes usar una clase RecepcionistaDB o una consulta SQL aquí
        return null;
    }

    private Transportista obtenerTransportistaPorId(int id_transportista) {
        // Implementa la lógica para obtener un transportista por su ID
        // Puedes usar una clase TransportistaDB o una consulta SQL aquí
        return null;
    }
}
