
package Dao;

/**
 *
 * @author moisibot
 */

import Modelo.TransporteUsuarios;
import Modelo.Bibliotecas;
import Modelo.Libros;
import Modelo.UsuarioFinal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class TransporteUsuariosDAO {
    private Connection conexion;

    public TransporteUsuariosDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public boolean crear(TransporteUsuarios transporte) {
        String query = "INSERT INTO TRANSPORTE_USUARIOS (id_biblioteca, id_usuarioFinal, ISBN, fecha, estado, multa) VALUES (?, ?, ?, ?, ?, ?)";
        try (var preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setInt(1, transporte.getId_biblioteca().getId_biblioteca());
            preparedStatement.setInt(2, transporte.getId_usuarioFinal().getId_usuarioFinal());
            preparedStatement.setString(3, transporte.getISBN().getISBN());
            preparedStatement.setDate(4, new java.sql.Date(transporte.getFecha().getTime()));
            preparedStatement.setBoolean(5, transporte.isEstado());
            preparedStatement.setDouble(6, transporte.getMulta());
            preparedStatement.executeUpdate();
            System.out.println("Transporte de usuarios creado");
            return true;
        } catch (SQLException e) {
            System.out.println("Error al crear transporte de usuarios: " + e);
        }
        return false;
    }

    public void actualizar(TransporteUsuarios transporte) {
        String query = "UPDATE TRANSPORTE_USUARIOS SET id_biblioteca = ?, id_usuarioFinal = ?, ISBN = ?, fecha = ?, estado = ?, multa = ? WHERE id_transporte = ?";
        try (var preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setInt(1, transporte.getId_biblioteca().getId_biblioteca());
            preparedStatement.setInt(2, transporte.getId_usuarioFinal().getId_usuarioFinal());
            preparedStatement.setString(3, transporte.getISBN().getISBN());
            preparedStatement.setDate(4, new java.sql.Date(transporte.getFecha().getTime()));
            preparedStatement.setBoolean(5, transporte.isEstado());
            preparedStatement.setDouble(6, transporte.getMulta());
            preparedStatement.setInt(7, transporte.getId_transporte());
            preparedStatement.executeUpdate();
            System.out.println("Transporte de usuarios actualizado");
        } catch (SQLException e) {
            System.out.println("Error al actualizar transporte de usuarios: " + e);
        }
    }

    public void eliminar(int id_transporte) {
        String query = "DELETE FROM TRANSPORTE_USUARIOS WHERE id_transporte = ?";
        try (var preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setInt(1, id_transporte);
            preparedStatement.executeUpdate();
            System.out.println("Transporte de usuarios eliminado");
        } catch (SQLException e) {
            System.out.println("Error al eliminar transporte de usuarios: " + e);
        }
    }

    public List<TransporteUsuarios> listar() {
        var transportesList = new ArrayList<TransporteUsuarios>();
        try (var stmt = conexion.createStatement();
             var resultSet = stmt.executeQuery("SELECT * FROM TRANSPORTE_USUARIOS")) {

            while (resultSet.next()) {
                var id_transporte = resultSet.getInt("id_transporte");
                var id_biblioteca = resultSet.getInt("id_biblioteca");
                var id_usuarioFinal = resultSet.getInt("id_usuarioFinal");
                var ISBN = resultSet.getString("ISBN");
                var fecha = resultSet.getDate("fecha");
                var estado = resultSet.getBoolean("estado");
                var multa = resultSet.getDouble("multa");

                Bibliotecas biblioteca = obtenerBibliotecaPorId(id_biblioteca);
                UsuarioFinal usuarioFinal = obtenerUsuarioFinalPorId(id_usuarioFinal);
                Libros libros = obtenerLibrosPorISBN(ISBN);

                var transporte = new TransporteUsuarios(id_transporte, biblioteca, usuarioFinal, libros, fecha, estado, multa);
                transportesList.add(transporte);
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar transportes de usuarios: " + e);
        }
        return transportesList;
    }

    public Optional<TransporteUsuarios> obtenerPorId(int id_transporte) {
        TransporteUsuarios transporte = null;
        try (var preparedStatement = conexion.prepareStatement("SELECT * FROM TRANSPORTE_USUARIOS WHERE id_transporte = ?")) {
            preparedStatement.setInt(1, id_transporte);
            try (var resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    var id_biblioteca = resultSet.getInt("id_biblioteca");
                    var id_usuarioFinal = resultSet.getInt("id_usuarioFinal");
                    var ISBN = resultSet.getString("ISBN");
                    var fecha = resultSet.getDate("fecha");
                    var estado = resultSet.getBoolean("estado");
                    var multa = resultSet.getDouble("multa");

                    Bibliotecas biblioteca = obtenerBibliotecaPorId(id_biblioteca);
                    UsuarioFinal usuarioFinal = obtenerUsuarioFinalPorId(id_usuarioFinal);
                    Libros libros = obtenerLibrosPorISBN(ISBN);

                    transporte = new TransporteUsuarios(id_transporte, biblioteca, usuarioFinal, libros, fecha, estado, multa);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar transporte de usuarios por ID: " + e);
        }
        return Optional.ofNullable(transporte);
    }

    // Implementa los métodos para obtener los objetos correspondientes por su ID
    private Bibliotecas obtenerBibliotecaPorId(int id_biblioteca) {
        // Implementa la lógica para obtener una biblioteca por su ID
        // Puedes usar una clase BibliotecasDB o una consulta SQL aquí
        return null;
    }

    private UsuarioFinal obtenerUsuarioFinalPorId(int id_usuarioFinal) {
        // Implementa la lógica para obtener un usuario final por su ID
        // Puedes usar una clase UsuarioFinalDB o una consulta SQL aquí
        return null;
    }

    private Libros obtenerLibrosPorISBN(String ISBN) {
        // Implementa la lógica para obtener un libro por su ISBN
        // Puedes usar una clase LibrosDB o una consulta SQL aquí
        return null;
    }
}

