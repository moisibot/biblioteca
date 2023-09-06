/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

/**
 *
 * @author moisibot
 */

import Modelo.SolicitudesRevocacion;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SolicitudesRevocacionDAO {
    private Connection conexion;

    public SolicitudesRevocacionDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public boolean crear(SolicitudesRevocacion solicitudRevocacion) {
        String query = "INSERT INTO SOLICITUDES_REVOCACION (id_usuarioFinal, estado, detalle) VALUES (?, ?, ?)";
        try (var preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setString(1, solicitudRevocacion.getId_usuarioFinal().getIdUsuario());
            preparedStatement.setString(2, solicitudRevocacion.getEstado());
            preparedStatement.setString(3, solicitudRevocacion.getDetalle());
            preparedStatement.executeUpdate();
            System.out.println("Solicitud de revocación creada");
            return true;
        } catch (SQLException e) {
            System.out.println("Error al crear solicitud de revocación: " + e);
        }
        return false;
    }

    public void actualizar(SolicitudesRevocacion solicitudRevocacion) {
        String query = "UPDATE SOLICITUDES_REVOCACION SET id_usuarioFinal = ?, estado = ?, detalle = ? WHERE id_solicitudRevocacion = ?";
        try (var preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setString(1, solicitudRevocacion.getId_usuarioFinal().getIdUsuario());
            preparedStatement.setString(2, solicitudRevocacion.getEstado());
            preparedStatement.setString(3, solicitudRevocacion.getDetalle());
            preparedStatement.setInt(4, solicitudRevocacion.getId_solicitudRevocacion());
            preparedStatement.executeUpdate();
            System.out.println("Solicitud de revocación actualizada");
        } catch (SQLException e) {
            System.out.println("Error al actualizar solicitud de revocación: " + e);
        }
    }

    public void eliminar(int id_solicitudRevocacion) {
        String query = "DELETE FROM SOLICITUDES_REVOCACION WHERE id_solicitudRevocacion = ?";
        try (var preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setInt(1, id_solicitudRevocacion);
            preparedStatement.executeUpdate();
            System.out.println("Solicitud de revocación eliminada");
        } catch (SQLException e) {
            System.out.println("Error al eliminar solicitud de revocación: " + e);
        }
    }

    public List<SolicitudesRevocacion> listar() {
        var solicitudesRevocacionList = new ArrayList<SolicitudesRevocacion>();
        try (var stmt = conexion.createStatement();
             var resultSet = stmt.executeQuery("SELECT * FROM SOLICITUDES_REVOCACION")) {

            while (resultSet.next()) {
                var id_solicitudRevocacion = resultSet.getInt("id_solicitudRevocacion");
                var id_usuarioFinal = resultSet.getInt("id_usuarioFinal");
                var estado = resultSet.getString("estado");
                var detalle = resultSet.getString("detalle");

                Usuario usuarioFinal = obtenerUsuarioPorId(id_usuarioFinal);

                var solicitudRevocacion = new SolicitudesRevocacion(id_solicitudRevocacion, usuarioFinal, estado, detalle);
                solicitudesRevocacionList.add(solicitudRevocacion);
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar solicitudes de revocación: " + e);
        }
        return solicitudesRevocacionList;
    }

    public Optional<SolicitudesRevocacion> obtenerSolicitudRevocacion(int id_solicitudRevocacion) {
        String query = "SELECT * FROM SOLICITUDES_REVOCACION WHERE id_solicitudRevocacion = ?";
        SolicitudesRevocacion solicitudRevocacion = null;

        try (var preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setInt(1, id_solicitudRevocacion);

            try (var resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    var id_usuarioFinal = resultSet.getInt("id_usuarioFinal");
                    var estado = resultSet.getString("estado");
                    var detalle = resultSet.getString("detalle");

                    Usuario usuarioFinal = obtenerUsuarioPorId(id_usuarioFinal);

                    solicitudRevocacion = new SolicitudesRevocacion(id_solicitudRevocacion, usuarioFinal, estado, detalle);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar solicitud de revocación: " + e);
        }

        return Optional.ofNullable(solicitudRevocacion);
    }

    // Método para obtener un objeto Usuario por su ID
    private Usuario obtenerUsuarioPorId(int id_usuario) {
        // Debes implementar este método o usar la clase UsuarioDB para obtener el objeto
        // Usuario por su ID.
        // Ejemplo: UsuarioDB usuarioDB = new UsuarioDB(conexion);
        // return usuarioDB.obtenerUsuarioPorId(id_usuario);
        return null; // Implementa la lógica adecuada aquí.
    }
}


