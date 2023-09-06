/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

/**
 *
 * @author moisibot
 */

import Modelo.Bibliotecas;
import Modelo.Libros;
import Modelo.Recepcionista;
import Modelo.SolicitudesdePrestamos;
import Modelo.Transportista;
import Modelo.UsuarioFinal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class SolicitudesdePrestamosDAO {
    private Connection conexion;

    public SolicitudesdePrestamosDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public boolean crear(SolicitudesdePrestamos solicitudPrestamo) {
        String query = "INSERT INTO SOLICITUDES_PRESTAMOS (id_biblioteca, id_usuariofinal, id_transportista, id_recepcionista, tipo, estado, fecha, ISBN) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (var preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setInt(1, solicitudPrestamo.getId_biblioteca().getId_biblioteca());
            preparedStatement.setInt(2, solicitudPrestamo.getId_usuariofinal().getIdUsuarioFinal());
            preparedStatement.setInt(3, solicitudPrestamo.getId_transportista().getId_transportista());
            preparedStatement.setInt(4, solicitudPrestamo.getId_recepcionista().getId_recepcionista());
            preparedStatement.setString(5, solicitudPrestamo.getTipo().toString());
            preparedStatement.setBoolean(6, solicitudPrestamo.isEstado());
            preparedStatement.setDate(7, new java.sql.Date(solicitudPrestamo.getFecha().getTime()));
            preparedStatement.setString(8, solicitudPrestamo.getISBN().getISBN());
            preparedStatement.executeUpdate();
            System.out.println("Solicitud de préstamo creada");
            return true;
        } catch (SQLException e) {
            System.out.println("Error al crear solicitud de préstamo: " + e);
        }
        return false;
    }

    public void actualizar(SolicitudesdePrestamos solicitudPrestamo) {
        String query = "UPDATE SOLICITUDES_PRESTAMOS SET id_biblioteca = ?, id_usuariofinal = ?, id_transportista = ?, id_recepcionista = ?, tipo = ?, estado = ?, fecha = ?, ISBN = ? WHERE id_solicitud = ?";
        try (var preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setInt(1, solicitudPrestamo.getId_biblioteca().getId_biblioteca());
            preparedStatement.setInt(2, solicitudPrestamo.getId_usuariofinal().getIdUsuarioFinal());
            preparedStatement.setInt(3, solicitudPrestamo.getId_transportista().getId_transportista());
            preparedStatement.setInt(4, solicitudPrestamo.getId_recepcionista().getId_recepcionista());
            preparedStatement.setString(5, solicitudPrestamo.getTipo().toString());
            preparedStatement.setBoolean(6, solicitudPrestamo.isEstado());
            preparedStatement.setDate(7, new java.sql.Date(solicitudPrestamo.getFecha().getTime()));
            preparedStatement.setString(8, solicitudPrestamo.getISBN().getISBN());
            preparedStatement.setInt(9, solicitudPrestamo.getId_solicitud());
            preparedStatement.executeUpdate();
            System.out.println("Solicitud de préstamo actualizada");
        } catch (SQLException e) {
            System.out.println("Error al actualizar solicitud de préstamo: " + e);
        }
    }

    public void eliminar(int id_solicitud) {
        String query = "DELETE FROM SOLICITUDES_PRESTAMOS WHERE id_solicitud = ?";
        try (var preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setInt(1, id_solicitud);
            preparedStatement.executeUpdate();
            System.out.println("Solicitud de préstamo eliminada");
        } catch (SQLException e) {
            System.out.println("Error al eliminar solicitud de préstamo: " + e);
        }
    }

    public List<SolicitudesdePrestamos> listar() {
        var solicitudesPrestamoList = new ArrayList<SolicitudesdePrestamos>();
        try (var stmt = conexion.createStatement();
             var resultSet = stmt.executeQuery("SELECT * FROM SOLICITUDES_PRESTAMOS")) {

            while (resultSet.next()) {
                var id_solicitud = resultSet.getInt("id_solicitud");
                var id_biblioteca = resultSet.getInt("id_biblioteca");
                var id_usuariofinal = resultSet.getInt("id_usuariofinal");
                var id_transportista = resultSet.getInt("id_transportista");
                var id_recepcionista = resultSet.getInt("id_recepcionista");
                var tipoStr = resultSet.getString("tipo");
                var estado = resultSet.getBoolean("estado");
                var fecha = resultSet.getDate("fecha");
                var ISBN = resultSet.getString("ISBN");

                // Convierte el valor de tipo String en el enum TipoEntrega
                SolicitudesdePrestamos.TipoEntrega tipo = SolicitudesdePrestamos.TipoEntrega.valueOf(tipoStr);

                // Debes implementar la lógica para obtener los objetos correspondientes
                Bibliotecas biblioteca = obtenerBibliotecaPorId(id_biblioteca);
                UsuarioFinal usuarioFinal = obtenerUsuarioFinalPorId(id_usuariofinal);
                Transportista transportista = obtenerTransportistaPorId(id_transportista);
                Recepcionista recepcionista = obtenerRecepcionistaPorId(id_recepcionista);
                Libros libros = obtenerLibrosPorISBN(ISBN);

                var solicitudPrestamo = new SolicitudesdePrestamos(id_solicitud, biblioteca, usuarioFinal, transportista, recepcionista, tipo, estado, fecha, libros);
                solicitudesPrestamoList.add(solicitudPrestamo);
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar solicitudes de préstamo: " + e);
        }
        return solicitudesPrestamoList;
    }

    public Optional<SolicitudesdePrestamos> obtenerSolicitudPrestamo(int id_solicitud) {
        String query = "SELECT * FROM SOLICITUDES_PRESTAMOS WHERE id_solicitud = ?";
        SolicitudesdePrestamos solicitudPrestamo = null;

        try (var preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setInt(1, id_solicitud);

            try (var resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    var id_biblioteca = resultSet.getInt("id_biblioteca");
                    var id_usuariofinal = resultSet.getInt("id_usuariofinal");
                    var id_transportista = resultSet.getInt("id_transportista");
                    var id_recepcionista = resultSet.getInt("id_recepcionista");
                    var tipoStr = resultSet.getString("tipo");
                    var estado = resultSet.getBoolean("estado");
                    var fecha = resultSet.getDate("fecha");
                    var ISBN = resultSet.getString("ISBN");

                    // Convierte el valor de tipo String en el enum TipoEntrega
                    SolicitudesdePrestamos.TipoEntrega tipo = SolicitudesdePrestamos.TipoEntrega.valueOf(tipoStr);

                    // Debes implementar la lógica para obtener los objetos correspondientes
                    Bibliotecas biblioteca = obtenerBibliotecaPorId(id_biblioteca);
                    UsuarioFinal usuarioFinal = obtenerUsuarioFinalPorId(id_usuariofinal);
                    Transportista transportista = obtenerTransportistaPorId(id_transportista);
                    Recepcionista recepcionista = obtenerRecepcionistaPorId(id_recepcionista);
                    Libros libros = obtenerLibrosPorISBN(ISBN);

                    solicitudPrestamo = new SolicitudesdePrestamos(id_solicitud, biblioteca, usuarioFinal, transportista, recepcionista, tipo, estado, fecha, libros);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar solicitud de préstamo: " + e);
        }

        return Optional.ofNullable(solicitudPrestamo);
    }

    // Implementa los métodos para obtener los objetos correspondientes por su ID
    private Bibliotecas obtenerBibliotecaPorId(int id_biblioteca) {
        // Implementa la lógica para obtener una biblioteca por su ID
        // Puedes usar una clase BibliotecasDB o una consulta SQL aquí
        return null;
    }

    private UsuarioFinal obtenerUsuarioFinalPorId(int id_usuariofinal) {
        // Implementa la lógica para obtener un usuario final por su ID
        // Puedes usar una clase UsuarioFinalDB o una consulta SQL aquí
        return null;
    }

    private Transportista obtenerTransportistaPorId(int id_transportista) {
        // Implementa la lógica para obtener un transportista por su ID
        // Puedes usar una clase TransportistaDB o una consulta SQL aquí
        return null;
    }

    private Recepcionista obtenerRecepcionistaPorId(int id_recepcionista) {
        // Implementa la lógica para obtener un recepcionista por su ID
        // Puedes usar una clase RecepcionistaDB o una consulta SQL aquí
        return null;
    }

    private Libros obtenerLibrosPorISBN(String ISBN) {
        // Implementa la lógica para obtener un libro por su ISBN
        // Puedes usar una clase LibrosDB o una consulta SQL aquí
        return null;
    }
}

